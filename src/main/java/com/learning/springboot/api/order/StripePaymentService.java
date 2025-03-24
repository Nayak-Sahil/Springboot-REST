package com.learning.springboot.api.order;

public class StripePaymentService implements PaymentService {
    public void processPayment(double amount) {
        System.out.println("Stripe payment processing started");
        System.out.println("Amount: " + amount);
    }
}
