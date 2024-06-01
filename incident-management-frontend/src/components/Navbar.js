import React, { useContext } from "react";
import { Link } from "react-router-dom";
import { AuthContext } from "../contexts/AuthContext"; // Assume you have an AuthContext

const Navbar = () => {
  const { isAuthenticated, logout } = useContext(AuthContext);

  return (
    <nav style={{ backgroundColor: "#002855", padding: "10px 20px" }}>
      <div style={{ display: "flex", justifyContent: "space-between", alignItems: "center" }}>
        <Link to="/" style={{ color: "white", textDecoration: "none", fontSize: "1.2rem" }}>
          Incident Management System
        </Link>
        <div>
          {isAuthenticated ? (
            <>
              <Link to="/profile" style={{ color: "white", marginRight: "20px" }}>
                Profile
              </Link>
              <button onClick={logout} style={{ color: "white" }}>
                Logout
              </button>
            </>
          ) : (
            <>
              <Link to="/register" style={{ color: "white", marginRight: "20px" }}>
                Register
              </Link>
              <Link to="/login" style={{ color: "white", marginRight: "20px" }}>
                Login
              </Link>
              <Link to="/addIncident" style={{ color: "white", marginRight: "20px" }}>
                Add Incident
              </Link>
            </>
          )}
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
