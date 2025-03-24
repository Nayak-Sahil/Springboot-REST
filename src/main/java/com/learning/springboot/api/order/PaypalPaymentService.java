package com.learning.springboot.api.order;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

//@Primary
@Service("PaypalPaymentService")
public class PaypalPaymentService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        System.out.println("Paypal payment processing started");
        System.out.println("Amount: " + amount);
    }
}
