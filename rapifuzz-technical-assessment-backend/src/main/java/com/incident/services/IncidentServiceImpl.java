package com.incident.services;

import com.incident.entity.IncidentEntity;
import com.incident.model.Incident;
import com.incident.repository.IncidentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncidentServiceImpl implements IncidentService {
    private IncidentRepository incidentRepository;

    public IncidentServiceImpl(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    @Override
    public Incident createIncident(Incident incident) {
        IncidentEntity incidentEntity = new IncidentEntity();
        BeanUtils.copyProperties(incident, incidentEntity);
        incidentRepository.save(incidentEntity);
        return incident;
    }

    @Override
    public List<Incident> getAllIncidents() {
        List<IncidentEntity> incidentEntities
                = incidentRepository.findAll();
        List<Incident> incidents = incidentEntities
                .stream()
                .map(emp -> new Employee(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmailId()))
                .collect(Collectors.toList());
        return incidents;
    }

    @Override
    public boolean deleteIncident(Long id) {
        IncidentEntity incident = incidentRepository.findById(id).get();
        incidentRepository.delete(incident);
        return true;
    }

    @Override
    public Incident getIncidentById(Long id) {
        IncidentEntity incidentEntity = incidentRepository.findById(id).get();
        Incident incident = new Incident();
        BeanUtils.copyProperties(incidentEntity, incident);
        return incident;
    }

    @Override
    public Incident updateIncident(Long id, Incident incident) {
        IncidentEntity incidentEntity = incidentRepository.findById(id).get();
        incidentEntity.setEmailId(incident.getEmailId());
        incidentEntity.setFirstName(incident.getFirstName());
        incidentEntity.setLastName(incident.getLastName());

        incidentRepository.save(incidentEntity);
        return incident;
    }

}
