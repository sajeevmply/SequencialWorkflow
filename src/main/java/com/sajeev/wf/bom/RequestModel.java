package com.sajeev.wf.bom;

import java.io.Serializable;
import java.util.Date;

public class RequestModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String functionalId;
	
	private String currentPlatform;
	
	private Date transmissionTime;

	public String getFunctionalId() {
		return functionalId;
	}

	public void setFunctionalId(String functionalId) {
		this.functionalId = functionalId;
	}

	public String getCurrentPlatform() {
		return currentPlatform;
	}

	public void setCurrentPlatform(String currentPlatform) {
		this.currentPlatform = currentPlatform;
	}

	public Date getTransmissionTime() {
		return transmissionTime;
	}

	public void setTransmissionTime(Date transmissionTime) {
		this.transmissionTime = transmissionTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currentPlatform == null) ? 0 : currentPlatform.hashCode());
		result = prime * result
				+ ((functionalId == null) ? 0 : functionalId.hashCode());
		result = prime
				* result
				+ ((transmissionTime == null) ? 0 : transmissionTime.hashCode());
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
		RequestModel other = (RequestModel) obj;
		if (currentPlatform == null) {
			if (other.currentPlatform != null) {
				return false;
			}
		} else if (!currentPlatform.equals(other.currentPlatform)) {
			return false;
		}
		if (functionalId == null) {
			if (other.functionalId != null) {
				return false;
			}
		} else if (!functionalId.equals(other.functionalId)) {
			return false;
		}
		if (transmissionTime == null) {
			if (other.transmissionTime != null) {
				return false;
			}
		} else if (!transmissionTime.equals(other.transmissionTime)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "RequestModel [functionalId=" + functionalId
				+ ", currentPlatform=" + currentPlatform
				+ ", transmissionTime=" + transmissionTime + "]";
	}

}
