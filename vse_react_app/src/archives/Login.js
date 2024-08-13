import React, { useState } from 'react'; 
import { useNavigate } from 'react-router-dom'; 
import { useAuth } from './UserAuth'; 
import '../styles/login.css';

function Login() { 
  const [username, setUsername] = useState(''); 
  const [password, setPassword] = useState(''); 
  const navigate = useNavigate(); 
  const { login } = useAuth();

const handleSubmit = async (e) => { 
  e.preventDefault();

  sessionStorage.clear();

try {
  const response = await fetch('https://localhost:7278/api/User/VerifyLogin', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ username, password }),
  });

  if (!response.ok) {
    throw new Error('Login failed');
  }

  const data = await response.json();
  const rid = data.rid;

  console.log('Role ID:', rid);

  console.log('Storing rid in sessionStorage:', rid);
  sessionStorage.setItem('rid', rid);

  login({ username, rid });

  if (rid === 0) {
    console.log('Admin');
    navigate('/admin');
  } else if (rid === 1) {
    navigate('/seller');
  } else if (rid === 2) {
    navigate('/buyer');
  } else {
    navigate('/');
  }

} catch (error) {
  console.error('Error during login:', error);
  alert('Login failed. Please check your credentials.');
}
};

return ( <div> 
  <div className="welcome-container"> 
    <h1 className="welcome-text" style={{ color: 'rgba(255, 255, 255, 0.8)' }}>Welcome to VSEscrow</h1> 
    </div> 
    <div className="login-container"> 
      <form onSubmit={handleSubmit}> 
        <div className="mb-3"> 
          <input type="text" className="form-control" id="username" 
          value={username} onChange={(e) => setUsername(e.target.value)} 
          placeholder="Enter username" style={{ textAlign: 'center' }} required /> 
          </div> 
          <div className="mb-3"> 
            <input type="password" className="form-control" id="password" 
            value={password} onChange={(e) => setPassword(e.target.value)} 
            placeholder="Enter password" style={{ textAlign: 'center' }} required /> 
            </div>
             <button type="submit" className="btn btn-primary">Login</button> 
             </form> 
             </div> 
      </div> 
             ); 
  }

export default Login;