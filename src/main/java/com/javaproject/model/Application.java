
package com.javaproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identity_verification_status")
    private String identityVerificationStatus;

    @Column(name = "address_verification_status")
    private String addressVerificationStatus;

    @Column(name = "annual_income")
    private double annualIncome;

    @Column(name = "credit_score")
    private int creditScore;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentityVerificationStatus() {
        return identityVerificationStatus;
    }

    public void setIdentityVerificationStatus(String identityVerificationStatus) {
        this.identityVerificationStatus = identityVerificationStatus;
    }

    public String getAddressVerificationStatus() {
        return addressVerificationStatus;
    }

    public void setAddressVerificationStatus(String addressVerificationStatus) {
        this.addressVerificationStatus = addressVerificationStatus;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }
}
