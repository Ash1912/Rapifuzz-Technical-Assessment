package com.incident.request;

public class IncidentRequest {
    private String email;
   private String identity;
   private String incidentDetail;
   private String password;
   private String incidentStatus;
   private String priority;
   private String reporterName;
   private String status;
   
   public String getStatus() {
       return status;
   }

   public void setStatus(String status) {
       this.status = status;
   }
   // Getter and setter for email
   public String getEmail() {
       return email;
   }

   public void setEmail(String email) {
       this.email = email;
   }

   // Getter and setter for password
   public String getPassword() {
       return password;
   }

   public void setPassword(String password) {
       this.password = password;
   }

   // Getter and setter for identity
   public String getIdentity() {
       return identity;
   }

   public void setIdentity(String identity) {
       this.identity = identity;
   }

   // Getter and setter for incidentDetail
   public String getIncidentDetail() {
       return incidentDetail;
   }

   public void setIncidentDetail(String incidentDetail) {
       this.incidentDetail = incidentDetail;
   }

   // Getter and setter for incidentStatus
   public String getIncidentStatus() {
       return incidentStatus;
   }

   public void setIncidentStatus(String incidentStatus) {
       this.incidentStatus = incidentStatus;
   }

   // Getter and setter for priority
   public String getPriority() {
       return priority;
   }

   public void setPriority(String priority) {
       this.priority = priority;
   }

   // Getter and setter for reporterName
   public String getReporterName() {
       return reporterName;
   }

   public void setReporterName(String reporterName) {
       this.reporterName = reporterName;
   }
}
