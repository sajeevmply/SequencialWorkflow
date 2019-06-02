package com.sajeev.wf.vehicle;

import com.sajeev.wf.base.WorkflowContext;
import com.sajeev.wf.domain.BusinessEventLog;
import com.sajeev.wf.domain.User;

public abstract class VehicleWorkflowContext implements WorkflowContext {

	private static final long serialVersionUID = 8254240225468393686L;

	private boolean stopProcess;
	
	private BusinessEventLog businessEventLog;
	
	private User user;
	
	public boolean stopProcess(){
		return stopProcess;
	}

	public void setStopProcess(boolean stopProcess) {
		this.stopProcess = stopProcess;
	}

	public BusinessEventLog getBusinessEventLog() {
		return businessEventLog;
	}

	public void setBusinessEventLog(BusinessEventLog businessEventLog) {
		this.businessEventLog = businessEventLog;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
