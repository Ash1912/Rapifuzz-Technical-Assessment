package com.incident.controller;

import com.incident.model.Incident;
import com.incident.services.IncidentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class IncidentController {

    private IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @PostMapping("/incidents")
    public Incident createIncident(@RequestBody Incident incident) {
        return incidentService.createIncident(incident);
    }

    @GetMapping("/incidents")
    public List<Incident> getAllIncidents() {
        return incidentService.getAllIncidents();
    }

    @DeleteMapping("/incidents/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteIncident(@PathVariable Long id) {
        boolean deleted = false;
        deleted = incidentService.deleteIncident(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Incident has been deleted.", deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/incidents/{id}")
    public ResponseEntity<Incident> getIncidentById(@PathVariable Long id) {
        Incident incident = null;
        incident = incidentService.getIncidentById(id);
        return ResponseEntity.ok(incident);
    }

    @PutMapping("/incidents/{id}")
    public ResponseEntity<Incident> updateIncident(@PathVariable Long id, @RequestBody Incident incident) {
        incident = incidentService.updateIncident(id, incident);
        return ResponseEntity.ok(incident);
    }
}
