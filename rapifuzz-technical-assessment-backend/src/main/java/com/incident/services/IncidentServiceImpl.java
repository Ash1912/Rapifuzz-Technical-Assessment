package com.incident.services;

import com.incident.entity.IncidentEntity;
import com.incident.model.Incident;
import com.incident.repository.IncidentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IncidentServiceImpl implements IncidentService {

    private final IncidentRepository incidentRepository;

    @Autowired
    public IncidentServiceImpl(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    @Override
    public Incident createIncident(Incident incident, Long userId) {
        IncidentEntity incidentEntity = new IncidentEntity();
        BeanUtils.copyProperties(incident, incidentEntity);
        incidentEntity.setUserId(userId); // Assuming IncidentEntity has a userId field
        incidentRepository.save(incidentEntity);
        BeanUtils.copyProperties(incidentEntity, incident, "id");
        return incident;
    }

    @Override
    public List<Incident> getAllIncidentsByUserId(Long userId) {
        return incidentRepository.findByUserId(userId).stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }

    @Override
    public Incident getIncidentById(Long id) {
        Optional<IncidentEntity> incidentEntity = incidentRepository.findById(id);
        if (incidentEntity.isPresent()) {
            Incident incident = new Incident();
            BeanUtils.copyProperties(incidentEntity.get(), incident);
            return incident;
        }
        return null;
    }

    @Override
    public Incident updateIncident(Long id, Incident incident) {
        Optional<IncidentEntity> existingEntity = incidentRepository.findById(id);
        if (existingEntity.isPresent()) {
            BeanUtils.copyProperties(incident, existingEntity.get(), "id");
            incidentRepository.save(existingEntity.get());
            return incident;
        }
        return null;
    }

    @Override
    public boolean deleteIncident(Long id) {
        Optional<IncidentEntity> incident = incidentRepository.findById(id);
        if (incident.isPresent()) {
            incidentRepository.delete(incident.get());
            return true;
        }
        return false;
    }

    private Incident convertToModel(IncidentEntity entity) {
        Incident model = new Incident();
        BeanUtils.copyProperties(entity, model);
        return model;
    }
}
