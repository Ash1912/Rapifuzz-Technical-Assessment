import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import IncidentService from "../services/IncidentService";
import '../assets/UpdateIncident.css';

const UpdateIncident = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [incident, setIncident] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const data = await IncidentService.getIncidentById(id);
        if (data) {
          setIncident(data);
        } else {
          console.error("Fetching incident failed: No data received");
        }
      } catch (error) {
        console.error("Fetching incident failed:", error);
      } finally {
        setLoading(false);
      }
    };
    fetchData();
  }, [id]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setIncident((prev) => ({ ...prev, [name]: value }));
  };

  const updateIncident = async (e) => {
    e.preventDefault();
    try {
      const updated = await IncidentService.updateIncident(incident);
      console.log("Update successful:", updated);
      navigate("/");
    } catch (error) {
      console.error("Failed to update incident", error);
    }
  };

  if (loading) {
    return <div>Loading...</div>;
  }

  if (!incident) {
    return <div>No incident data available.</div>;
  }

  return (
    <div className="update-incident-container">
      <h2>Update Incident</h2>
      <form onSubmit={updateIncident}>
        {Object.keys(incident).map((key) => (
          <div key={key} className="form-group">
            <label>{key.charAt(0).toUpperCase() + key.slice(1)}:</label>
            <input
              type="text"
              name={key}
              value={incident[key] || ""}
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
