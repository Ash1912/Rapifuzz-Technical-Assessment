import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import IncidentService from "../services/IncidentService";

const UpdateIncident = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [incident, setIncident] = useState({
    id: id,
    firstName: "",
    lastName: "",
    emailId: "",
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
  }, [id]); // Ensure that `id` is included in the dependency array

  const handleChange = (e) => {
    const { name, value } = e.target;
    setIncident((prev) => ({ ...prev, [name]: value }));
  };

  const updateIncident = async (e) => {
    e.preventDefault();
    try {
      await IncidentService.updateIncident(incident, id);
      navigate("/");
    } catch (error) {
      console.error("Failed to update incident", error);
    }
  };

  return (
    <div className="max-w-2xl mx-auto p-8">
      <h1 className="text-xl font-semibold mb-4">Update Incident</h1>
      <form onSubmit={updateIncident}>
        <label
          className="block text-gray-700 text-sm font-bold mb-2"
          htmlFor="firstName"
        >
          First Name
        </label>
        <input
          className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
          id="firstName"
          type="text"
          name="firstName"
          value={incident.firstName}
          onChange={handleChange}
        />

        <label
          className="block text-gray-700 text-sm font-bold mb-2"
          htmlFor="lastName"
        >
          Last Name
        </label>
        <input
          className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
          id="lastName"
          type="text"
          name="lastName"
          value={incident.lastName}
          onChange={handleChange}
        />

        <label
          className="block text-gray-700 text-sm font-bold mb-2"
          htmlFor="emailId"
        >
          Email ID
        </label>
        <input
          className="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
          id="emailId"
          type="email"
          name="emailId"
          value={incident.emailId}
          onChange={handleChange}
        />

        <button
          className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline mt-4"
          type="submit"
        >
          Update
        </button>
      </form>
    </div>
  );
};

export default UpdateIncident;
