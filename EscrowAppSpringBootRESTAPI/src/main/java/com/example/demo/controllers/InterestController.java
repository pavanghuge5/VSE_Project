package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.InterestService;

@RestController
public class InterestController {
    @Autowired
    private InterestService interestService;

   
}
