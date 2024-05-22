package com.incident.services;

import com.incident.model.Incident;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IncidentService {
    Incident createIncident(Incident incident);
    List<Incident> getAllIncidents();
    boolean deleteIncident(Long id);
    Incident getIncidentById(Long id);
    Incident updateIncident(Long id, Incident incident);
}
