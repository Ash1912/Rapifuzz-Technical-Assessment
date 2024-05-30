package com.incident.request;

public class updateIncidentRequest {

    private String status;
	private String priority;
	private String incidentDetail;
	private String incidentId;
	
	// Getter for Status
	public String getStatus() {
		return status;
	}
	 public String getIncidentId() {
		 return incidentId;
	 }
	
	// Setter for Status
	public void setStatus(String status) {
		this.status = status;
	}
	
	// Getter for priority
	public String getPriority() {
		return priority;
	}
	
	// Setter for priority
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}
	
	// Getter for incidentDetail
	public String getIncidentDetail() {
		return incidentDetail;
	}
	
	// Setter for incidentDetail
	public void setIncidentDetail(String incidentDetail) {
		this.incidentDetail = incidentDetail;
	}
    
}
