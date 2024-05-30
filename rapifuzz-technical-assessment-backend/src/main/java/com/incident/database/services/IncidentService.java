package com.incident.database.services;

import com.incident.model.Incident;

public interface IncidentService {
    void save(Incident Incident);

    void updateStatus(String incidentStatus, String incidentId);

    void updateIncident(String priority, String incidentDetail, String incidentId);

    Incident findByIncidentId(String incidentId);
}
