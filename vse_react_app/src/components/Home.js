import React from 'react';
import { useNavigate } from 'react-router-dom';
import '../styles/HomePage.css';

export default function Home() {
  const navigate = useNavigate();

  const handleLoginClick = () => {
    navigate('/login');
  };

  const handleRegistrationClick = () => {
    navigate('/registration');
  };

  return (
    <div className="container">
        <div style={{ marginTop:'40px', fontSize : '2rem' }}>VSEscrow</div>
        <h1 style={{ marginTop:'20px', fontSize : '2rem' }}> Website Home Page</h1>
    </div>
  );
}







 {/* <div className="navLinks">
          <button className="button" onClick={handleLoginClick}>Login</button>
          <button className="button" onClick={handleRegistrationClick}>Registration</button>
        </div> */}