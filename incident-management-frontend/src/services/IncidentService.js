import axios from "axios";

const API_BASE_URL = "http://localhost:8080";

class IncidentService {
  registerUser(userDetails) {
    return axios.post(`${API_BASE_URL}/user/registration`, userDetails);
  }

  loginUser(loginDetails) {
    return axios.post(`${API_BASE_URL}/user/login`, loginDetails);
  }

  forgotPassword(passwordRequest) {
    return axios.post(`${API_BASE_URL}/forgot/password`, passwordRequest);
  }

  saveIncident(incident) {
    return axios.post(`${API_BASE_URL}/add/incident`, incident);
  }

  getIncidents() {
    return axios.get(`${API_BASE_URL}/get/incidents`);
  }

  getIncidentById(id) {
    return axios.get(`${API_BASE_URL}/get/incident/${id}`);
  }

  updateIncident(incident) {
    return axios.post(`${API_BASE_URL}/update/incident`, incident);
  }

  deleteIncident(id) {
    return axios.delete(`${API_BASE_URL}/delete/incident/${id}`);
  }
}

export default new IncidentService();
