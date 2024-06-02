import React from "react";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faFacebookF, faTwitter, faInstagram, faLinkedinIn, faGithub } from '@fortawesome/free-brands-svg-icons';

const Footer = () => {
  return (
    <footer style={footerStyle}>
      <p>© {new Date().getFullYear()} Developed with ❤️ by Ashish</p>
      <div style={iconContainerStyle}>
        <a href="https://www.facebook.com/profile.php?id=100051449386523" style={iconStyle}><FontAwesomeIcon icon={faFacebookF} /></a>
        <a href="https://twitter.com/AshishK80254497?t=hqsNacd6X7dGDWrmAhz-0g&s=08" style={iconStyle}><FontAwesomeIcon icon={faTwitter} /></a>
        <a href="https://www.instagram.com/ashish.mishra1909?igsh=bGFlOTJueW4yY25m" style={iconStyle}><FontAwesomeIcon icon={faInstagram} /></a>
        <a href="https://www.linkedin.com/in/ashish-mishra-616321206?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app" style={iconStyle}><FontAwesomeIcon icon={faLinkedinIn} /></a>
        <a href="https://github.com/Ash1912" style={iconStyle}><FontAwesomeIcon icon={faGithub} /></a>
      </div>
    </footer>
  );
};

const footerStyle = {
  position: 'fixed',
  left: 0,
  bottom: 0,
  width: '100%',
  backgroundColor: "#002855",
  padding: "10px 20px",
  color: "white",
  textAlign: "center",
  borderTop: "1px solid #00000050",
  paddingBottom: "10px",
};

const iconContainerStyle = {
  display: "flex",
  justifyContent: "center",
  alignItems: "center",
  marginTop: "10px"
};

const iconStyle = {
  color: "white",
  margin: "0 10px",
  textDecoration: "none"
};

export default Footer;
