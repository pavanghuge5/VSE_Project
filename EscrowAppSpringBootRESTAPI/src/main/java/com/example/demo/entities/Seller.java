package com.example.demo.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "seller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private int sId;

    @Column(name = "fname")
    private String fname;

    @Column(name = "lname")
    private String lname;

    @Column(name = "s_contact", unique = true)
    private String sContact;

    @Column(name = "address")
    private String address;

    @Column(name = "s_acc_no")
    private String sAccNo;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "ifsc_code")
    private String ifscCode;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "uid", nullable = false)
    @JsonIgnore 
    private User user;

    public Seller() {
        super();
    }

    public Seller(int sId, String fname, String lname, String sContact, String address, 
                  String sAccNo, String bankName, String ifscCode, User user) {
        this.sId = sId;
        this.fname = fname;
        this.lname = lname;
        this.sContact = sContact;
        this.address = address;
        this.sAccNo = sAccNo;
        this.bankName = bankName;
        this.ifscCode = ifscCode;
        this.user = user;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
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

    public String getsContact() {
        return sContact;
    }

    public void setsContact(String sContact) {
        this.sContact = sContact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getsAccNo() {
        return sAccNo;
    }

    public void setsAccNo(String sAccNo) {
        this.sAccNo = sAccNo;
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
}
