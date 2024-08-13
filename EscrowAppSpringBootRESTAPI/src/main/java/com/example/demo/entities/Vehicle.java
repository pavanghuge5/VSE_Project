package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "v_id")
    private int vehicleId;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Models model;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "s_id")
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "com_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "scat_id")
    private SubCategory subCategory;

    @Column(name = "registration_year")
    private String registrationYear;

    @Column(name = "kms_driven")
    private String kmsDriven;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "no_of_seats")
    private int noOfSeats;

    @Column(name = "ownership")
    private int ownership;

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "engine_capacity")
    private int engineCapacity;

    @Column(name = "rto")
    private String rto;

    @Column(name = "v_images")
    private String vehicleImages;

    @Column(name = "v_price")
    private int vehiclePrice;

    // Default constructor
    public Vehicle() {
        super();
    }

    // Parameterized constructor
    public Vehicle(int vehicleId, Models model, Seller seller, Company company,
                   Category category, SubCategory subCategory, String registrationYear,
                   String kmsDriven, String fuelType, int noOfSeats, int ownership,
                   String transmission, int engineCapacity, String rto, String vehicleImages,
                   int vehiclePrice) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.seller = seller;
        this.company = company;
        this.category = category;
        this.subCategory = subCategory;
        this.registrationYear = registrationYear;
        this.kmsDriven = kmsDriven;
        this.fuelType = fuelType;
        this.noOfSeats = noOfSeats;
        this.ownership = ownership;
        this.transmission = transmission;
        this.engineCapacity = engineCapacity;
        this.rto = rto;
        this.vehicleImages = vehicleImages;
        this.vehiclePrice = vehiclePrice;
    }

    // Getters and Setters
    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Models getModel() {
        return model;
    }

    public void setModel(Models model) {
        this.model = model;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public String getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(String registrationYear) {
        this.registrationYear = registrationYear;
    }

    public String getKmsDriven() {
        return kmsDriven;
    }

    public void setKmsDriven(String kmsDriven) {
        this.kmsDriven = kmsDriven;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public int getOwnership() {
        return ownership;
    }

    public void setOwnership(int ownership) {
        this.ownership = ownership;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getRto() {
        return rto;
    }

    public void setRto(String rto) {
        this.rto = rto;
    }

    public String getVehicleImages() {
        return vehicleImages;
    }

    public void setVehicleImages(String vehicleImages) {
        this.vehicleImages = vehicleImages;
    }

    public int getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(int vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }
}
