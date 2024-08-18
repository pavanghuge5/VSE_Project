import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

export default function ShowVehicles() {
  const [vehicles, setVehicles] = useState([]);

  useEffect(() => {
    const fetchVehicles = async () => {
      try {
        const response = await axios.get('http://localhost:8080/vehicles');
        setVehicles(response.data);
      } catch (error) {
        console.error('Error fetching vehicles:', error);
      }
    };

    fetchVehicles();
  }, []);

  const containerStyle = {
    maxHeight: '100vh',
    overflowY: 'auto'
  };

  return (
    <div className="container mt-3" style={containerStyle}>
      <nav className="navbar navbar-expand-lg navbar-light" style={{ backgroundColor: '#FF9933', position: "fixed" }}>
        <div className="container-fluid">
          <Link className="navbar-brand" to="/buyer">VSEscrow</Link>
          <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
            <ul className="navbar-nav">
            <li className="nav-item">
                <Link to="/buyer" className='nav-link custom-link px-3'>Buyer Home</Link>
            </li>
              <li className="nav-item">
                <Link to="/logout" className="nav-link custom-link px-3">Logout</Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <div></div>
      <div className="mb-4">
        <h4>All Vehicles</h4>
      </div>

      <div className="row">
        {vehicles.length > 0 ? (
          vehicles.map((vehicle, index) => (
            <div className="col-md-4 mb-4" key={index}>
              <div className="card h-100">
                <div className="card-header bg-primary text-white">
                  <h5 className="card-title mb-0">Vehicle Details</h5>
                </div>
                <div className="card-body">
                  <p><strong>Model Name:</strong> {vehicle?.model?.modelName || 'N/A'}</p>
                  <p><strong>Company Name:</strong> {vehicle?.company?.companyName || 'N/A'}</p>
                  <p><strong>Category Name:</strong> {vehicle?.category?.categoryName || 'N/A'}</p>
                  <p><strong>SubCategory Name:</strong> {vehicle?.subCategory?.subCategoryName || 'N/A'}</p>
                  <p><strong>Seller Name:</strong> {vehicle?.seller?.fname || 'N/A'} {vehicle?.seller?.lname || 'N/A'}</p>
                  <p><strong>Registration Year:</strong> {vehicle?.registrationYear || 'N/A'}</p>
                  <p><strong>Kms Driven:</strong> {vehicle?.kmsDriven || 'N/A'}</p>
                  <p><strong>Fuel Type:</strong> {vehicle?.fuelType || 'N/A'}</p>
                  <p><strong>Number of Seats:</strong> {vehicle?.noOfSeats || 'N/A'}</p>
                  <p><strong>Ownership:</strong> {vehicle?.ownership || 'N/A'}</p>
                  <p><strong>Transmission:</strong> {vehicle?.transmission || 'N/A'}</p>
                  <p><strong>Engine Capacity:</strong> {vehicle?.engineCapacity || 'N/A'}</p>
                  <p><strong>RTO:</strong> {vehicle?.rto || 'N/A'}</p>
                  <p><strong>Vehicle Price:</strong> ₹{vehicle?.vehiclePrice?.toLocaleString() || 'N/A'}</p>
                </div>
              </div>
            </div>
          ))
        ) : (
          <p>No vehicles found.</p>
        )}
      </div>
    </div>
  );
}
