package com.example.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Buyer;
import com.example.demo.entities.Payment;
import com.example.demo.entities.Seller;
import com.example.demo.entities.Verification;
import com.example.demo.repositories.BuyerRepository;
import com.example.demo.repositories.PaymentRepository;
import com.example.demo.repositories.SellerRepository;
import com.example.demo.repositories.VerificationRepository;
import java.util.List;
import java.util.Optional;

@Service
public class VerificationService {

    @Autowired
    private VerificationRepository verificationRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private SellerRepository sellerRepository;

    // Get all verifications
    public List<Verification> getAllVerifications() {
        return verificationRepository.findAll();
    }

    // Get verification by ID
    public Optional<Verification> getVerificationById(int id) {
        return verificationRepository.findById(id);
    }

    // Save or update verification
    public Verification saveOrUpdateVerification(Verification verification) {
        // Retrieve Payment entity and set Buyer and Seller
        Payment payment = verification.getPayment();
        if (payment != null) {
            payment = paymentRepository.findById(payment.getPaymentId()).orElse(null);
            if (payment != null) {
                // Set Seller and Buyer from Payment
                verification.setSeller(payment.getBooking().getInterest().getVehicle().getSeller());
                verification.setBuyer(payment.getBooking().getInterest().getBuyer());
            }
        }

        // Set default null values for conf fields
//        verification.setBuyerConf(null);
//        verification.setSellerConf(null);
//        verification.setAdminConf(null);

        return verificationRepository.save(verification);
    }

    // Delete verification by ID
    public void deleteVerification(int id) {
        verificationRepository.deleteById(id);
    }
    
    
    public Verification updateBuyerConf(int verificationId, int buyerConf) {
        Verification verification = verificationRepository.findById(verificationId)
                .orElseThrow(() -> new RuntimeException("Verification not found"));
        verification.setBuyerConf(buyerConf);
        return verificationRepository.save(verification);
    }

    public Verification updateSellerConf(int verificationId, Integer sellerConf) {
        Verification verification = verificationRepository.findById(verificationId)
                .orElseThrow(() -> new RuntimeException("Verification not found"));
        if (sellerConf != null) {
            verification.setSellerConf(sellerConf);
        }
        return verificationRepository.save(verification);
    }
    
    public Verification updateAdminConf(int verificationId, Integer adminConf) {
        Verification verification = verificationRepository.findById(verificationId)
                .orElseThrow(() -> new RuntimeException("Verification not found"));
        if (adminConf != null) {
            verification.setAdminConf(adminConf);
        }
        return verificationRepository.save(verification);
    }
}
