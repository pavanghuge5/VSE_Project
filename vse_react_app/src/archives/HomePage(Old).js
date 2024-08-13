import React from 'react';
import { useNavigate } from 'react-router-dom';
import '../styles/HomePage.css';

export default function HomePage() {
  const navigate = useNavigate();

  const handleLoginClick = () => {
    navigate('/login');
  };

  const handleRegistrationClick = () => {
    navigate('/registration');
  };

  return (
    <div className="container">
      <nav className="navbar">
        <div>VSEscrow</div>
        <div className="navLinks">
          <button className="button" onClick={handleLoginClick}>Login</button>
          <button className="button" onClick={handleRegistrationClick}>Registration</button>
        </div>
      </nav>
    </div>
  );
}
