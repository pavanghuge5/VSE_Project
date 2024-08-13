package com.example.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.SellerRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;

   
}

