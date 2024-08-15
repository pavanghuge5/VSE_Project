import React from 'react';
import { Link } from 'react-router-dom';
import SearchVehicle from './SearchVehicle';

export default function BuyerHome() {
  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-light" style={{ backgroundColor: '#FF9933' }}>
        <div className="container-fluid">
          <Link className="navbar-brand" to="/">VSEscrow</Link>
          <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
            <ul className="navbar-nav">
              <li className="nav-item">
                <Link to="/seller" className="nav-link custom-link px-3">Approve Payment</Link>
              </li>
              <li className="nav-item">
                <Link to="/seller" className="nav-link custom-link px-3">Confirm Deal</Link>
              </li>
              <li className="nav-item">
                <Link to="/logout" className="nav-link custom-link px-3">Logout</Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <div className="container mt-5">
        <h1 className="text-center">Buyer Page</h1>
        <p className="text-center">Welcome, Buyer! Browse and purchase products here.</p>
        <SearchVehicle />
      </div>
    </div>
  );
}