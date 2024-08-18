package com.example.demo.dto;

public class ConfDTO {

	private int buyerConf;
	private Integer sellerConf;
    private Integer adminConf;

    // Default constructor
    public ConfDTO() {}

    // Parameterized constructor
    public ConfDTO(int buyerConf, Integer sellerConf, Integer adminConf) {
        this.buyerConf = buyerConf;
        this.sellerConf = sellerConf;
        this.adminConf = adminConf;
    }

    // Getter and Setter
    public int getBuyerConf() {
        return buyerConf;
    }

    public void setBuyerConf(int buyerConf) {
        this.buyerConf = buyerConf;
    }
    public Integer getSellerConf() {
        return sellerConf;
    }

    public void setSellerConf(Integer sellerConf) {
        this.sellerConf = sellerConf;
    }

    public Integer getAdminConf() {
        return adminConf;
    }

    public void setAdminConf(Integer adminConf) {
        this.adminConf = adminConf;
    }
}
