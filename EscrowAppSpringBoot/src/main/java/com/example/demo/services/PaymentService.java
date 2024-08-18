package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Booking;
import com.example.demo.entities.Payment;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.repositories.PaymentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    // Get all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Get payment by ID
    public Optional<Payment> getPaymentById(int id) {
        return paymentRepository.findById(id);
    }

    // Save or update payment
    public Payment saveOrUpdatePayment(Payment payment) {
        // Set the current date and time if not provided
        if (payment.getDate() == null) {
            payment.setDate(LocalDateTime.now());
        }

        // Retrieve the Booking entity and set the payment amount
        Booking booking = payment.getBooking();
        if (booking != null && booking.getBookId() > 0) {
            booking = bookingRepository.findById(booking.getBookId()).orElse(null);
            if (booking != null) {
                // Set the amount based on the Booking's amount
                payment.setAmount(booking.getAmount());
            }
        }

        return paymentRepository.save(payment);
    }

    // Delete payment by ID
    public void deletePayment(int id) {
        paymentRepository.deleteById(id);
    }

    // Find payment by booking ID
    public Payment findPaymentByBookId(int bookId) {
        return paymentRepository.findByBookingBookId(bookId);
    }
}