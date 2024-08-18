import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

function AddVehicle() {
    const [formData, setFormData] = useState({
        companyId: '',
        modelId: '',
        sId: '', // seller ID
        categoryId: '',
        subCategoryId: '',
        registrationYear: '',
        kmsDriven: '',
        fuelType: '',
        noOfSeats: '',
        ownership: '',
        transmission: '',
        engineCapacity: '',
        rto: '',
        vehicleImages: null,
        vehiclePrice: ''
    });

    const [categories, setCategories] = useState([]);
    const [subCategories, setSubCategories] = useState([]);
    const [noOfSeatsError, setNoOfSeatsError] = useState('');
    const [ownershipError, setOwnershipError] = useState('');
    const [engineCapacityError, setEngineCapacityError] = useState('');
    const [kmsDrivenError, setKmsDrivenError] = useState('');
    const [vehiclePriceError, setVehiclePriceError] = useState('');
    const [transmissionError, setTransmissionError] = useState('');
    const [fuelTypeError, setFuelTypeError] = useState('');
    const [rtoError, setRtoError] = useState('');
    const [registrationYearError, setRegistrationYearError] = useState('');
    const navigate = useNavigate();

    useEffect(() => {
        // Fetch categories from the backend
        axios.get('http://localhost:8080/vehicles/categories')
            .then(response => setCategories(response.data))
            .catch(error => console.error('There was an error fetching categories!', error));
    }, []);

    const handleCategoryChange = (e) => {
        const selectedCategoryId = e.target.value;
        setFormData(prevData => ({ ...prevData, categoryId: selectedCategoryId }));

        // Fetch subcategories based on the selected category
        axios.get(`http://localhost:8080/vehicles/subcategories/${selectedCategoryId}`)
            .then(response => setSubCategories(response.data))
            .catch(error => console.error('There was an error fetching subcategories!', error));
    };

    const handleChange = (e) => {
        const { name, value } = e.target;

        // Clear previous errors
        if (name === 'noOfSeats') {
            setNoOfSeatsError('');
        } else if (name === 'ownership') {
            setOwnershipError('');
        } else if (name === 'engineCapacity') {
            setEngineCapacityError('');
        } else if (name === 'kmsDriven') {
            setKmsDrivenError('');
        } else if (name === 'vehiclePrice') {
            setVehiclePriceError('');
        } else if (name === 'transmission') {
            setTransmissionError('');
        } else if (name === 'fuelType') {
            setFuelTypeError('');
        } else if (name === 'rto') {
            setRtoError('');
        } else if (name === 'registrationYear') {
            setRegistrationYearError('');
        }

        setFormData(prevData => ({ ...prevData, [name]: value }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        // Regex for validation
        const numericRegex = /^[0-9]+$/;
        const capitalLettersRegex = /^[A-Z]+$/;
        const rtoRegex = /^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$/;
        const registrationYearRegex = /^[A-Z]{3}[0-9]{4}$/;

        let isValid = true;

        if (!numericRegex.test(formData.engineCapacity)) {
            setEngineCapacityError('Only numeric values are allowed');
            isValid = false;
        }

        if (!numericRegex.test(formData.kmsDriven)) {
            setKmsDrivenError('Only numeric values are allowed');
            isValid = false;
        }

        if (!numericRegex.test(formData.vehiclePrice)) {
            setVehiclePriceError('Only numeric values are allowed');
            isValid = false;
        }

        if (!capitalLettersRegex.test(formData.transmission)) {
            setTransmissionError('Only capital letters are allowed');
            isValid = false;
        }

        if (!capitalLettersRegex.test(formData.fuelType)) {
            setFuelTypeError('Only capital letters are allowed');
            isValid = false;
        }

        if (!rtoRegex.test(formData.rto)) {
            setRtoError('RTO format should be: XX00XX0000 (e.g. MH12AB1234)');
            isValid = false;
        }

        if (!registrationYearRegex.test(formData.registrationYear)) {
            setRegistrationYearError('Registration Year format should be: Month in capital follwed by year (e.g. JAN2021)');
            isValid = false;
        }

        if (!isValid) {
            return; // Prevent form submission if validation fails
        }

        const vehicleData = {
            company: { companyId: formData.companyId },
            model: { modelId: formData.modelId },
            seller: { sId: formData.sId },
            category: { categoryId: formData.categoryId },
            subCategory: { subCategoryId: formData.subCategoryId },
            registrationYear: formData.registrationYear,
            kmsDriven: formData.kmsDriven,
            fuelType: formData.fuelType,
            noOfSeats: formData.noOfSeats,
            ownership: formData.ownership,
            transmission: formData.transmission,
            engineCapacity: formData.engineCapacity,
            rto: formData.rto,
            vehicleImages: formData.vehicleImages,
            vehiclePrice: formData.vehiclePrice
        };

        axios.post('http://localhost:8080/vehicles', vehicleData)
            .then(() => {
                alert('Vehicle added successfully!');
                navigate('/seller');
            })
            .catch(error => {
                console.error('There was an error adding the vehicle!', error);
                alert('Failed to add the vehicle.');
            });
    };

    return (
        <div className="vehicle-form-container container mt-5">
            <div className="card">
                <div className="card-header text-center">
                    <h2>Add New Vehicle</h2>
                    
                </div>
                <div>
                 </div>
                <div className="card-body">
                    <form onSubmit={handleSubmit}>
                        <div className="row">
                            <div className="col-md-6">
                                <div className="mb-3">
                                    <label className="form-label">Company ID:</label>
                                    <input type="text" className="form-control" name="companyId" value={formData.companyId} onChange={handleChange} required />
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Model ID:</label>
                                    <input type="text" className="form-control" name="modelId" value={formData.modelId} onChange={handleChange} required />
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Seller ID:</label>
                                    <input type="text" className="form-control" name="sId" value={formData.sId} onChange={handleChange} required />
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Category:</label>
                                    <select className="form-control" name="categoryId" value={formData.categoryId} onChange={handleCategoryChange} required>
                                        <option value="">Select Category</option>
                                        {categories.map(category => (
                                            <option key={category.categoryId} value={category.categoryId}>
                                                {category.categoryName}
                                            </option>
                                        ))}
                                    </select>
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Subcategory:</label>
                                    <select className="form-control" name="subCategoryId" value={formData.subCategoryId} onChange={handleChange} required>
                                        <option value="">Select Subcategory</option>
                                        {subCategories.map(subCategory => (
                                            <option key={subCategory.subCategoryId} value={subCategory.subCategoryId}>
                                                {subCategory.subCategoryName}
                                            </option>
                                        ))}
                                    </select>
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Registration Year:</label>
                                    <input type="text" className="form-control" name="registrationYear" value={formData.registrationYear} onChange={handleChange} required />
                                    {registrationYearError && <div className="text-danger">{registrationYearError}</div>}
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">KMs Driven:</label>
                                    <input type="text" className="form-control" name="kmsDriven" value={formData.kmsDriven} onChange={handleChange} required />
                                    {kmsDrivenError && <div className="text-danger">{kmsDrivenError}</div>}
                                </div>
                            </div>
                            <div className="col-md-6">
                                <div className="mb-3">
                                    <label className="form-label">Fuel Type:</label>
                                    <input type="text" className="form-control" name="fuelType" value={formData.fuelType} onChange={handleChange} required />
                                    {fuelTypeError && <div className="text-danger">{fuelTypeError}</div>}
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">No. of Seats:</label>
                                    <input type="text" className="form-control" name="noOfSeats" value={formData.noOfSeats} onChange={handleChange} required />
                                    {noOfSeatsError && <div className="text-danger">{noOfSeatsError}</div>}
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Ownership:</label>
                                    <input type="text" className="form-control" name="ownership" value={formData.ownership} onChange={handleChange} required />
                                    {ownershipError && <div className="text-danger">{ownershipError}</div>}
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Transmission:</label>
                                    <input type="text" className="form-control" name="transmission" value={formData.transmission} onChange={handleChange} required />
                                    {transmissionError && <div className="text-danger">{transmissionError}</div>}
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Engine Capacity:</label>
                                    <input type="text" className="form-control" name="engineCapacity" value={formData.engineCapacity} onChange={handleChange} required />
                                    {engineCapacityError && <div className="text-danger">{engineCapacityError}</div>}
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">RTO:</label>
                                    <input type="text" className="form-control" name="rto" value={formData.rto} onChange={handleChange} required />
                                    {rtoError && <div className="text-danger">{rtoError}</div>}
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Vehicle Price:</label>
                                    <input type="text" className="form-control" name="vehiclePrice" value={formData.vehiclePrice} onChange={handleChange} required />
                                    {vehiclePriceError && <div className="text-danger">{vehiclePriceError}</div>}
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Vehicle Images:</label>
                                    <input type="file" className="form-control" name="vehicleImages" onChange={(e) => setFormData(prevData => ({ ...prevData, vehicleImages: e.target.files[0] }))} />
                                </div>
                            </div>
                        </div>
                        <div className="text-center">
                            <button type="submit" className="btn btn-primary">Add Vehicle</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default AddVehicle;