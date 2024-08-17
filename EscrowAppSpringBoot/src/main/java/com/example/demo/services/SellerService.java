package com.example.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Seller;
import com.example.demo.entities.User;
import com.example.demo.repositories.SellerRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;
   

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public Optional<Seller> getSellerById(int sId) {
        return sellerRepository.findById(sId);
    }

    

    
}
