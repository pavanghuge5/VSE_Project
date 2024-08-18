import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import AdminHome from './components/AdminHome';
import SellerHome from './components/SellerHome';
import BuyerHome from './components/BuyerHome';
// import BuyerHome from './components/BuyerHome';
import Registration from './components/Registration';
import Home from './components/Home';
import { Link, Route, Routes } from 'react-router-dom';
import Logout from './components/Logout';
import "../src/styles/custom.css";
import VehicleForm from './components/AddVehicle';
// import { useSelector } from 'react-redux';
import Login from './components/Login';
import ShowVehicles from './components/ShowVehicles';



function App() {

  

  return (
    <div className="App">
      <div >
      <nav className="navbar navbar-expand-lg navbar-light" style={{ backgroundColor: '#FF9933' }}>
  <div className="container-fluid">
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
      <ul className="navbar-nav">
        <li className="nav-item">
          <Link to="/" className='nav-link custom-link px-3'> Home </Link>
        </li>
        <li className="nav-item">
          <Link to="registration" className='nav-link custom-link px-3'> Registration </Link>
        </li>
        <li className="nav-item">
          <Link to="login" className='nav-link custom-link px-3'> Login </Link>
        </li>
      </ul>
    </div>
  </div>
</nav>
        </div>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="login" element={<Login />} />
          <Route path="/registration" element={<Registration />} />
          <Route path="/admin" element={<AdminHome />} />
          <Route path="/seller" element={<SellerHome />} />
          <Route path="/seller/addVehicle" element={<VehicleForm />} />
          <Route path="/buyer" element={<BuyerHome />} />
          <Route path="/show-vehicles" element={<ShowVehicles />} />
          <Route path="/logout" element={<Logout />} />
        </Routes>
    </div>
  );
}

export default App;





//InitialState of logged
// const mystate =  useSelector((state) => state.logged);


// style={{display: mystate.loggedIn ? 'block' : 'none'}}