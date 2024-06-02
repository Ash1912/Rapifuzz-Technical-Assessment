import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import Login from './components/Login';
import Register from './components/Register';
import ForgotPassword from './components/ForgotPassword';
import IncidentList from './components/IncidentList';
import AddIncident from './components/AddIncident';
import UpdateIncident from './components/UpdateIncident';
import Footer from './components/Footer';
import './App.css';

function App() {
  return (
    <Router>
      <Navbar />
      <div className="container">
        <Routes>
          <Route path="/" element={<IncidentList />} />
          <Route path="/addIncident" element={<AddIncident />} />
          <Route path="/editIncident/:id" element={<UpdateIncident />} />
          <Route path="/register" element={<Register />} />
          <Route path="/login" element={<Login />} />
          <Route path="/forgot-password" element={<ForgotPassword />} />
        </Routes>
      </div>
      <Footer />
    </Router>
  );
}

export default App;
