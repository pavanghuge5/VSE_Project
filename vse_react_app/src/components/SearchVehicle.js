import React, { useState } from 'react';
import axios from 'axios';

export default function SearchVehicle() {
  const [modelName, setmodelName] = useState('');
  const [vehicles, setVehicles] = useState([]);

  const handleSearch = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/vehicles/models/${modelName}`);
      setVehicles(response.data);
    } catch (error) {
      console.error('Error fetching vehicles:', error);
    }
  };

  const containerStyle = {
    maxWidth: '100%',
    padding: '20px',
    overflowY: 'auto', // Enable vertical scrolling
  };

  const searchContainerStyle = {
    position: 'sticky', // Keep the search bar fixed at the top
    top: '0',
    zIndex: '1000',
    backgroundColor: '#fff', // Ensure the background is solid to cover other elements
    padding: '10px',
    borderBottom: '1px solid #ddd', // Optional: Add a border for separation
  };

  const resultContainerStyle = {
    marginTop: '20px', // Add space between the search bar and results
    overflowY: 'auto', // Enable scrolling within the results if necessary
    maxHeight: 'calc(100vh - 150px)', // Adjust height to prevent overflow
  };

  return (
    <div style={containerStyle}>
      <div style={searchContainerStyle}>
        <h4>Search for a Vehicle</h4><br/>
        <div style={{ display: 'flex', marginBottom: '1rem' }}>
          <input
            type="text"
            style={{
              flex: '1',
              padding: '0.5rem',
              border: '1px solid #ddd',
              borderRadius: '4px',
            }}
            placeholder="Enter Model Name"
            value={modelName}
            onChange={(e) => setmodelName(e.target.value)}
          />
          <button
            style={{
              marginLeft: '0.5rem',
              padding: '0.5rem 1rem',
              border: 'none',
              borderRadius: '4px',
              backgroundColor: '#007bff',
              color: '#fff',
              cursor: 'pointer',
            }}
            onClick={handleSearch}
          >
            Search
          </button>
        </div>
      </div>

      <div style={resultContainerStyle}>
        {vehicles.length > 0 ? (
          vehicles.map((vehicle, index) => (
            <div key={index} style={{ border: '1px solid #ddd', borderRadius: '4px', marginTop: '1rem' }}>
              <div style={{ padding: '1rem', borderBottom: '1px solid #ddd' }}>
                <h3 style={{ margin: '0' }}>Vehicle Details</h3>
              </div>
              <div style={{ padding: '1rem' }}>
                <p><strong>Model ID:</strong> {vehicle.model.modelId}</p>
                <p><strong>Model Name:</strong> {vehicle.model.modelName}</p>
                <p><strong>Company ID:</strong> {vehicle.company.companyId}</p>
                <p><strong>Company Name:</strong> {vehicle.company.companyName}</p>
                {/* Render other properties as needed */}
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
