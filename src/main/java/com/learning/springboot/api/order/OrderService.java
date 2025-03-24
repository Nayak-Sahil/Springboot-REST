package com.learning.springboot.api.order;

public class OrderService {
    public void placeOrder() {
        // OrderService class tightly coupled with StripePaymentService.
        // Problem: If later on requirement get change or new requirement come (E.g.: Use/Add GooglePayPaymentService) Then We have to come here and change this file.
        // Solution: We can make this loosely coupled code by "Dependency Injection".
        StripePaymentService service = new StripePaymentService();
        service.processPayment(10);
    }
}
