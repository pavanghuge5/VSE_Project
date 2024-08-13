// import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Route, Routes } from 'react-router-dom';
import Login from './components/Login';
import AdminPage from './components/AdminPage';
import SellerPage from './components/SellerPage';
import BuyerPage from './components/BuyerPage';
import { UserAuthProvider } from './components/UserAuth';
import Registration from './components/Registration';
import HomePage from './components/HomePage';





function App() {
  return (
    <div className="App">
       <UserAuthProvider>
        <Routes>
          <Route path="/" element={< HomePage />} />
          <Route path="/login" element={<Login />} />
          <Route path="/registration" element={<Registration />} />
          <Route path="/buyer" element={<BuyerPage />}/>
          <Route path="/seller" element={<SellerPage /> } />
          <Route path="/admin" element={<AdminPage />} />

        </Routes>
      </UserAuthProvider>
    </div>
  );
}

export default App;
