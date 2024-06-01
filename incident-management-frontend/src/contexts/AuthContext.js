import React, { createContext, useState, useEffect } from 'react';
import IncidentService from '../services/IncidentService';

export const AuthContext = createContext();

const AuthProvider = ({ children }) => {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  useEffect(() => {
    // Check if the user is already authenticated (e.g., check local storage for a token)
    const token = localStorage.getItem('authToken');
    if (token) {
      setIsAuthenticated(true);
    }
  }, []);

  const login = async (credentials) => {
    try {
      const response = await IncidentService.login(credentials);
      localStorage.setItem('authToken', response.data.token); // Assuming the token is in response.data.token
      setIsAuthenticated(true);
    } catch (error) {
      console.error('Login failed:', error);
      throw error;
    }
  };

  const logout = () => {
    localStorage.removeItem('authToken');
    setIsAuthenticated(false);
  };

  return (
    <AuthContext.Provider value={{ isAuthenticated, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

export default AuthProvider;
