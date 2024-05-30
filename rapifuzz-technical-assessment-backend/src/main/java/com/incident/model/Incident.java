package com.incident.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="incident")
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    
    @Column(name = "incident_id")
    private String incidentId;
    
    @Column(name = "identity")
    private String identity;

    @Column(name = "Reporter_Name")
    private String reporterName;
    
    @Column(name = "incident_detail")
    private String incidentDetail;
    
    @Column(name = "Incident_Status")
    private String incidentStatus;
    
    @Column(name = "Priority")
    private String priority;

    // Getter methods
    public String getIncidentId() {
        return incidentId;
    }

    public String getType() {
        return identity;
    }

    public String getReporterName() {
        return reporterName;
    }

    public String getIncidentDetail() {
        return incidentDetail;
    }

    public String getIncidentStatus() {
        return incidentStatus;
    }

    public String getPriority() {
        return priority;
    }

    // Setter methods
    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public void setIncidentDetail(String incidentDetail) {
        this.incidentDetail = incidentDetail;
    }

    public void setIncidentStatus(String incidentStatus) {
        this.incidentStatus = incidentStatus;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    
    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }

}
