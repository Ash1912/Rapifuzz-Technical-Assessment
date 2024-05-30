package com.incident.database.services;

import com.incident.model.Incident;
import com.incident.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IncidentServiceImpl implements IncidentService {
@Autowired
    private IncidentRepository incidentRepository;

    @Override
    @Transactional
    public void save(Incident incident) {
        incidentRepository.save(incident);
    }

    @Override
    @Transactional
    public void updateStatus(String incidentStatus, String incidentId) {
        incidentRepository.updateStatus(incidentStatus, incidentId);
    }

    @Override
    @Transactional
    public void updateIncident(String priority, String incidentDetail, String incidentId) {
        incidentRepository.updateIncidentDetail(priority, incidentDetail, incidentId);
    }

    @Override
    public Incident findByIncidentId(String incidentId) {
        return incidentRepository.findByIncidentId(incidentId);
    }
}
