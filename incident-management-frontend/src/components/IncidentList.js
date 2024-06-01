import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate } from "react-router-dom";
import '../assets/IncidentList.css';

const IncidentList = () => {
    const [incidents, setIncidents] = useState([]);

    useEffect(() => {
        fetchIncidents();
    }, []);

    const fetchIncidents = async () => {
        try {
            const response = await axios.get('http://localhost:8080/get/incidents');
            console.log(response.data);
            setIncidents(response.data);
        } catch (error) {
            console.error('Error fetching incidents:', error);
        }
    };

    const navigate = useNavigate();
    const editIncident = (incidentId) => {
        navigate(`/editIncident/${incidentId}`);
    };

    return (
        <div className="incident-list">
            <h2>Incident List</h2>
            <table className="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Incident Id</th>
                        <th>Reporter Name</th>
                        <th>Incident Detail</th>
                        <th>Priority</th>
                        <th>Incident Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {incidents.map((incident, index) => (
                        <tr key={incident.id}>
                            <td>{index + 1}</td>
                            <td>{incident.incidentId}</td>
                            <td>{incident.reporterName}</td>
                            <td>{incident.incidentDetail}</td>
                            <td>{incident.priority}</td>
                            <td>{incident.incidentStatus}</td>
                            <td>
                                <button 
                                    className="edit-button" 
                                    onClick={() => editIncident(incident.incidentId)}
                                >
                                    Edit
                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default IncidentList;
