package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "interest")
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interest_id")
    private int interestId;

    @ManyToOne
    @JoinColumn(name = "v_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "b_id")
    private Buyer buyer;

	public Interest() {
		super();
		// TODO Auto-generated constructor stub
	}

	 public Interest(int interestId, Vehicle vehicle, Buyer buyer) {
	        this.interestId = interestId;
	        this.vehicle = vehicle;
	        this.buyer = buyer;
	    }
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
}

