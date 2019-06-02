package com.sajeev.wf.vehicle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sajeev.wf.base.ErrorHandler;
import com.sajeev.wf.base.WorkflowContext;
import com.sajeev.wf.bom.component.Status;
import com.sajeev.wf.constant.RequestStatus;
import com.sajeev.wf.constant.ServiceErrorConstants;
import com.sajeev.wf.domain.BusinessEventLog;
import com.sajeev.wf.exception.WorkflowException;


public class VehicleErrorHandler implements ErrorHandler {

	private Log log = LogFactory.getLog(VehicleErrorHandler.class);

	@SuppressWarnings("unused")
	private String beanName ;

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	@Override
	public void handleError(WorkflowContext context, Throwable th) throws WorkflowException {
		
		log.error("Handling Error: ", th);

		VehicleWorkflowContext bbContext = (VehicleWorkflowContext) context ;

		String statusCode = "" ;
		String errorCode = "";

		if(th instanceof WorkflowException ){
			statusCode = RequestStatus.FAILURE ;
			errorCode = ((WorkflowException)th).getErrorCode() ;
		}else{
			statusCode = RequestStatus.FAILURE ;
			errorCode = ServiceErrorConstants.INTERNAL_SERVER_ERROR ;
		}

		Status status = new Status();
		status.setStatusCode(statusCode);
		status.setErrorCode(errorCode);
		context.getResponseModel().setStatus(status);
		
		BusinessEventLog log = bbContext.getBusinessEventLog();
		if(log!=null){
			log.setStatus(statusCode);
			log.setErrorCode(errorCode);
		}

		bbContext.setStopProcess(true);
	}

}
