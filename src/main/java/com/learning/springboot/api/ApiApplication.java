package com.learning.springboot.api;

import com.learning.springboot.api.database.Database;
import com.learning.springboot.api.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

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
		// Step 1: Define IoC Container, since run() already return it then why not use this.
		ApplicationContext iocSpringContainer = SpringApplication.run(ApiApplication.class, args);


		// Let springboot to handle object (create, destroy)
		// OrderService service = new OrderService(new PaypalPaymentService());

		// Step 2: Get object from IoC, Here we called Bean (instead of object)
		OrderService service = iocSpringContainer.getBean(OrderService.class);

		/**
		 * At Step 2, If you try to run application, it will give the error "No qualifying bean of type"
		 * That means How springboot can understand you need exactly what object/bean?
		 *
		 * So, For that you need to Configure Beans using Annotations,
		 * Step 3: Annotate OrderService, StripePaymentService, PaypalPaymentService class with @Service
		 *
		 * Now before you run the application,
		 * You should think about whether it will work or not?
		 *
		 * Well, Not it won't work if you specify @Service to every Service class, because if you remember here we are not explicitly injecting any PaymentService through OrderService, So this cause problem: "Ambiguity".
		 * */

		service.placeOrder();
	}


	@Override
	// On startup if we want to do something we can use this.
	public void run(String... args) throws Exception {
		System.out.println("Application get started");
		System.out.println(db.checkConnection());
	}
}
