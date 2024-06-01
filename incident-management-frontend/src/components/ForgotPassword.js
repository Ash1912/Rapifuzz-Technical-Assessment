import React, { useState } from 'react';
import IncidentService from '../services/IncidentService';

const ForgotPassword = () => {
  const [email, setEmail] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await IncidentService.forgotPassword({ email });
      alert("Please check your email to reset your password.");
    } catch (error) {
      console.error("Forgot password error:", error);
      alert("Error: " + error.message);
    }
  };

  return (
    <div className="forgot-password-container">
      <h2>Forgot Password</h2>
      <form onSubmit={handleSubmit}>
        <label>Email:</label>
        <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
        <button type="submit">Send Reset Link</button>
      </form>
    </div>
  );
};

export default ForgotPassword;
