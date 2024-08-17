package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Buyer;
import com.example.demo.services.BuyerService;

@RestController
@RequestMapping("/api/buyers")
public class BuyerController {
    @Autowired
    private BuyerService buyerService;
    @GetMapping
    public List<Buyer> getAllBuyers() {
        return buyerService.getAllBuyers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buyer> getBuyerById(@PathVariable int id) {
        Optional<Buyer> buyer = buyerService.getBuyerById(id);
        if (buyer.isPresent()) {
            return ResponseEntity.ok(buyer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

