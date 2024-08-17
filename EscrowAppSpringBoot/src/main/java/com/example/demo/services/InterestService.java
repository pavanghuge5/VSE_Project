package com.example.demo.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Interest;
import com.example.demo.repositories.InterestRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class InterestService {
    @Autowired
    private InterestRepository interestRepository;
   

    // Basic CRUD operations
    public List<Interest> getAllInterests() {
        return interestRepository.findAll();
    }

    public Optional<Interest> getInterestById(int id) {
        return interestRepository.findById(id);
    }

    public Interest saveOrUpdateInterest(Interest interest) {
        return interestRepository.save(interest);
    }

    public boolean deleteInterest(int id) {
        if (interestRepository.existsById(id)) {
            interestRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Get interests by bId (Buyer ID)
    public List<Interest> getInterestsByBuyerId(int bId) {
        return interestRepository.findByBuyer_bId(bId);
    }

    // Get interests by vId (Vehicle ID)
    public List<Interest> getInterestsByVehicleId(int vId) {
        return interestRepository.findByVehicle_vehicleId(vId);
    }
   
    
}
