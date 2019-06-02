package com.sajeev.wf.base;

public abstract class BaseWorkflowContext implements WorkflowContext {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8254240225468393686L;

	private String transactionStatus;
	private boolean updateStatus;
	private String eventType;

	public abstract boolean stopProcess();

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public boolean getUpdateStatus() {
		return updateStatus;
	}

	public void setUpdateStatus(boolean updateStatus) {
		this.updateStatus = updateStatus;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

}
