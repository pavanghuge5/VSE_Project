package com.example.demo.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "interest")
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interest_id")
    private int interestId;

    @ManyToOne
    @JoinColumn(name = "v_id", nullable=false)
    //@JsonIgnore
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "b_id", nullable = false)
//    @JsonIgnore
    private Buyer buyer;
    
//    @OneToOne(mappedBy = "interest", cascade = CascadeType.ALL)
//    @JsonIgnore
//    private Booking booking;

    public Interest() {
        super();
    }

    public Interest(int interestId, Vehicle vehicle, Buyer buyer) {
        this.interestId = interestId;
        this.vehicle = vehicle;
        this.buyer = buyer;
        //this.booking = booking;
//        , Booking booking
    }

    // Getters and Setters

    public int getInterestId() {
        return interestId;
    }

    public void setInterestId(int interestId) {
        this.interestId = interestId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
//    public Booking getBooking() {
//        return booking;
//    }
//
//    public void setBooking(Booking booking) {
//        this.booking = booking;
//    }
}