import React from 'react';
import { Link } from 'react-router-dom';
import SearchVehicle from './SearchVehicle';
import ShowVehicles from './ShowVehicles';

export default function BuyerHome() {
  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-light" style={{ backgroundColor: '#FF9933', position: "fixed" }}>
        <div className="container-fluid">
          <Link className="navbar-brand" to="/buyer">VSEscrow</Link>
          <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
            <ul className="navbar-nav">
            <li className="nav-item">
                <Link to="/show-vehicles" className='nav-link custom-link px-3'>Show Vehicles</Link>
            </li>
              {/* <li className="nav-item">
                <Link to="/seller" className="nav-link custom-link px-3">Approve Payment</Link>
              </li>
              <li className="nav-item">
                <Link to="/seller" className="nav-link custom-link px-3">Confirm Deal</Link>
              </li> */}
              <li className="nav-item">
                <Link to="/logout" className="nav-link custom-link px-3">Logout</Link>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <div>
        <h1 className="text-center">Welcome Buyer !</h1>
        <p className="text-center">Browse and purchase products here.</p>
        <SearchVehicle />
      </div>
    </div>
  );
}
















































// import React, { useState, useEffect } from 'react';
// import { Link } from 'react-router-dom';
// import SearchVehicle from './SearchVehicle';

// export default function BuyerHome() {
//   const [buyerName, setBuyerName] = useState('');
//   const [error, setError] = useState(null);
//   const userId = sessionStorage.getItem('userId'); // Fetch User ID from sessionStorage

//   useEffect(() => {
//     if (userId) {
//       const fetchBuyerName = async () => {
//         try {
//           const response = await fetch(`https://localhost:7289/api/User/GetBuyerByUserId/${userId}`);
//           if (!response.ok) {
//             throw new Error('Network response was not ok');
//           }
//           const data = await response.json();
//           setBuyerName(`${data.Fname} ${data.Lname}`);
//         } catch (error) {
//           setError('Error fetching buyer details');
//           console.error('Error fetching buyer details:', error);
//         }
//       };

//       fetchBuyerName();
//     } else {
//       setError('No user ID found');
//     }
//   }, [userId]);

//   return (
//     <div>
//       <nav className="navbar navbar-expand-lg navbar-light" style={{ backgroundColor: '#FF9933' }}>
//         <div className="container-fluid">
//           <Link className="navbar-brand" to="/">VSEscrow</Link>
//           <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
//             <ul className="navbar-nav">
//               <li className="nav-item">
//                 <Link to="/buyer" className="nav-link custom-link px-3">Approve Payment</Link>
//               </li>
//               <li className="nav-item">
//                 <Link to="/buyer" className="nav-link custom-link px-3">Confirm Deal</Link>
//               </li>
//               <li className="nav-item">
//                 <Link to="/logout" className="nav-link custom-link px-3">Logout</Link>
//               </li>
//             </ul>
//           </div>
//         </div>
//       </nav>
//       <div>
//         {error ? (
//           <p className="text-center">{error}</p>
//         ) : (
//           <>
//             <h1 className="text-center">Hello {buyerName || 'Buyer'}</h1>
//             <p className="text-center">Welcome, Buyer! Browse and purchase products here.</p>
//             <SearchVehicle />
//           </>
//         )}
//       </div>
//     </div>
//   );
// }