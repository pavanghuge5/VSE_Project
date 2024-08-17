package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Booking;
import com.example.demo.entities.Interest;
import com.example.demo.entities.Vehicle;
@Repository
public interface InterestRepository extends JpaRepository<Interest, Integer> {
	 List<Interest> findByBuyer_bId(int bId);
	    List<Interest> findByVehicle_vehicleId(int vId);
	    Optional<Booking> findBookingByInterestId(int interestId);
}

