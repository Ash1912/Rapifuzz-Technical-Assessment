import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <nav style={{ backgroundColor: "#002855", padding: "10px 20px" }}>
      {" "}
      {/* Darker and thinner navbar */}
      <div
        style={{
          display: "flex",
          justifyContent: "space-between",
          alignItems: "center",
        }}
      >
        <Link
          to="/"
          style={{ color: "white", textDecoration: "none", fontSize: "1.2rem" }}
        >
          Incident Management System
        </Link>
        <div>
          <Link to="/register" style={{ color: "white", marginRight: "20px" }}>
            Register
          </Link>
          <Link to="/login" style={{ color: "white" }}>
            Login
          </Link>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
