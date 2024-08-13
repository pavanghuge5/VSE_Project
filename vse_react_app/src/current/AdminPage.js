import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const AdminPage = () => {
  const navigate = useNavigate();

  useEffect(() => {
    const rid = sessionStorage.getItem('rid');
    console.log('Redirecting based on rid:', rid);
    if (rid !== '0') {  
      navigate('/');
    }
  }, [navigate]);

  return (
    <div>
      <h1>Admin Page</h1>
      <p>Welcome, Admin! Manage your platform here.</p>
    </div>
  );
};

export default AdminPage;
