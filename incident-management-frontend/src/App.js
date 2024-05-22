import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import AddIncident from "./components/AddIncident";
import IncidentList from "./components/IncidentList";
import Navbar from "./components/Navbar";
import UpdateIncident from "./components/UpdateIncident";

function App() {
  return (
    <>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route index element={<IncidentList />} />
          <Route path="/" element={<IncidentList />}></Route>
          <Route path="/incidentList" element={<IncidentList />} />
          <Route path="/addIncident" element={<AddIncident />} />
          <Route path="/editIncident/:id" element={<UpdateIncident/>} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
