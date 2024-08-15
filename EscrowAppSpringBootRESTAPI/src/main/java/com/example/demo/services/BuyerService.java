package com.example.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.BuyerRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;

    
}

