package com.sajeev.wf.base;

import java.io.Serializable;

import com.sajeev.wf.bom.RequestModel;
import com.sajeev.wf.bom.ResponseModel;

/**
 * interface:WorkflowContext
 */
public interface WorkflowContext extends Serializable {

	/**
	 * Activly informs the workflow process to stop processing no further activities will be exeecuted
	 * 
	 * @return
	 */
	public boolean stopProcess();

	/**
	 * Provide seed information to this ProcessContext, usually provided at time of workflow kickoff by the containing workflow processor.
	 * 
	 * @param seedObject
	 *            - initial seed data for the workflow
	 */
	public void setRequestModel(RequestModel requestModel);
	
	public RequestModel getRequestModel();

	
	public ResponseModel getResponseModel();

}
