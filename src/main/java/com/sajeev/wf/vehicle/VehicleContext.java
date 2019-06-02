package com.sajeev.wf.vehicle;

import com.sajeev.wf.bom.RequestModel;
import com.sajeev.wf.bom.ResponseModel;
import com.sajeev.wf.bom.WorkflowRequest;
import com.sajeev.wf.bom.WorkflowResponse;

public class VehicleContext extends VehicleWorkflowContext {

	private static final long serialVersionUID = 5595491437330963872L;
	
	private WorkflowRequest wfRequest;
	
	private WorkflowResponse wfResponse = new WorkflowResponse();

	@Override
	public void setRequestModel(RequestModel requestModel) {
		this.wfRequest = (WorkflowRequest) requestModel;
	}

	@Override
	public RequestModel getRequestModel() {
		return wfRequest;
	}

	@Override
	public ResponseModel getResponseModel() {
		return wfResponse;
	}

}
