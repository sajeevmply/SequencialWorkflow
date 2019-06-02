package com.sajeev.wf.bom;

public class WorkflowResponse extends ResponseModel {

	private static final long serialVersionUID = 1L;

	private Integer workflowId;
	
	private String workflowName;
	
	private String workflowData;

	public Integer getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
	}

	public String getWorkflowName() {
		return workflowName;
	}

	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}

	public String getWorkflowData() {
		return workflowData;
	}

	public void setWorkflowData(String workflowData) {
		this.workflowData = workflowData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((workflowData == null) ? 0 : workflowData.hashCode());
		result = prime * result
				+ ((workflowName == null) ? 0 : workflowName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		WorkflowResponse other = (WorkflowResponse) obj;
		if (workflowData == null) {
			if (other.workflowData != null) {
				return false;
			}
		} else if (!workflowData.equals(other.workflowData)) {
			return false;
		}
		if (workflowName == null) {
			if (other.workflowName != null) {
				return false;
			}
		} else if (!workflowName.equals(other.workflowName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "WorkflowResponse [workflowName=" + workflowName
				+ ", workflowData=" + workflowData + "]";
	}
	
}
