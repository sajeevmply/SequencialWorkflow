package com.sajeev.wf.bom.component;

import java.io.Serializable;


public class Status implements Serializable{
	
	private static final long serialVersionUID = -1049150567455174772L;

	private String statusCode;
	
	private String errorCode;
	
	private String errorMessage;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
