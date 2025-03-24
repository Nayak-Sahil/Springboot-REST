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

		/**
		 * This way doing things is great but still have problem not about tightly or loosely couple,
		 * but in fact injecting this way is a tedious and complex in some case.
		 * (How?)
		 *
		 * Especially when injecting service need another service:
		 * E.g.: new OrderService(new PaypalPaymentService(new OtherService())
		 *
		 * Problem: Refer: https://youtu.be/gJrjgg1KVL4?si=s8TXsTulTFl5TpNI&t=3793
		 * Solution: Use IoC (Inversion of Control): Spring IoC Container
 		 */

		OrderService service = new OrderService(new PaypalPaymentService());
		service.placeOrder();
	}
}
