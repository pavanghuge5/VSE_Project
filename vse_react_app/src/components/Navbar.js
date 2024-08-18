import { Link, useNavigate } from 'react-router-dom';
import '../styles/custom.css';

export default function Navbar(){
    return (
        <div>
        <nav className="navbar navbar-expand-lg navbar-light" style={{ backgroundColor: '#FF9933' }}>
  <div className="container-fluid">
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
        {/* <a class="nav-link" href="#">Features</a>
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a> */}
      </ul>
    </div>
  </div>
</nav>
</div>
    )
}