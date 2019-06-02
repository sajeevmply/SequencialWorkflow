package com.sajeev.wf.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sajeev.wf.bom.WorkflowRequest;
import com.sajeev.wf.bom.WorkflowResponse;
import com.sajeev.wf.constant.RequestStatus;
import com.sajeev.wf.exception.WorkflowException;
import com.sajeev.wf.service.WorkflowService;

@RestController
@RequestMapping("rest")
public class WorkflowResource extends BaseResource {

	@Autowired
	private WorkflowService workflowService;
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public ResponseEntity<List<String>> listAllUsers() {
		List<String> users = new ArrayList<String>();
		users.add("sajeev");
		users.add("Rajeev");
		users.add("Anirudh");
		if(users.isEmpty()){
			return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<String>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public WorkflowResponse login() {
		
		WorkflowResponse response = null;
		
		try {
			WorkflowRequest request = new WorkflowRequest();
			response = workflowService.processWorflowRequest(request);
		} catch (WorkflowException e) {
			return (WorkflowResponse) handleCheckedExceptions(new WorkflowResponse(), e);
		} catch (Exception e) {
			return (WorkflowResponse) handleExceptions(new WorkflowResponse(), e);
		}
		
		if(response.getStatus().getStatusCode().equals(RequestStatus.FAILURE)){
			response.getStatus().setErrorMessage("Workflow Error Message!!");
		}
		
		return response;
	}
}
