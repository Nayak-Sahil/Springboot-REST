package com.learning.springboot.api.order;

public class OrderService {
    private PaymentService paymentService;

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        // How to make it loosely coupled?
        /**
         * OrderService <> StripePaymentService : Tightly Coupled
         * To make it loosely Couple both should be dependent on Abstract/Interface
         * Step 1: Make PaymentService Interface
         * Step 2: Use constructor Injection here
         * */
        paymentService.processPayment(10);
    }
}
