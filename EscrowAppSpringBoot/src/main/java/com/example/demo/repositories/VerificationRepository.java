package com.example.demo.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entities.Verification;

@Repository
public interface VerificationRepository extends JpaRepository<Verification, Integer> {
    
    // Find Verification by payment ID
    Verification findByPaymentPaymentId(int paymentId);
}
