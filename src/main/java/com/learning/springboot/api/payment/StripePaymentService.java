package com.learning.springboot.api.payment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class StripePaymentService implements PaymentService {
    public void processPayment(double amount) {
        System.out.println("Stripe payment processing started");
        System.out.println("Amount: " + amount);
    }
}
