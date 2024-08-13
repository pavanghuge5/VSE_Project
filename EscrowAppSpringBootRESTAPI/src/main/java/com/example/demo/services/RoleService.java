package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.RoleRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    
}

