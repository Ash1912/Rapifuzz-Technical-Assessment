import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import IncidentService from "../services/IncidentService";
import "../assets/AddIncident.css";

const AddIncident = () => {
  const navigate = useNavigate();
  const [incident, setIncident] = useState({
    email: "",
    identity: "",
    incidentDetail: "",
    password: "",
    incidentStatus: "",
    priority: "",
    reporterName: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setIncident((prev) => ({ ...prev, [name]: value }));
  };

  const saveIncident = async (e) => {
    e.preventDefault();
    try {
      await IncidentService.saveIncident(incident);
      navigate("/");
    } catch (error) {
      console.error("Failed to save incident", error);
    }
  };

  return (
    <div className="add-incident-container">
      <h1>Add New Incident</h1>
      <form onSubmit={saveIncident}>
        {Object.keys(incident).map((key) => (
          <div key={key} className="form-group">
            <label>{key.charAt(0).toUpperCase() + key.slice(1)}</label>
            <input
              type="text"
              name={key}
              value={incident[key]}
              onChange={handleChange}
              className="form-control"
              required
            />
          </div>
        ))}
        <button className="button-save">Save</button>
      </form>
    </div>
  );
};

export default AddIncident;
