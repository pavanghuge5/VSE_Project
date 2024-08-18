import React, { useState } from 'react';
import axios from 'axios';
import Escrow from './Escrow'; // Assuming Escrow is in the same directory

export default function SearchVehicle() {
  const [modelName, setModelName] = useState('');
  const [vehicles, setVehicles] = useState([]);
  const [selectedVehicle, setSelectedVehicle] = useState(null);

  const handleSearch = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/vehicles/models/${modelName}`);
      setVehicles(response.data);
    } catch (error) {
      console.error('Error fetching vehicles:', error);
    }
  };

  const handleInterest = (vehicle) => {
    setSelectedVehicle(vehicle); // Set the selected vehicle when "Show Interest" is clicked
  };

  const containerStyle = {
    maxHeight: '100vh',
    overflowY: 'auto',
  };

  return (
    <div className="container mt-4" style={containerStyle}>
    
      <div className="mb-4">
      <div></div>
      <div></div>
      <div></div>
      <div></div>
        <h4>Search for a Vehicle</h4>
        <div className="input-group">
          <input
            type="text"
            className="form-control"
            placeholder="Enter Model Name"
            value={modelName}
            onChange={(e) => setModelName(e.target.value)}
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
                    <p><strong>Model Name:</strong> {vehicle.model.modelName}</p>
                    <p><strong>Company Name:</strong> {vehicle.company.companyName}</p>
                    <p><strong>Category Name:</strong> {vehicle.category.categoryName}</p>
                    <p><strong>SubCategory Name:</strong> {vehicle.subCategory.subCategoryName}</p>
                    <p><strong>Seller Name:</strong> {vehicle.seller.fname} {vehicle.seller.lname}</p>
                    <p><strong>Registration Year:</strong> {vehicle.registrationYear}</p>
                    <p><strong>Kms Driven:</strong> {vehicle.kmsDriven}</p>
                    <p><strong>Fuel Type:</strong> {vehicle.fuelType}</p>
                    <p><strong>Number of Seats:</strong> {vehicle.noOfSeats}</p>
                    <p><strong>Ownership:</strong> {vehicle.ownership}</p>
                    <p><strong>Transmission:</strong> {vehicle.transmission}</p>
                    <p><strong>Engine Capacity:</strong> {vehicle.engineCapacity}</p>
                    <p><strong>RTO:</strong> {vehicle.rto}</p>
                    <p><strong>Vehicle Price:</strong> {vehicle.vehiclePrice}</p>
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
