/*
 * Module 1.3 Challenge: Transaction Risk Router
 * Task: Use if/else with BigDecimal.compareTo() to determine risk level,
 *       then use a Java 21 switch expression to map risk → action
 * Concepts: if/else branching, BigDecimal comparison, switch expressions (->),
 *           switch as value-producing expression, method chaining, static vs instance
 */
package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class App {
    public String getPaymentMessage() {
        return "Payment Calculator v1.0\nReady to process transactions ";
    }

    public String printTransaction(){
        boolean approved = true;
        long id = 1001L;
        String merchantName = "Coca Cola";
        String currency = "USD";
        BigDecimal amount = new BigDecimal("100.00");
        BigDecimal rate = new BigDecimal("0.029");
        BigDecimal fee = amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
        BigDecimal totalAmount = amount.add(fee);
        String message = "Transaction " + id + " " + (approved ? "approved" : "rejected") + " for " + merchantName + " in " + currency + " with amount " + amount + " and total amount " + totalAmount;
        return message;
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
        String riskLevel = app.transactionRiskLevel(amount);
        String action = app.riskAction(riskLevel);
        System.out.println("Amount: " + amount + " | Risk: " + riskLevel + " | Action: " + action);
    }
}
