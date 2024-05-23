package com.incident.controller;

import com.incident.model.Incident;
import com.incident.services.IncidentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @PostMapping
    public ResponseEntity<Incident> createIncident(@RequestBody Incident incident, @RequestParam Long userId) {
        Incident createdIncident = incidentService.createIncident(incident, userId);
        return ResponseEntity.ok(createdIncident);
    }

    @GetMapping
    public ResponseEntity<List<Incident>> getAllIncidentsByUser(@RequestParam Long userId) {
        List<Incident> incidents = incidentService.getAllIncidentsByUserId(userId);
        return ResponseEntity.ok(incidents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Incident> getIncidentById(@PathVariable Long id) {
        Incident incident = incidentService.getIncidentById(id);
        if (incident != null) {
            return ResponseEntity.ok(incident);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Incident> updateIncident(@PathVariable Long id, @RequestBody Incident incident) {
        Incident updatedIncident = incidentService.updateIncident(id, incident);
        if (updatedIncident != null) {
            return ResponseEntity.ok(updatedIncident);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncident(@PathVariable Long id) {
        if (incidentService.deleteIncident(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
