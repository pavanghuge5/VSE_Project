package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.BookingRepository;
import com.example.demo.entities.Booking;
import com.example.demo.entities.Interest;
import com.example.demo.entities.Vehicle;
import com.example.demo.repositories.InterestRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private InterestRepository interestRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(int id) {
        return bookingRepository.findById(id);
    }
    
    public Booking saveOrUpdateBooking(Booking booking) {
        // Set the current date and time if not provided
        if (booking.getDate() == null) {
            booking.setDate(LocalDateTime.now());
        }
        
        // Retrieve the Interest entity based on the interestId
        Interest interest = booking.getInterest();
        if (interest != null && interest.getInterestId() > 0) {
            // Fetch the full Interest entity from the database
            interest = interestRepository.findById(interest.getInterestId()).orElse(null);
            if (interest != null) {
                // Retrieve the Vehicle from Interest
                Vehicle vehicle = interest.getVehicle();
                if (vehicle != null) {
                    // Set the amount based on the Vehicle's price
                    booking.setAmount(vehicle.getVehiclePrice());
                }
            }
        }
        
        return bookingRepository.save(booking);
    }

//    public Booking saveBooking(Booking booking) {
//        // Set the current date and time if not already set
//        if (booking.getDate() == null) {
//            booking.setDate(LocalDateTime.now());
//        }
//      public Optional<Booking> getBookingByInterestId(int interestId) {
//      return Repository.findByInterestId(interestId);
//      }
//        // Set the amount to the vehicle price from interest
//        if (booking.getInterest() != null) {
//            int vehiclePrice = booking.getInterest().getVehicle().getVehiclePrice();
//            booking.setAmount(vehiclePrice);
//        }
//        return bookingRepository.save(booking);
//    }

    public void deleteBooking(int id) {
        bookingRepository.deleteById(id);
    }
    
    public Booking findBookingByInterestId(int interestId) {
        Interest interest = interestRepository.findById(interestId).orElse(null);
        if (interest != null) {
            return bookingRepository.findByInterest(interest);
        }
        return null;
    }

}


