import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import IncidentService from "../services/IncidentService";
import "../assets/Register.css";

const Register = () => {
  const [user, setUser] = useState({
    userName: "",
    emailId: "",
    address: "",
    pinCode: "",
    city: "",
    country: "",
    phoneNo: "",
    password: "",
    confirmPassword: "",
  });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await IncidentService.registerUser(user);
      navigate("/login");
    } catch (error) {
      console.error("Registration failed:", error);
      alert("Registration failed: " + error.message);
    }
  };

  return (
    <div className="register-container">
      <h1>Register</h1>
      <form onSubmit={handleSubmit} className="form">
        {Object.keys(user).map((key) => (
          <div key={key} className="form-group">
            <label>{key.charAt(0).toUpperCase() + key.slice(1)}:</label>
            <input
              type={key.includes("password") ? "password" : "text"}
              name={key}
              value={user[key]}
              onChange={handleChange}
              required
            />
          </div>
        ))}
        <button type="submit" className="submit-btn">
          Register
        </button>
      </form>
    </div>
  );
};

export default Register;
