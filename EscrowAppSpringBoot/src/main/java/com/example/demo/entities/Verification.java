package com.example.demo.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "verification")
public class Verification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "verification_id")
    private int verificationId;

    @ManyToOne
    @JoinColumn(name = "b_id", referencedColumnName = "b_id", nullable = false)
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "s_id", referencedColumnName = "s_id", nullable = false)
    private Seller seller;

    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id", nullable = false)
    private Payment payment;

    @Column(name = "buyr_conf")
    private int buyerConf;

    @Column(name = "sellr_conf")
    private int sellerConf;

    @Column(name = "admin_conf")
    private int adminConf;

    // Default constructor
    public Verification() {
        super();
    }

    // Parameterized constructor
    public Verification(int verificationId, Buyer buyer, Seller seller, Payment payment, int buyerConf, int sellerConf, int adminConf) {
        this.verificationId = verificationId;
        this.buyer = buyer;
        this.seller = seller;
        this.payment = payment;
        this.buyerConf = buyerConf;
        this.sellerConf = sellerConf;
        this.adminConf = adminConf;
    }

    // Getters and Setters
    public int getVerificationId() {
        return verificationId;
    }

    public void setVerificationId(int verificationId) {
        this.verificationId = verificationId;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int getBuyerConf() {
        return buyerConf;
    }

    public void setBuyerConf(int buyerConf) {
        this.buyerConf = buyerConf;
    }

    public int getSellerConf() {
        return sellerConf;
    }

    public void setSellerConf(int sellerConf) {
        this.sellerConf = sellerConf;
    }

    public int getAdminConf() {
        return adminConf;
    }

    public void setAdminConf(int adminConf) {
        this.adminConf = adminConf;
    }
}
