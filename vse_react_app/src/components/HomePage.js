import React from 'react';
import { useNavigate } from 'react-router-dom';
import '../styles/HomePage.css';
import Navbar from './Navbar';

export default function HomePage() {
  const navigate = useNavigate();

  const handleLoginClick = () => {
    navigate('/login');
  };

  const handleRegistrationClick = () => {
    navigate('/registration');
  };

  return (
    <Navbar></Navbar>
  );
}
