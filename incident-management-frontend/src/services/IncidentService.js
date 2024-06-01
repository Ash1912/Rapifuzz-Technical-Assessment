import axios from 'axios';

const API_BASE_URL = process.env.REACT_APP_API_BASE_URL || 'http://localhost:8080';

class IncidentService {
    static async register(userDetails) {
        try {
            const response = await axios.post(`${API_BASE_URL}/user/registration`, userDetails);
            return response.data;
        } catch (error) {
            throw error.response ? error.response.data : new Error('Network error');
        }
    }

    static async login(credentials) {
        try {
            const response = await axios.post(`${API_BASE_URL}/user/login`, credentials);
            return response.data;
        } catch (error) {
            throw error.response ? error.response.data : new Error('Network error');
        }
    }

    static async forgotPassword(emailDetails) {
        try {
            const response = await axios.post(`${API_BASE_URL}/forgot/password`, emailDetails);
            return response.data;
        } catch (error) {
            throw error.response ? error.response.data : new Error('Network error');
        }
    }

    static async addIncident(incidentDetails) {
        try {
            const response = await axios.post(`${API_BASE_URL}/add/incident`, incidentDetails);
            return response.data;
        } catch (error) {
            throw error.response ? error.response.data : new Error('Network error');
        }
    }

    static async getIncidents() {
        try {
            const response = await axios.get(`${API_BASE_URL}/get/incidents`);
            return response.data;
        } catch (error) {
            throw error.response ? error.response.data : new Error('Network error');
        }
    }

    static async getIncidentById(id) {
        try {
            const response = await axios.get(`${API_BASE_URL}/get/incident/${id}`);
            return response.data;
        } catch (error) {
            throw error.response ? error.response.data : new Error('Network error');
        }
    }

    static async updateIncident(incidentDetails) {
        try {
            const response = await axios.post(`${API_BASE_URL}/update/incident`, incidentDetails);
            return response.data;
        } catch (error) {
            throw error.response ? error.response.data : new Error('Network error');
        }
    }
}

export default IncidentService;
