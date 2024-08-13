import React, { useState, useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import { UserAuth } from './UserAuth';
import '../styles/login.css';

function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [role, setRole] = useState('');
  const { login } = useContext(UserAuth);
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    login(username, password, role);

    // Redirect to role-specific page
    if (role === 'admin') {
      navigate('/admin');
    } else if (role === 'seller') {
      navigate('/seller');
    } else if (role === 'buyer') {
      navigate('/buyer');
    } else {
      navigate('/');
    }
  };

  return (
    <div>
    <div className="welcome-container">
    <h1 className="welcome-text" style={{ color: 'rgba(255, 255, 255, 0.8)' }}>Welcome to VSEscrow</h1>
    </div>
    <div className="login-container">
      <form onSubmit={handleSubmit}>
      <div className="mb-3">
          <select
            className="form-select"
            id="role"
            value={role}
            onChange={(e) => setRole(e.target.value)}
          >
            <option value="" style={{ textAlign: 'center' }}>Login As</option>
            <option value="buyer">Buyer</option>
            <option value="seller">Seller</option>
            <option value="admin">Admin</option>
          </select>
        </div>
        <div className="mb-3">
          <input
            type="text"
            className="form-control"
            id="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            placeholder="Enter username" style={{ textAlign: 'center' }}
          />
        </div>
        <div className="mb-3">
          <input type="password"
            className="form-control" id="password" value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="Enter password" style={{ textAlign: 'center' }}
          />
        </div>
        <button type="submit" className="btn btn-primary">Login</button>
      </form>
    </div>
    </div>
  );
}

export default Login;
