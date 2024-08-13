import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import "../styles/custom.css";

export default function AdminHome() {
    const [isNavExpanded, setIsNavExpanded] = useState(false);

    return (
    <div>
    <nav className="navbar navbar-expand-lg navbar-light" style={{ backgroundColor: '#FF9933' }}>
        <div className="container-fluid">
        <button
            className="navbar-toggler"
            type="button"
            aria-controls="navbarNavAltMarkup"
            aria-expanded={isNavExpanded}
            aria-label="Toggle navigation"
            onMouseEnter={() => setIsNavExpanded(true)}
            onMouseLeave={() => setIsNavExpanded(false)}
        >
            <span className="navbar-toggler-icon"></span>
        </button>
        <div className={`navbar-collapse ${isNavExpanded ? 'expand' : 'collapse'}`} id="navbarNavAltMarkup">
            <ul className="navbar-nav">
            <li className="nav-item">
                <Link to="/admin" className='nav-link custom-link px-3'>Approve Payment</Link>
            </li>
            <li className="nav-item">
                <Link to="/admin" className='nav-link custom-link px-3'>Confirm Deal</Link>
            </li>
            <li className="nav-item">
                <Link to="/logout" className='nav-link custom-link px-3'>Logout</Link>
            </li>
            </ul>
        </div>
        </div>
    </nav>
    <div>
        <h1>Admin Page</h1>
        <p>Welcome, Admin! Manage your platform here.</p>
    </div>
    </div>
);
}
