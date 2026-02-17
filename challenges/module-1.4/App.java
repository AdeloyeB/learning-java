/*
 * Module 1.4 Challenge: Refactor Into Clean Methods (SRP)
 * Task: Break monolithic printTransaction() into single-responsibility methods
 * Concepts: Single Responsibility Principle, method signatures, data flowing
 *           through parameters, static vs instance, BigDecimal string constructor
 */
package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class App {
    public String getPaymentMessage() {
        return "Payment Calculator v1.0\nReady to process transactions ";
    }

    public BigDecimal calculateFee(BigDecimal amount, BigDecimal rate){
        BigDecimal fee = amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
        return fee;
    }

    public BigDecimal calculateTotal(BigDecimal amount, BigDecimal fee){
        BigDecimal totalAmount = amount.add(fee).setScale(2, RoundingMode.HALF_UP);
        return totalAmount;
    }

    public String formatTransaction(BigDecimal totalAmount, BigDecimal fee, String merchantName, String currency){
        String printTransaction ="Merchant Name " + merchantName + "\n" + "Currency: " + currency + "\n" + "Total Amount: " + totalAmount + " \n" + "Fee: " + fee;
        return printTransaction;
    }

    public String transactionRiskLevel(BigDecimal amount) {
        if (amount.compareTo(new BigDecimal("10000")) > 0) {
            return "HIGH";
        } else if (amount.compareTo(new BigDecimal("1000")) > 0) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }

    public String riskAction(String riskLevel) {
        String action = switch (riskLevel) {
            case "HIGH" -> "Requires manual review";
            case "MEDIUM" -> "Automated 3DS check";
            case "LOW" -> "Auto-approve";
            default -> "Unknown risk level";
        };
        return action;
    }

    public static void main(String[] args) {
        App app = new App();
        BigDecimal amount = new BigDecimal("5000");
        BigDecimal calculateFee = app.calculateFee(amount, new BigDecimal("0.02"));
        BigDecimal calculateTotal = app.calculateTotal(amount, calculateFee);
        String formattedTransction = app.formatTransaction(calculateTotal, calculateFee, "Checkout.com", "GBP");
        System.out.println(formattedTransction);
    }
}
