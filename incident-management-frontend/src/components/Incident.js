import React from "react";
import { useNavigate } from "react-router-dom";

const Incident = ({ incident, deleteIncident }) => {
  const navigate = useNavigate();

  const editIncident = (e, id) => {
    e.preventDefault();
    navigate(`/editIncident/${id}`);
  };

  return (
    <tr key={incident.id}>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{incident.reporterName}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{incident.incidentDetail}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-nowrap">
        <div className="text-sm text-gray-500">{incident.email}</div>
      </td>
      <td className="text-right px-6 py-4 whitespace-nowrap font-medium text-sm">
        <button
          onClick={(e) => editIncident(e, incident.id)}
          className="text-indigo-600 hover:text-indigo-800 px-4 hover:cursor-pointer"
        >
          Edit
        </button>
        <button
          onClick={(e) => deleteIncident(e, incident.id)}
          className="text-indigo-600 hover:text-indigo-800 hover:cursor-pointer"
        >
          Delete
        </button>
      </td>
    </tr>
  );
};

export default Incident;
