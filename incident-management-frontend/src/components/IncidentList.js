import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import IncidentService from "../services/IncidentService";
import Incident from "./Incident";

const IncidentList = () => {
  const navigate = useNavigate();
  const [loading, setLoading] = useState(true);
  const [incidents, setIncidents] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await IncidentService.getIncidents();
        setIncidents(response.data);
      } catch (error) {
        console.error("Failed to fetch incidents", error);
      }
      setLoading(false);
    };

    fetchData();
  }, []);

  const deleteIncident = async (id) => {
    try {
      await IncidentService.deleteIncident(id);
      setIncidents(incidents.filter((incident) => incident.id !== id));
    } catch (error) {
      console.error("Failed to delete incident", error);
    }
  };

  return (
    <div className="container mx-auto px-4 py-8">
      <div className="flex justify-end mb-4">
        <button
          onClick={() => navigate("/addIncident")}
          className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
        >
          Add Incident
        </button>
      </div>
      <div className="shadow overflow-hidden border-b border-gray-200 sm:rounded-lg">
        <table className="min-w-full divide-y divide-gray-200">
          <thead className="bg-gray-50">
            <tr>
              <th
                scope="col"
                className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
              >
                First Name
              </th>
              <th
                scope="col"
                className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
              >
                Last Name
              </th>
              <th
                scope="col"
                className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
              >
                Email ID
              </th>
              <th
                scope="col"
                className="px-6 py-3 text-right text-xs font-medium text-gray-500 uppercase tracking-wider"
              >
                Actions
              </th>
            </tr>
          </thead>
          <tbody className="bg-white divide-y divide-gray-200">
            {loading ? (
              <tr>
                <td colSpan="4" className="text-center py-4">
                  Loading...
                </td>
              </tr>
            ) : (
              incidents.map((incident) => (
                <Incident
                  key={incident.id}
                  incident={incident}
                  deleteIncident={deleteIncident}
                />
              ))
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default IncidentList;
