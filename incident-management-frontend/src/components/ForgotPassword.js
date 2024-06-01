import React, { useState } from 'react';
import { toast } from 'react-toastify';
import IncidentService from '../services/IncidentService';
import 'react-toastify/dist/ReactToastify.css';
import '../assets/ForgotPassword.css';


const ForgotPassword = () => {
  const [email, setEmail] = useState("");
  const [newPassword, setNewPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (newPassword !== confirmPassword) {
      toast.error("Passwords do not match!", { position: "top-center" });
      return;
    }

    try {
      const response = await IncidentService.forgotPassword({
        email,
        newPassword,
        confirmPassword
      });
      console.log("Reset password response:", response);
      toast.success("Password Updated Successfully!.", { position: "top-center",
      autoClose: 2000,
      style: { whiteSpace: 'nowrap' } });
    } catch (error) {
      console.error("Forgot password error:", error);
      toast.error("Failed to reset password: " + (error.response?.data || error.message), { position: "top-center",
      autoClose: 2000,
      style: { whiteSpace: 'nowrap' } });
    }
  };

  return (
    <div className="forgot-password-container">
      <h2>Forgot Password</h2>
      <form onSubmit={handleSubmit}>
        <label>Email:</label>
        <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
        <label>New Password:</label>
        <input type="password" value={newPassword} onChange={(e) => setNewPassword(e.target.value)} required />
        <label>Confirm New Password:</label>
        <input type="password" value={confirmPassword} onChange={(e) => setConfirmPassword(e.target.value)} required />
        <button type="submit">Update Password</button>
      </form>
    </div>
  );
};

export default ForgotPassword;
