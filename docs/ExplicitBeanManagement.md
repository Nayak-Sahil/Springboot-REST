## Explicit Bean Management
In Spring Boot, the IoC (Inversion of Control) container automatically manages beans that are annotated with @Component, @Service, @Repository, etc. These beans are automatically instantiated and injected where required. However, in certain scenarios, we might want more control over how and when beans are created. This is where Explicit Bean Management comes into play.

### Why Explicit Bean Management?
While Spring can automatically manage beans using @Component and other annotations, there are cases where you might want to:
- Control the creation of a bean with specific configuration.
- Beans can be defined explicitly to load based on profile/environment (although you could argue that without specific configuration file, this can be done by declaring individual services). However, by using a configuration file, we can group multiple beans together and load them conditionally based on the environment or profile (such as development or production).


### How to Manage Beans Explicitly?
Instead of using annotations like @Component, we can define beans explicitly in a @Configuration class. This allows you to have more control over the bean creation process.

- Steps for Explicit Bean Management
    - Create a configuration/ Directory: You can organize all your custom bean configurations in a dedicated configuration/ directory to keep things clean.

    - Create a @Configuration Class: In this class, you can define beans explicitly using the @Bean annotation. These beans are then available for dependency injection throughout your application.

### Example
```java
@Configuration
@Profile("prod") 
// the entire config file(all beans) loaded based on profile=production
// which you can set in application.properties
// spring.profiles.active=production

public class ProdDataSourceConfig {

    @Bean
    public DataSource dataSource() {
        PostgreSQLDataSource dataSource = new PostgreSQLDataSource();
        // Configure your PostgreSQL database here
        dataSource.setUrl("jdbc:postgresql://prod-db.example.com:5432/prod_db");
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("prod_user");
        dataSource.setPassword("prod_password");
        return dataSource;
    }
    
    // Multiples other beans...
    // ... ...
}


// Similarly you can also create another separate configuration file for all beans that are used in specific in profile/environment

// This is just one usecase, there are multiple usecase for explicit bean management
```