package com.incident.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Incident {
    private Long id;
    private String incidentId; // Unique Incident ID
    private String reporterName; // Name of the user who logs in and creates the incident
    private String incidentDetails; // Detailed description of the incident
    private Date reportedDate; // Date and time when the incident was reported
    private Priority priority; // Priority of the incident
    private Status status; // Current status of the incident
    private String emailId; // Email ID of the user who reported the incident

    public enum Priority {
        HIGH, MEDIUM, LOW
    }

    public enum Status {
        OPEN, IN_PROGRESS, CLOSED
    }
}
