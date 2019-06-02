package com.sajeev.wf.vehicle;


import org.apache.log4j.Logger;

import com.sajeev.wf.base.BaseActivity;
import com.sajeev.wf.base.WorkflowContext;
import com.sajeev.wf.bom.WorkflowRequest;
import com.sajeev.wf.bom.WorkflowResponse;
import com.sajeev.wf.bom.component.Status;
import com.sajeev.wf.constant.RequestStatus;
import com.sajeev.wf.exception.WorkflowException;

public class ProcessVehicleActivity extends BaseActivity {

	/** The Constant ACTIVITY_NAME. */
	private static final String ACTIVITY_NAME = ProcessVehicleActivity.class.getName();

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(ProcessVehicleActivity.class);
	
	@Override
	public WorkflowContext execute(WorkflowContext context) throws WorkflowException {
		
		LOG.info("Executing " + ACTIVITY_NAME + "...");
		
		VehicleWorkflowContext oContext = (VehicleWorkflowContext) context;
		
		WorkflowRequest loginRequest = (WorkflowRequest) oContext.getRequestModel();
		
		WorkflowResponse loginResponse = (WorkflowResponse) oContext.getResponseModel();
		
		loginResponse.setWorkflowId(loginRequest.getWorkflowId());
		
		loginResponse.setWorkflowName("WF-112221");
		
		loginResponse.setWorkflowData("WF Data");
		
		Status status = new Status();
		status.setStatusCode(RequestStatus.SUCCESS);
		
		loginResponse.setStatus(status);
		
		LOG.info("Execution of " + ACTIVITY_NAME + " completed.");
		return context;
	}

}
