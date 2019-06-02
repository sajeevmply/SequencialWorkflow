package com.sajeev.wf.bom;

public class WorkflowRequest extends RequestModel {

	private static final long serialVersionUID = 1L;

	private Integer workflowId;
	
	private String workflowName;
	
	private String stepName;

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

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((stepName == null) ? 0 : stepName.hashCode());
		result = prime * result
				+ ((workflowName == null) ? 0 : workflowName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		WorkflowRequest other = (WorkflowRequest) obj;
		if (stepName == null) {
			if (other.stepName != null) {
				return false;
			}
		} else if (!stepName.equals(other.stepName)) {
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
		return "WorkflowRequest [workflowName=" + workflowName + ", stepName="
				+ stepName + "]";
	}
	
}
