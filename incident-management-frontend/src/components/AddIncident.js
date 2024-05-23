import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import IncidentService from "../services/IncidentService";
import "../assets/AddIncident.css";

const AddIncident = () => {
  const navigate = useNavigate();
  const [incident, setIncident] = useState({
    firstName: "",
    lastName: "",
    emailId: "",
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
        <div className="form-group">
          <label htmlFor="firstName">First Name</label>
          <input
            type="text"
            name="firstName"
            value={incident.firstName}
            onChange={handleChange}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label htmlFor="lastName">Last Name</label>
          <input
            type="text"
            name="lastName"
            value={incident.lastName}
            onChange={handleChange}
            className="form-control"
          />
        </div>
        <div className="form-group">
          <label htmlFor="emailId">Email ID</label>
          <input
            type="email"
            name="emailId"
            value={incident.emailId}
            onChange={handleChange}
            className="form-control"
          />
        </div>
        <button className="button-save">Save</button>
      </form>
    </div>
  );
};

export default AddIncident;
