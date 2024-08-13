package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.BuyerService;

@RestController
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    
}

