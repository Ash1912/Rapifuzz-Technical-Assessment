import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import IncidentService from "../services/IncidentService";
import Incident from "./Incident";

const IncidentList = () => {
  const navigate = useNavigate();

  const [loading, setLoading] = useState(true);
  const [incidents, setIncidents] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await IncidentService.getIncidents();
        setIncidents(response.data);
      } catch (error) {
        console.log(error);
      }
      setLoading(false);
    };
    fetchData();
  }, []);

  const deleteIncident = (e, id) => {
    e.preventDefault();
    IncidentService.deleteIncident(id).then((res) => {
      if (incidents) {
        setIncidents((prevElement) => {
          return prevElement.filter((incident) => incident.id !== id);
        });
      }
    });
  };

  return (
    <div className="container mx-auto my-8">
      <div className="h-12">
        <button
          onClick={() => navigate("/addIncident")}
          className="rounded bg-slate-600 text-white px-6 py-2 font-semibold"
        >
          Add Incident
        </button>
      </div>
      <div className="flex shadow border-b">
        <table className="min-w-full">
          <thead className="bg-gray-50">
            <tr>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                First Name
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Last Name
              </th>
              <th className="text-left font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Email ID
              </th>
              <th className="text-right font-medium text-gray-500 uppercase tracking-wider py-3 px-6">
                Actions
              </th>
            </tr>
          </thead>
          {!loading && (
            <tbody className="bg-white">
              {incidents.map((incident) => (
                <Incident
                  incident={incident}
                  deleteIncident={deleteIncident}
                  key={incident.id}
                ></Incident>
              ))}
            </tbody>
          )}
        </table>
      </div>
    </div>
  );
};

export default IncidentList;
