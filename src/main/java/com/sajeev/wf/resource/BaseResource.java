package com.sajeev.wf.resource;

import com.sajeev.wf.bom.ResponseModel;
import com.sajeev.wf.bom.component.Status;
import com.sajeev.wf.constant.RequestStatus;
import com.sajeev.wf.constant.ServiceErrorConstants;
import com.sajeev.wf.exception.WorkflowException;

/**
 * The Class BaseController.
 */
public class BaseResource {
	
	/**
	 * Handle exceptions.
	 *
	 * @param response the response
	 * @param exception the exception
	 * @return the response model
	 */
	protected ResponseModel handleExceptions(ResponseModel response, Exception exception) {

		Status status = new Status();
		status.setStatusCode(RequestStatus.FAILURE);
		status.setErrorCode(ServiceErrorConstants.INTERNAL_SERVER_ERROR);
		status.setErrorMessage("Error While Processing Workflow");
		
		response.setStatus(status);
		
		return response;
	}


	/**
	 * Handle checked exceptions.
	 *
	 * @param response the response
	 * @param e the e
	 * @return the response model
	 */
	protected ResponseModel handleCheckedExceptions(ResponseModel response, WorkflowException e) {
		
		Status status = new Status();
		status.setStatusCode(RequestStatus.FAILURE);
		status.setErrorCode(e.getErrorCode());
		status.setErrorMessage("Error While Processing Workflow");
		
		response.setStatus(status);
		
		return response;
	}

}
