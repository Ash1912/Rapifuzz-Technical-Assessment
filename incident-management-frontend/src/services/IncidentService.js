// src/services/IncidentService.js

import axios from "axios";

const INCIDENT_API_BASE_URL = "http://localhost:8080/api/v1/incidents";

class IncidentService {
  saveIncident(incident) {
    return axios.post(INCIDENT_API_BASE_URL, incident);
  }

  getIncidents() {
    return axios.get(INCIDENT_API_BASE_URL);
  }

  deleteIncident(id) {
    return axios.delete(`${INCIDENT_API_BASE_URL}/${id}`);
  }

  getIncidentById(id) {
    return axios.get(`${INCIDENT_API_BASE_URL}/${id}`);
  }

  updateIncident(incident, id) {
    return axios.put(`${INCIDENT_API_BASE_URL}/${id}`, incident);
  }
}

const incidentService = new IncidentService();
export default incidentService; // Exporting as a named variable
