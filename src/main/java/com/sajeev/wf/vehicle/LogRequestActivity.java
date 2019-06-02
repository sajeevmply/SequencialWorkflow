package com.sajeev.wf.vehicle;

import java.util.Date;

import org.apache.log4j.Logger;

import com.sajeev.wf.base.BaseActivity;
import com.sajeev.wf.base.WorkflowContext;
import com.sajeev.wf.bom.RequestModel;
import com.sajeev.wf.constant.ServiceErrorConstants;
import com.sajeev.wf.domain.BusinessEventLog;
import com.sajeev.wf.exception.WorkflowException;

/**
 * The Class LogRequestActivity.
 */
public class LogRequestActivity extends BaseActivity {
	
	/** The Constant ACTIVITY_NAME. */
	private static final String ACTIVITY_NAME = LogRequestActivity.class.getName();

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(LogRequestActivity.class);

	/*@Resource
	private Map<String, RequestType> requestMap ;*/
	
	@Override
	public WorkflowContext execute(WorkflowContext context) throws WorkflowException {
		
		LOG.info("Executing " + ACTIVITY_NAME + "...");
		
		if(context instanceof VehicleWorkflowContext){
		
			VehicleWorkflowContext remitContext = (VehicleWorkflowContext) context;
			
			String requestType = getRequestType(remitContext.getRequestModel());
			
			BusinessEventLog businessEvent = new BusinessEventLog();
			businessEvent.setCreatedBy(context.getRequestModel().getFunctionalId());
			businessEvent.setCreatedDate(new Date());
			businessEvent.setRequestType(requestType);
			
			remitContext.setBusinessEventLog(businessEvent);
		}
		else{
			throw new WorkflowException(ServiceErrorConstants.UNKNOWN_CONTEXT);
		}

		LOG.info("Execution of " + ACTIVITY_NAME + " completed.");
		return context;
	}

	private String getRequestType(RequestModel requestModel) throws WorkflowException{
		
		String requestClazz = requestModel.getClass().getName();
		
		/*if( ! requestMap.containsKey(requestClazz)){
			throw new WorkflowException(ServiceErrorConstants.UNKNOWN_REQUEST);
		}
		
		return requestMap.get(requestClazz).getName();*/
		return "login";
	}

}
