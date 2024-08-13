package com.example.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.InterestRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class InterestService {
    @Autowired
    private InterestRepository interestRepository;

    
}
