  import React, { useEffect } from 'react';
  import { useNavigate } from 'react-router-dom';

  const SellerPage = () => {
    const navigate = useNavigate();

    useEffect(() => {
      const rid = sessionStorage.getItem('rid');
      console.log('Redirecting based on rid:', rid);
      if (rid !== '1') {  // Redirect if the role ID is not Seller
        navigate('/');
      }
    }, [navigate]);

    return (
      <div>
        <h1>Seller Page</h1>
        <p>Welcome, Seller! Manage your products here.</p>
      </div>
    );
  };

  export default SellerPage;
