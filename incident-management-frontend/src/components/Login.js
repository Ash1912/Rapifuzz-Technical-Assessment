import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import IncidentService from '../services/IncidentService';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import '../assets/Login.css';

const Login = () => {
  const [credentials, setCredentials] = useState({ email: '', password: '' });
  const navigate = useNavigate();

  const handleLogin = async (event) => {
    event.preventDefault();
    try {
      const response = await IncidentService.login(credentials);
      console.log('Login successful:', response);
      toast.success('Login Successful', {
        position: "top-center",
        autoClose: 2000,
        style: { whiteSpace: 'nowrap' }
      });
      navigate('/');
    } catch (error) {
      console.error('Login failed:', error);
      toast.error(`Login Failed: ${error.message}`, {
        position: "top-center",
        autoClose: 2000,
        style: { whiteSpace: 'nowrap' }
      });
    }
  };
  

  const handleForgotPassword = () => {
    navigate('/forgot-password'); // Assuming you have a route set up for this
  };

  return (
    <div className="login-container">
      <h2>Login</h2>
      <form onSubmit={handleLogin}>
        <label>Email:</label>
        <input type="email" name="email" value={credentials.email} onChange={e => setCredentials({...credentials, email: e.target.value})} required />
        <label>Password:</label>
        <input type="password" name="password" value={credentials.password} onChange={e => setCredentials({...credentials, password: e.target.value})} required />
        <button type="submit">Log In</button>
        <button type="button" onClick={handleForgotPassword} style={{ marginTop: '10px', backgroundColor: '#ffc107' }}>Forgot Password</button>
      </form>
    </div>
  );
};

export default Login;
