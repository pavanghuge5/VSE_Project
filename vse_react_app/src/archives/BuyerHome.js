import React, { useEffect } from 'react';
import { Link, useNavigate } from 'react-router-dom';

export default function BuyerHome(){

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
      <h1>Buyer Page</h1>
      <p>Welcome, Buyer! Browse and purchase products here.</p>
    </div>
</div>
  );
}






























// import React, { useEffect } from 'react';
// import { useNavigate } from 'react-router-dom';

// const BuyerPage = () => {
//   const navigate = useNavigate();

//   useEffect(() => {
//     const rid = sessionStorage.getItem('rid');
//     console.log('Redirecting based on rid:', rid);
//     if (rid !== '2') {  
//       navigate('/');
//     }
//   }, [navigate]);

//   return (
//     <div>
//       <h1>Buyer Page</h1>
//       <p>Welcome, Buyer! Browse and purchase products here.</p>
//     </div>
//   );
// };

// export default BuyerPage;
