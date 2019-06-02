package com.sajeev.wf.base;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.ListableBeanFactory;

import com.sajeev.wf.bom.RequestModel;
import com.sajeev.wf.bom.ResponseModel;
import com.sajeev.wf.exception.WorkflowException;

/**
 * Class:SequenceWorkflow
 */
public class SequenceWorkflow extends BaseWorkflow {

	// private ProcessContextLocator processContextLocator;
	private Log logger = LogFactory.getLog(SequenceWorkflow.class);
	private Class<?> workFlowContextClass;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.iocworkflow.BaseProcessor#supports(java.lang.Class)
	 */
	public boolean supports(Activity activity) {

		return (activity instanceof BaseActivity);
	}

	public ResponseModel doActivities() throws WorkflowException {
		return doActivities(null);
	}

	public ResponseModel doActivities(RequestModel requestModel) throws WorkflowException {

		if (logger.isDebugEnabled())
			logger.debug(getBeanName() + " processor is running..");

		// retrieve injected by Spring
		List<Activity> activities = getActivities();
		// retrieve a new instance of the Workflow ProcessContext
		WorkflowContext context = createContext();
		if (requestModel != null)
			context.setRequestModel(requestModel);
		for (Iterator<Activity> it = activities.iterator(); it.hasNext();) {
			Activity activity = it.next();
			if (logger.isDebugEnabled())
				logger.debug("running activity:" + activity.getBeanName() + " using arguments:" + context);
			try {
				context = activity.execute(context);
			} catch (Throwable th) {
				th.printStackTrace();
				ErrorHandler errorHandler = activity.getErrorHandler();
				if (errorHandler == null) {
					logger.info("no error handler for this action, run default error" + "handler and abort processing ");
					getDefaultErrorHandler().handleError(context, th);
					break;
				} else {
					logger.info("run error handler and continue");
					errorHandler.handleError(context, th);
				}
			}
			// ensure its ok to continue the process
			if (processShouldStop(context, activity))
				break;
		}
		
		logger.debug(getBeanName() + " processor is done.");
		return context.getResponseModel();
	}

	/**
	 * Determine if the process should stop
	 * 
	 * @param context
	 *            the current process context
	 * @param activity
	 *            the current activity in the iteration
	 */
	private boolean processShouldStop(WorkflowContext context, Activity activity) {
		if (context != null && context.stopProcess()) {
			logger.info("Interrupted workflow as requested by:" + activity.getBeanName());
			return true;
		}
		return false;
	}

	private WorkflowContext createContext() {
		return (WorkflowContext) BeanFactoryUtils.beanOfTypeIncludingAncestors((ListableBeanFactory) getBeanFactory(), workFlowContextClass);
	}

	public void setWorkFlowContextClass(Class<?> workFlowContextClass) {
		this.workFlowContextClass = workFlowContextClass;
	}
}