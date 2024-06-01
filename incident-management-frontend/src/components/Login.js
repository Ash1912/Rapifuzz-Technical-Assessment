import React, { useState, useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import IncidentService from '../services/IncidentService';
import { AuthContext } from '../contexts/AuthContext';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import '../assets/Login.css';

const Login = () => {
  const [credentials, setCredentials] = useState({ email: '', password: '' });
  const { setAuthStatus } = useContext(AuthContext);
  const navigate = useNavigate();

  const handleLogin = async (event) => {
    event.preventDefault();
    try {
      const response = await IncidentService.login(credentials);
      if (response.data.errorCode === 100) {
        console.log('Login successful:', response.data);
        setAuthStatus(true);
        toast.success('Login Successful', {
          position: toast.POSITION.TOP_CENTER,
        });
        navigate('/');
      } else {
        throw new Error(response.data.status);
      }
    } catch (error) {
      console.error('Login failed:', error.response?.data || 'Unknown error');
      toast.error('Login Failed', {
        position: toast.POSITION.TOP_CENTER,
      });
    }
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
      </form>
    </div>
  );
};

export default Login;
