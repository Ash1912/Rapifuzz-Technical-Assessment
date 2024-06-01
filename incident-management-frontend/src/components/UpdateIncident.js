import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import IncidentService from "../services/IncidentService";
import "../assets/UpdateIncident.css";

const UpdateIncident = () => {
    const { id } = useParams();  // Using 'id' to fetch the specific incident details.
    const navigate = useNavigate();
    const [incident, setIncident] = useState({
        incidentId: "",
        incidentStatus: "",
        priority: "",
        incidentDetail: "",
    });

    // Array of fields you want to display in the form.
    const fieldsToShow = ['incidentId', 'incidentStatus', 'priority', 'incidentDetail'];

    useEffect(() => {
        // Fetch the incident data when the component mounts
        IncidentService.getIncidentById(id).then(data => {
            setIncident(data);
        }).catch(error => console.error("Fetching incident failed:", error));
    }, [id]);

    const handleChange = (event) => {
        const { name, value } = event.target;
        setIncident(prev => ({ ...prev, [name]: value }));
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const updatedData = await IncidentService.updateIncident(incident);
            console.log("Update successful:", updatedData);
            navigate("/");  // Redirect to the homepage or handle the UI update
        } catch (error) {
            console.error("Update failed:", error);
        }
    };

    return (
        <div className="update-incident-container">
            <h2>Update Incident</h2>
            <form onSubmit={handleSubmit}>
                {fieldsToShow.map(key => (
                    <div key={key} className="form-group">
                        <label>{key.charAt(0).toUpperCase() + key.slice(1)}:</label>
                        <input
                            type="text"
                            name={key}
                            value={incident[key] || ''} // Avoiding undefined values
                            onChange={handleChange}
                            required
                        />
                    </div>
                ))}
                <button type="submit">Update</button>
            </form>
        </div>
    );
};

export default UpdateIncident;
