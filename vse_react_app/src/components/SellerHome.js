import React, { useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';

export default function SellerHome(){

return (
<div>
<nav className="navbar navbar-expand-lg navbar-light" style={{ backgroundColor: '#FF9933' }}>
<div className="container-fluid">
    <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
    <ul className="navbar-nav">
        <li className="nav-item">
            <Link to="/seller" className='nav-link custom-link px-3'> Approve Payment </Link>
        </li>
        <li className="nav-item">
            <Link to="/seller" className='nav-link custom-link px-3'> Confirm Deal </Link>
        </li>
        <li className="nav-item">
            <Link to="/logout" className='nav-link custom-link px-3'>Logout</Link>
        </li>
    </ul>
    </div>
</div>
</nav>
<div>
    <h1>Seller Page</h1>
    <p>Welcome, Seller! Manage your products here.</p>
    </div>
</div>
);
}

