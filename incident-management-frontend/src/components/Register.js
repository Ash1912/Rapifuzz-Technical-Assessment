import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import IncidentService from '../services/IncidentService';
import '../assets/Register.css';

const Register = () => {
  const [userDetails, setUserDetails] = useState({
    userName: '', emailId: '', password: '', confirmPassword: '', address: '', city: '', country: '', phoneNo: '', pinCode: ''
  });
  const navigate = useNavigate();

  const handleRegister = async (event) => {
    event.preventDefault();
    if (userDetails.password !== userDetails.confirmPassword) {
      alert("Passwords do not match!");
      return;
    }
    try {
      console.log('Attempting to register with:', userDetails);
      const response = await IncidentService.register(userDetails);
      console.log('Registration successful:', response);
      if (response.status === 'Invalid email address') {
        toast.error(`Registration failed! ${response.status}`, {
          position: "top-center",
          autoClose: 2000,
          style: { whiteSpace: 'nowrap' }
        });
      } else {
        toast.success('Registration successful!', {
          position: "top-center",
          autoClose: 2000,
          style: { whiteSpace: 'nowrap' }
        });
        setTimeout(() => {
          navigate('/login');
        }, 2000);
      }
    } catch (error) {
      console.error('Registration failed:', error.response?.data || 'Unknown error');
      toast.error('Registration failed! An unexpected error occurred', {
        position: "top-center",
        autoClose: 2000,
        style: { whiteSpace: 'nowrap' }
      });
    }
  };

  return (
    <div className="register-container">
      <h2>Register</h2>
      <form onSubmit={handleRegister}>
        <label>Username:</label>
        <input type="text" name="userName" value={userDetails.userName} onChange={e => setUserDetails({...userDetails, userName: e.target.value})} required />
        <label>Email:</label>
        <input type="email" name="emailId" value={userDetails.emailId} onChange={e => setUserDetails({...userDetails, emailId: e.target.value})} required />
        <label>Password:</label>
        <input type="password" name="password" value={userDetails.password} onChange={e => setUserDetails({...userDetails, password: e.target.value})} required />
        <label>Confirm Password:</label>
        <input type="password" name="confirmPassword" value={userDetails.confirmPassword} onChange={e => setUserDetails({...userDetails, confirmPassword: e.target.value})} required />
        <label>Address:</label>
        <input type="text" name="address" value={userDetails.address} onChange={e => setUserDetails({...userDetails, address: e.target.value})} required />
        <label>City:</label>
        <input type="text" name="city" value={userDetails.city} onChange={e => setUserDetails({...userDetails, city: e.target.value})} required />
        <label>Country:</label>
        <input type="text" name="country" value={userDetails.country} onChange={e => setUserDetails({...userDetails, country: e.target.value})} required />
        <label>Phone No:</label>
        <input type="text" name="phoneNo" value={userDetails.phoneNo} onChange={e => setUserDetails({...userDetails, phoneNo: e.target.value})} required />
        <label>Pin Code:</label>
        <input type="text" name="pinCode" value={userDetails.pinCode} onChange={e => setUserDetails({...userDetails, pinCode: e.target.value})} required />
        <button type="submit">Register</button>
      </form>
      <ToastContainer />
    </div>
  );
};

export default Register;
