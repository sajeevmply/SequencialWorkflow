package com.sajeev.wf.bom;

import java.io.Serializable;

import com.sajeev.wf.bom.component.Status;

public class ResponseModel implements Serializable {

	private static final long serialVersionUID = -3360861606018215032L;
	
	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
