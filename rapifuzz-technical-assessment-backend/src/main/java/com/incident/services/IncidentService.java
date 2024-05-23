package com.incident.services;

import com.incident.model.Incident;
import java.util.List;

public interface IncidentService {
    Incident createIncident(Incident incident, Long userId);

    List<Incident> getAllIncidentsByUserId(Long userId);

    Incident getIncidentById(Long id);

    Incident updateIncident(Long id, Incident incident);

    boolean deleteIncident(Long id);
}
