import React, { useState } from 'react';
import IncidentService from '../services/IncidentService';
import '../assets/AddIncident.css';

const AddIncident = () => {
  const [incidentDetails, setIncidentDetails] = useState({
    email: '',
    identity: 'enterprise',
    incidentDetail: '',
    password: '',
    incidentStatus: 'open',
    priority: 'low',
    reporterName: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setIncidentDetails({ ...incidentDetails, [name]: value });
  };

  const handleAddIncident = async (e) => {
    e.preventDefault();
    try {
      const response = await IncidentService.addIncident(incidentDetails);
      if (response.errorCode === 100) {
        alert('Incident added successfully');
        setIncidentDetails({
          email: '',
          identity: 'enterprise',
          incidentDetail: '',
          password: '',
          incidentStatus: 'open',
          priority: 'low',
          reporterName: ''
        });
      } else {
        alert(response.status);
      }
    } catch (error) {
      console.error('Error adding incident:', error);
    }
  };

  return (
    <div className="add-incident">
      <h2>Add Incident</h2>
      <form onSubmit={handleAddIncident}>
        <label>Email</label>
        <input type="email" name="email" value={incidentDetails.email} onChange={handleChange} required />

        <label>Identity</label>
        <select name="identity" value={incidentDetails.identity} onChange={handleChange} required>
          <option value="enterprise">Enterprise</option>
          <option value="government">Government</option>
        </select>

        <label>Incident Detail</label>
        <input type="text" name="incidentDetail" value={incidentDetails.incidentDetail} onChange={handleChange} required />

        <label>Password</label>
        <input type="password" name="password" value={incidentDetails.password} onChange={handleChange} required />

        <label>Incident Status</label>
        <select name="incidentStatus" value={incidentDetails.incidentStatus} onChange={handleChange} required>
          <option value="open">Open</option>
          <option value="inprogress">In Progress</option>
          <option value="closed">Closed</option>
        </select>

        <label>Priority</label>
        <select name="priority" value={incidentDetails.priority} onChange={handleChange} required>
          <option value="low">Low</option>
          <option value="medium">Medium</option>
          <option value="high">High</option>
        </select>

        <label>Reporter Name</label>
        <input type="text" name="reporterName" value={incidentDetails.reporterName} onChange={handleChange} required />

        <button type="submit">Add Incident</button>
      </form>
    </div>
  );
};

export default AddIncident;
