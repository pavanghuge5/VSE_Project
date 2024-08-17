package com.example.demo.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Buyer;
import com.example.demo.repositories.BuyerRepository;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;
    public List<Buyer> getAllBuyers() {
        return buyerRepository.findAll();
    }

    public Optional<Buyer> getBuyerById(int bId) {
        return buyerRepository.findById(bId);
    }

    public Buyer saveBuyer(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    public void deleteBuyerById(int bId) {
        buyerRepository.deleteById(bId);
    }
    
}

