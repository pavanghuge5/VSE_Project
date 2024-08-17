package com.example.demo.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "amount")
    private int amount;

    @OneToOne
    @JoinColumn(name = "interest_id", referencedColumnName = "interest_id", nullable = false)
   // @JsonIgnore
    private Interest interest;

    @Column(name = "date")
    private LocalDateTime date;

    // Default constructor
    public Booking() {
        super();
    }

    // Parameterized constructor
    public Booking(int bookId, int amount, Interest interest, LocalDateTime date) {
        this.bookId = bookId;
        this.amount = amount;
        this.interest = interest;
        this.date = date;
    }

    // Getters and Setters
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Interest getInterest() {
        return interest;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}