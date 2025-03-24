package com.learning.springboot.api.order;

public class PaypalPaymentService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        System.out.println("Paypal payment processing started");
        System.out.println("Amount: " + amount);
    }
}
