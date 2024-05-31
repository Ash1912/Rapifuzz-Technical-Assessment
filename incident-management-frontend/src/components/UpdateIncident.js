import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import IncidentService from "../services/IncidentService";

const UpdateIncident = () => {
  const { id } = useParams();
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

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await IncidentService.getIncidentById(id);
        setIncident(response.data);
      } catch (error) {
        console.log(error);
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
      await IncidentService.updateIncident(incident);
      navigate("/");
    } catch (error) {
      console.error("Failed to update incident", error);
    }
  };

  return (
    <div className="max-w-2xl mx-auto p-8">
      <h1 className="text-xl font-semibold mb-4">Update Incident</h1>
      <form onSubmit={updateIncident}>
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
        <button className="button-save" type="submit">
          Update
        </button>
      </form>
    </div>
  );
};

export default UpdateIncident;
