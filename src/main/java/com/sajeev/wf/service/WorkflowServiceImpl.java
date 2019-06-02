package com.sajeev.wf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sajeev.wf.base.SequenceWorkflow;
import com.sajeev.wf.bom.WorkflowRequest;
import com.sajeev.wf.bom.WorkflowResponse;
import com.sajeev.wf.exception.WorkflowException;

@Service
public class WorkflowServiceImpl implements WorkflowService {

	@Autowired
	private SequenceWorkflow sequenceWorkflow;
	
	@Override
	public WorkflowResponse processWorflowRequest(WorkflowRequest wfRequest) throws WorkflowException {
		return (WorkflowResponse) sequenceWorkflow.doActivities(wfRequest);
	}

}
