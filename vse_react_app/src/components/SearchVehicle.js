import React, { useState } from 'react';
import axios from 'axios';
import Escrow from './Escrow'; // Assuming Escrow is in the same directory

export default function SearchVehicle() {
  const [searchTerm, setSearchTerm] = useState('');
  const [vehicles, setVehicles] = useState([]);
  const [selectedVehicle, setSelectedVehicle] = useState(null);
  const [expandedVehicleIds, setExpandedVehicleIds] = useState([]);

  const handleSearch = async () => {
    try {
      let response = await axios.get(`http://localhost:8080/vehicles/models/${searchTerm}`);
      if (response.data.length === 0) {
        response = await axios.get(`http://localhost:8080/vehicles/companies/${searchTerm}`);
      }
      setVehicles(response.data);
    } catch (error) {
      console.error('Error fetching vehicles:', error);
    }
  };

  const handleInterest = (vehicle) => {
    setSelectedVehicle(vehicle); // Set the selected vehicle when "Show Interest" is clicked
  };

  const toggleDetails = (vehicleId) => {
    if (expandedVehicleIds.includes(vehicleId)) {
      setExpandedVehicleIds(expandedVehicleIds.filter(id => id !== vehicleId));
    } else {
      setExpandedVehicleIds([...expandedVehicleIds, vehicleId]);
    }
  };

  const containerStyle = {
    maxHeight: '100vh',
    overflowY: 'auto',
  };

  return (
    <div className="container mt-4" style={containerStyle}>
       <div><br/><br/><br/></div>
      <div className="mb-4">
        <h4>Search for a Vehicle</h4>
        <div className="input-group mb-3">
          <input
            type="text"
            className="form-control"
            placeholder="Enter Model Name or Company Name"
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
          />
          <button className="btn btn-primary" onClick={handleSearch}>
            Search
          </button>
        </div>
      </div>

      {selectedVehicle ? (
        // Show the Escrow component if a vehicle is selected
        <Escrow vehicle={selectedVehicle} />
      ) : (
        <div className="row">
          {vehicles.length > 0 ? (
            vehicles.map((vehicle, index) => (
              <div className="col-md-4 mb-4" key={index}>
                <div className="card h-100">
                  <div className="card-header">
                    <h5 className="card-title mb-0">Vehicle Details</h5>
                  </div>
                  <div className="card-body">
                    <p><strong>Model Name:</strong> {vehicle?.model?.modelName || 'N/A'}</p>
                    <p><strong>Company Name:</strong> {vehicle?.company?.companyName || 'N/A'}</p>
                    <p><strong>Category Name:</strong> {vehicle?.category?.categoryName || 'N/A'}</p>
                    {expandedVehicleIds.includes(vehicle?.vehicleId) && (
                      <>
                        <p><strong>SubCategory Name:</strong> {vehicle?.subCategory?.subCategoryName || 'N/A'}</p>
                        <p><strong>Seller Name:</strong> {vehicle?.seller?.fname} {vehicle?.seller?.lname}</p>
                        <p><strong>Registration Year:</strong> {vehicle?.registrationYear || 'N/A'}</p>
                        <p><strong>Kms Driven:</strong> {vehicle?.kmsDriven || 'N/A'}</p>
                        <p><strong>Fuel Type:</strong> {vehicle?.fuelType || 'N/A'}</p>
                        <p><strong>Number of Seats:</strong> {vehicle?.noOfSeats || 'N/A'}</p>
                        <p><strong>Ownership:</strong> {vehicle?.ownership || 'N/A'}</p>
                        <p><strong>Transmission:</strong> {vehicle?.transmission || 'N/A'}</p>
                        <p><strong>Engine Capacity:</strong> {vehicle?.engineCapacity || 'N/A'}</p>
                        <p><strong>RTO:</strong> {vehicle?.rto || 'N/A'}</p>
                        <p><strong>Vehicle Price:</strong> {vehicle?.vehiclePrice || 'N/A'}</p>
                      </>
                    )}
                    <button
                      className="btn btn-link mt-3"
                      onClick={() => toggleDetails(vehicle.vehicleId)}
                    >
                      {expandedVehicleIds.includes(vehicle.vehicleId) ? 'See Less Details' : 'See More Details'}
                    </button>
                    <button
                      className="btn btn-success mt-3"
                      onClick={() => handleInterest(vehicle)}
                    >
                      Show Interest
                    </button>
                  </div>
                </div>
              </div>
            ))
          ) : (
            <p>No vehicles found.</p>
          )}
        </div>
      )}
    </div>
  );
}
