package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "buyer")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "b_id")
    private int bId;

    @Column(name = "fname")
    private String fname;

    @Column(name = "lname")
    private String lname;

    @Column(name = "b_contact", unique = true)
    private String bContact;

    @Column(name = "address")
    private String address;

    @Column(name = "b_acc_no")
    private String bAccNo;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "ifsc_code")
    private String ifscCode;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "uid", nullable = false)
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    @JsonIgnore 
    private List<Interest> interests;

    public Buyer() {
        super();
    }

    public Buyer(int bId, String fname, String lname, String bContact, String address, 
                 String bAccNo, String bankName, String ifscCode, User user, List<Interest> interests) {
        this.bId = bId;
        this.fname = fname;
        this.lname = lname;
        this.bContact = bContact;
        this.address = address;
        this.bAccNo = bAccNo;
        this.bankName = bankName;
        this.ifscCode = ifscCode;
        this.user = user;
        this.interests = interests;
    }

    // Getters and Setters

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getbContact() {
        return bContact;
    }

    public void setbContact(String bContact) {
        this.bContact = bContact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getbAccNo() {
        return bAccNo;
    }

    public void setbAccNo(String bAccNo) {
        this.bAccNo = bAccNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }
}