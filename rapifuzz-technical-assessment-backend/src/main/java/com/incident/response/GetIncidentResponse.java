package com.incident.response;

import org.springframework.stereotype.Component;

@Component
public class GetIncidentResponse {

    private String reporterName;
    private String incidentId;
    private String incidentStatus;
    private String priority;
    private String incidentDetail;
    private String errorMsg;
    private int errorCode;

    public GetIncidentResponse() {
        // Default constructor
    }

    public GetIncidentResponse(String errorMsg, int errorCode) {
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    // Getter and Setter methods for all fields...

    public String getReporterName() {
        return reporterName;
    }

    public void setReporterName(String reporterName) {
        this.reporterName = reporterName;
    }

    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public String getIncidentStatus() {
        return incidentStatus;
    }

    public void setIncidentStatus(String incidentStatus) {
        this.incidentStatus = incidentStatus;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getIncidentDetail() {
        return incidentDetail;
    }

    public void setIncidentDetail(String incidentDetail) {
        this.incidentDetail = incidentDetail;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public GetIncidentResponse createErrorResponse(String errorMsg, int errorCode) {
        GetIncidentResponse response = new GetIncidentResponse();
        response.setErrorMsg(errorMsg);
        response.setErrorCode(errorCode);
        return response;
    }
}

