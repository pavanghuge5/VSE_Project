import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../styles/registration.css';
import Navbar from './Navbar';

function Registration() {
  const [formData, setFormData] = useState({
    userType: 'buyer',
    username: '',
    fname: '',
    lname: '',
    contact: '',
    address: '',
    email: '', // Added email field
    password: '',
    role_id: 2
  });

  const [usernameAvailable, setUsernameAvailable] = useState(true);
  const [registrationError, setRegistrationError] = useState('');
  const [formErrors, setFormErrors] = useState({});
  const navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => {
      const updatedData = { ...prevData, [name]: value };

      if (name === 'userType') {
        updatedData.role_id = value === 'seller' ? 1 : 2;
      }

      return updatedData;
    });

    if (name === 'username') {
      checkUsernameAvailability(value);
    }
  };

  const validateForm = () => {
    const errors = {};

    if (!formData.fname.trim()) {
      errors.fname = 'First name is required.';
    }
    if (!formData.lname.trim()) {
      errors.lname = 'Last name is required.';
    }
    if (!/^\d{10}$/.test(formData.contact)) {
      errors.contact = 'Contact number must be 10 digits.';
    }
    if (!/^(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$/.test(formData.password)) {
      errors.password = 'Password must be at least 8 characters long, include at least one uppercase letter, one lowercase letter, and one digit or special character.';
    }
    if (!/\S+@\S+\.\S+/.test(formData.email)) {
      errors.email = 'A valid email address is required.';
    }
    if (!formData.address.trim()) {
      errors.address = 'Address is required.';
    }

    setFormErrors(errors);
    return Object.keys(errors).length === 0;
  };

  const checkUsernameAvailability = async (username) => {
    try {
      const response = await axios.get(`https://localhost:7278/api/User/CheckUsername/${username}`);
      setUsernameAvailable(response.data.available);
    } catch (error) {
      console.error('There was an error checking the username!', error);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!validateForm()) {
      return;
    }
    if (!usernameAvailable) {
      setRegistrationError('Username is already taken. Please choose another one.');
      return;
    }

    const user = {
      Username: formData.username,
      Password: formData.password,
      RoleId: formData.role_id
    };

    const userDetails = {
      Fname: formData.fname,
      Lname: formData.lname,
      Address: formData.address,
      Email: formData.email, // Added email field
      User: user
    };

    if (formData.userType === 'buyer') {
      userDetails.BContact = formData.contact;
    } else if (formData.userType === 'seller') {
      userDetails.SContact = formData.contact;
    }

    try {
      const endpoint = formData.userType === 'seller'
        ? 'https://localhost:7278/api/User/SaveSeller'
        : 'https://localhost:7278/api/User/SaveBuyer';
      await axios.post(endpoint, userDetails);
      alert(`Registration successful for ${formData.userType}`);
      navigate(`/${formData.userType}`);
    } catch (error) {
      console.error('There was an error registering!', error);
      setRegistrationError('Registration Failed');
    }
  };

  return (
    <div>
      <Navbar />
      <div className="registration-container">
        <div className="card">
          <div className="card-header text-center">
            <h2>Register as {formData.userType.charAt(0).toUpperCase() + formData.userType.slice(1)}</h2>
          </div>
          <div className="card-body">
            <form onSubmit={handleSubmit}>
              <div className="mb-3">
                <label className="form-label">Register As</label>
                <select
                  style={{ textAlign: 'center' }}
                  className="form-control"
                  name="userType"
                  value={formData.userType}
                  onChange={handleChange}
                >
                  <option value="seller">Seller</option>
                  <option value="buyer">Buyer</option>
                </select>
              </div>
              <div className="row mb-3">
                <div className="col-md-6">
                  <label className="form-label">Username:</label>
                  <input
                    type="text"
                    className={`form-control ${!usernameAvailable ? 'is-invalid' : ''}`}
                    name="username"
                    value={formData.username}
                    onChange={handleChange}
                    required
                  />
                  {!usernameAvailable && <div className="invalid-feedback">Username is already taken. Please choose another one.</div>}
                </div>
                <div className="col-md-6">
                  <label className="form-label">Password:</label>
                  <input
                    type="password"
                    className="form-control"
                    name="password"
                    value={formData.password}
                    onChange={handleChange}
                    required
                  />
                  {formErrors.password && <div className="alert alert-danger mt-2">{formErrors.password}</div>}
                </div>
              </div>
              <div className="row mb-3">
                <div className="col-md-6">
                  <label className="form-label">First Name:</label>
                  <input
                    type="text"
                    className="form-control"
                    name="fname"
                    value={formData.fname}
                    onChange={handleChange}
                    required
                  />
                  {formErrors.fname && <div className="alert alert-danger mt-2">{formErrors.fname}</div>}
                </div>
                <div className="col-md-6">
                  <label className="form-label">Last Name:</label>
                  <input
                    type="text"
                    className="form-control"
                    name="lname"
                    value={formData.lname}
                    onChange={handleChange}
                    required
                  />
                  {formErrors.lname && <div className="alert alert-danger mt-2">{formErrors.lname}</div>}
                </div>
              </div>
              <div className="mb-3">
                <label className="form-label">Contact:</label>
                <input
                  type="text"
                  className="form-control"
                  name="contact"
                  value={formData.contact}
                  onChange={handleChange}
                  required
                />
                {formErrors.contact && <div className="alert alert-danger mt-2">{formErrors.contact}</div>}
              </div>
              <div className="mb-3">
                <label className="form-label">Address:</label>
                <input
                  type="text"
                  className="form-control"
                  name="address"
                  value={formData.address}
                  onChange={handleChange}
                  required
                />
                {formErrors.address && <div className="alert alert-danger mt-2">{formErrors.address}</div>}
              </div>
              <div className="mb-3">
                <label className="form-label">Email:</label>
                <input
                  type="email"
                  className="form-control"
                  name="email"
                  value={formData.email}
                  onChange={handleChange}
                  required
                />
                {formErrors.email && <div className="alert alert-danger mt-2">{formErrors.email}</div>}
              </div>
              {registrationError && <div className="alert alert-danger mt-2">{registrationError}</div>}
              <button type="submit" className="btn btn-primary">Register</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Registration;
