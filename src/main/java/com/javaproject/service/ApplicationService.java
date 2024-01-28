package com.javaproject.service;

import com.javaproject.repository.ApplicationRepository;
import com.javaproject.model.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public void verifyDocument() {
        // Open Document Verification App
        System.out.println("Welcome to the Document Verification App!");

        // Get user input for identity verification status
        String identityVerificationStatus = getUserInput("Is your identity verified? (yes/no)");

        // Get user input for address verification status
        String addressVerificationStatus = getUserInput("Is your address verified? (yes/no)");

        // Find application by verification status
        Application application = applicationRepository.findByVerificationStatus(identityVerificationStatus, addressVerificationStatus);

        // Check if both identity and address are verified
        if (application != null) {
            System.out.println("Congratulations! You are eligible for banking services.");
        } else {
            System.out.println("Document verification is incomplete. You are not eligible for banking services.");
        }

        // Close Document Verification App
        System.out.println("Thank you for using the Document Verification App!");
    }

    public void evaluateCredit() {
        // Get user input for annual income
        double annualIncome = Double.parseDouble(getUserInput("Enter your annual income:"));

        // Get user input for credit score
        int creditScore = Integer.parseInt(getUserInput("Enter your credit score:"));

        // Find eligible application for high limit credit
        Application highLimitCreditApplication = applicationRepository.findEligibleForHighLimitCredit();

        // Find eligible application for moderate limit credit
        Application moderateLimitCreditApplication = applicationRepository.findEligibleForModerateLimitCredit();

        // Check if user is eligible for high limit credit
        if (annualIncome >= 30000 && creditScore >= 700 && highLimitCreditApplication != null) {
            System.out.println("Congratulations! You are eligible for a credit score with a high limit.");
        } else if (annualIncome >= 20000 && creditScore >= 600 && moderateLimitCreditApplication != null) {
            System.out.println("You are eligible for a credit score with a moderate limit.");
        } else {
            System.out.println("You are not eligible for a credit score.");
        }
    }

    private String getUserInput(String message) {
        // Use Scanner to get user input
        Scanner scanner = new Scanner(System.in);

        System.out.println(message);
        return scanner.nextLine();
    }
}