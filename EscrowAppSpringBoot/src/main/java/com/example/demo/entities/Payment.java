package com.example.demo.entities;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;

    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", nullable = false)
    private Booking booking;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "amount")
    private int amount;

    // Default constructor
    public Payment() {
        super();
    }

    // Parameterized constructor
    public Payment(int paymentId, Booking booking, LocalDateTime date, int amount) {
        this.paymentId = paymentId;
        this.booking = booking;
        this.date = date;
        this.amount = amount;
    }

    // Getters and Setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
