# Resolving Ambiguity in Spring Boot Beans

When using **Spring Boot's Inversion of Control (IoC)** container, it automatically handles dependency injection. However, when you have multiple beans of the same type, Spring Boot may not know which specific bean to inject, resulting in an ambiguity error. There are several ways to resolve this ambiguity:

## Solutions to Resolve Ambiguity

1. @Primary
2. @Qualifier
3. @Profile
4. @MockBean
5. etc...

---

## 1. @Primary

**@Primary** is used to define the default bean to be injected when there are multiple beans of the same type. If you don't want to specify which bean to inject in a scenario where multiple options are available, you can annotate one of the beans with **@Primary**.

### Example:
```java
@Component
@Primary
public class DefaultPaymentService implements PaymentService {
    @Override
    public void processPayment() {
        System.out.println("Processing payment through Default Service");
    }
}
```
## 2. @Qualifier
@Qualifier is used when you need to explicitly specify which bean to inject, among multiple options of the same type. You can use it in the following ways:

- Field Injection
- Setter Injection
- Constructor Injection

### Using @Qualifier with Field Injection
```java
@Qualifier("paypal")  // Specify the exact bean by name
private PaymentService paymentService;
```

### Using @Qualifier with Setter Injection
```java
@Qualifier("paypal")  // Specify the exact bean by name
public void setPaymentService(PaymentService paymentService) {
    this.paymentService = paymentService;
}
```

### Using @Qualifier with Constructor Injection
```java
@Autowired
public OrderService(@Qualifier("paypal") PaymentService paymentService) {
    this.paymentService = paymentService;
}
```

### Key Notes:
- The name used in @Qualifier("bean_name") must match the name defined in @Service("bean_name") or @Component("bean_name").

### Which One Should You Use?

- @Qualifier with Field or Setter Injection:
    - Use this when you need to resolve ambiguity in simple scenarios and don't need to enforce immutability of the dependency.
  - It's easy and quick, but not as explicit and clear as constructor injection.
- Constructor Injection with @Qualifier:
    - Use this when you want to make the dependency explicit, immutable, and testable.
    - This is generally considered the best practice

## 3. @Profile
@Profile is used to define beans that are available only when certain profiles are active. This allows you to conditionally enable or disable specific beans or configuration classes based on the currently active environment or profile.

```java
@Component
@Profile("dev")  // This bean will only be available when 'dev' profile is active
public class DevService implements MyService {
    @Override
    public void execute() {
        System.out.println("Running in Development environment");
    }
}

@Component
@Profile("prod")  // This bean will only be available when 'prod' profile is active
public class ProdService implements MyService {
    @Override
    public void execute() {
        System.out.println("Running in Production environment");
    }
}
```
### Specifying Active Profiles
To specify the active profile in application.properties, use the following configuration:

`spring.profiles.active=dev`

This configuration will make the DevService bean active when the 'dev' profile is selected. Similarly, the ProdService bean will only be available when the 'prod' profile is active.
