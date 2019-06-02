package com.sajeev.wf.service;

import com.sajeev.wf.bom.WorkflowRequest;
import com.sajeev.wf.bom.WorkflowResponse;
import com.sajeev.wf.exception.WorkflowException;

public interface WorkflowService {

	public WorkflowResponse processWorflowRequest(WorkflowRequest wfRequest) throws WorkflowException;
}
