import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const BuyerPage = () => {
  const navigate = useNavigate();

  useEffect(() => {
    const rid = sessionStorage.getItem('rid');
    console.log('Redirecting based on rid:', rid);
    if (rid !== '2') {  
      navigate('/');
    }
  }, [navigate]);

  return (
    <div>
      <h1>Buyer Page</h1>
      <p>Welcome, Buyer! Browse and purchase products here.</p>
    </div>
  );
};

export default BuyerPage;
