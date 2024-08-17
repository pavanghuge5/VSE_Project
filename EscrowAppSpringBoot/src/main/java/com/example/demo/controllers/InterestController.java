package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Interest;
import com.example.demo.entities.Vehicle;
import com.example.demo.services.InterestService;

@RestController
@RequestMapping("/api/interests")
public class InterestController {
    @Autowired
    private InterestService interestService;
    
 // Get all interests
    @GetMapping
    public ResponseEntity<List<Interest>> getAllInterests() {
        List<Interest> interests = interestService.getAllInterests();
        if (interests.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(interests, HttpStatus.OK);
    }

    // Get interest by ID
    @GetMapping("/{id}")
    public ResponseEntity<Interest> getInterestById(@PathVariable int id) {
        Optional<Interest> interest = interestService.getInterestById(id);
        return interest.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create or update an interest
    @PostMapping
    public ResponseEntity<Interest> saveOrUpdateInterest(@RequestBody Interest interest) {
        Interest savedInterest = interestService.saveOrUpdateInterest(interest);
        return new ResponseEntity<>(savedInterest, HttpStatus.CREATED);
    }

    // Delete interest by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInterest(@PathVariable int id) {
        if (interestService.deleteInterest(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get interests by Buyer ID
    @GetMapping("/buyer/{bId}")
    public ResponseEntity<List<Interest>> getInterestsByBuyerId(@PathVariable int bId) {
        List<Interest> interests = interestService.getInterestsByBuyerId(bId);
        if (interests.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(interests, HttpStatus.OK);
    }

    // Get interests by Vehicle ID
    @GetMapping("/vehicle/{vId}")
    public ResponseEntity<List<Interest>> getInterestsByVehicleId(@PathVariable int vId) {
        List<Interest> interests = interestService.getInterestsByVehicleId(vId);
        if (interests.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(interests, HttpStatus.OK);
    }
}
