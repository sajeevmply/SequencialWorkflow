package com.sajeev.wf.exception;

import java.util.ArrayList;
import java.util.List;

public class WorkflowException extends Exception {

	private static final long serialVersionUID = -1802767361956441873L;
	
	private String errorCode;
	
	private List<String> args = new ArrayList<String>();

	public WorkflowException() {
		super();
	}
	
	public WorkflowException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public WorkflowException(String errorCode, List<String> args) {
		super();
		this.errorCode = errorCode;
		this.args = args;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public List<String> getArgs() {
		return args;
	}

}
