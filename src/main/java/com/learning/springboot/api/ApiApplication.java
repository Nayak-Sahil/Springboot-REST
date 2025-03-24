package com.learning.springboot.api;

import com.learning.springboot.api.database.Database;
import com.learning.springboot.api.order.OrderService;
import com.learning.springboot.api.order.PaypalPaymentService;
import com.learning.springboot.api.order.StripePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * CommandLineRunner Interface: Part of spring boot framework
 * Used to execute something after the Spring application context is loaded and app has started
 * void run(string... args) is method that need to implement it.
 *
 * It's a callback interface that trigger run() when app get start.
 * */
@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Autowired
	Database db;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}


	@Override
	// On startup if we want to do something we can use this.
	public void run(String... args) throws Exception {
		System.out.println("Application get started");
		System.out.println(db.getData());

		OrderService service = new OrderService();

		// Disadvantage of Setter Injection:
		/**
		 * Problem:
		 * Suppose
		 * 	someway anyhow if this setter injection get break or
		 * 	not able to set payment service or
		 * 	we forget to call setter injection, etc...
		 * In all this case our code get break.
		 *
		 * Solution:
		 *  1. Use Setter Injection (Optional Dependency)
		 * 	2. Use Construction Injection (When required to set Dependency first to do task)
		 *
		 * Example: Here PaymentService is not an optional dependency so we should not use setter-injection.
		 */
		service.setPaymentService(new PaypalPaymentService());
		service.placeOrder();
	}
}
