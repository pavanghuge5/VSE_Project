package com.example.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.ConfDTO;
import com.example.demo.entities.Verification;
import com.example.demo.services.VerificationService;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/verifications")
public class VerificationController {

    @Autowired
    private VerificationService verificationService;

    // 1. Get all verifications
    @GetMapping
    public ResponseEntity<List<Verification>> getAllVerifications() {
        List<Verification> verifications = verificationService.getAllVerifications();
        return ResponseEntity.ok(verifications);
    }

    // 2. Get verification by ID
    @GetMapping("/{id}")
    public ResponseEntity<Verification> getVerificationById(@PathVariable int id) {
        Optional<Verification> verification = verificationService.getVerificationById(id);
        return verification.map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 3. Create or update verification
    @PostMapping
    public ResponseEntity<Verification> createOrUpdateVerification(@RequestBody Verification verification) {
        Verification savedVerification = verificationService.saveOrUpdateVerification(verification);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVerification);
    }

    // 4. Delete verification by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVerification(@PathVariable int id) {
        verificationService.deleteVerification(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/buyer-conf")
    public ResponseEntity<Verification> updateBuyerConf(@PathVariable int id, @RequestBody ConfDTO confDTO) {
        Verification updatedVerification = verificationService.updateBuyerConf(id, confDTO.getBuyerConf());
        return ResponseEntity.ok(updatedVerification);
    }
    
    @PatchMapping("/{id}/seller-conf")
    public ResponseEntity<Verification> updateSellerConf(@PathVariable int id, @RequestBody ConfDTO confDTO) {
        Verification updatedVerification = verificationService.updateSellerConf(id, confDTO.getSellerConf());
        return ResponseEntity.ok(updatedVerification);
    }
    
    @PatchMapping("/{id}/admin-conf")
    public ResponseEntity<Verification> updateAdminConf(@PathVariable int id, @RequestBody ConfDTO confDTO) {
        Verification updatedVerification = verificationService.updateAdminConf(id, confDTO.getAdminConf());
        return ResponseEntity.ok(updatedVerification);
    }

}
