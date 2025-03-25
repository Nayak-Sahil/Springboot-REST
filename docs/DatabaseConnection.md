- For Database connectivity, Understand these concept first:
    - `JDBC, JPA, Hibernate.`

- ### Watch this video for JDBC
    - video(https://www.youtube.com/watch?v=7v2OnUti2eM)
  
- ### Hibernate
    - ![Mastering ORM in Java: A Deep Dive into JPA and Hibernate | by Adem kok |  Medium](https://miro.medium.com/v2/resize:fit:720/1*ZgiCg3eetdhDBJ_9LQe1Vg.png)
    - `Must Refer`: https://medium.com/@dev.kokadm/mastering-orm-in-java-a-deep-dive-into-jpa-and-hibernate-6658c375ab62
    - With JDBC, you know it's a 6-7 steps process in which one is for creating statement (SQL) to execute and perform operation in database, Now we have Data in object form in java application now we manually have to write such SQL query (`Insert into customer values(customer.id, customer.name, ...)`) that gets executed correctly,
    - **That is very tedious and repetitive work for all data object and table operation.**
    - Here, Hibernate comes which basically Map Java Object with Database Table (ORM: Object Relationship Mapping)

- ## To understand everything related to Database in Spring in One-shot

    video(https://www.youtube.com/watch?v=GkkcZXF-mD8&list=PLsyeobzWxl7qbKoSgR5ub6jolI8-ocxCF&index=19)

- ## Why we need so much libraries, tools, etc.. (JPA, JDBC, ORM)
- **Traditional Approach**:
    - Earlier, to interact with the database, we had to manually write **JDBC** code (6-7 steps long), including establishing a connection, writing SQL queries, executing them, and handling exceptions, all within the `@Repository` class.

- **Spring JDBC**:
    - To reduce this overhead, **Spring JDBC** was introduced. It provided a **standardized template** (like `JdbcTemplate`) to simplify database operations, reducing boilerplate code.

- **Spring JDBC Limitation**:
    - Even though **Spring JDBC** reduced the repetitive code, developers still had to manually write SQL queries and map Java objects to database tables, which could be error-prone.

- **ORM (Object-Relational Mapping)**:
    - To simplify this further, **ORM** frameworks like **Hibernate** were introduced. ORM automatically maps Java objects to database tables, so developers don’t have to manually write SQL queries for basic operations.

- **JPA (Java Persistence API)**:
    - However, if we wanted to switch from one ORM (e.g., **Hibernate**) to another (e.g., **EclipseLink**), we would need to change significant parts of the code. To solve this, **JPA** was introduced as a standard. **JPA** defines the rules for ORM, so we can switch between different ORM frameworks without changing much code.

- **Spring Data JPA**:
    - In Spring Boot, **Spring Data JPA** makes working with JPA even easier. It simplifies database interaction by providing repositories and automatically generating queries. It also ensures we follow the JPA standard, making it easier to switch between ORM frameworks.

## Connect Springboot application with Postgresql
We need following dependency must be installed:
- `PostgreSQL Driver`
- `Spring Data JPA`
  
### Now, you might be wondering about why we didn't install `JDBC` OR `Hibernate`
        
  - **JDBC (Java Database Connectivity)** is already included in Java. It is part of the **Java Standard Library** and comes with the **JDK** (Java Development Kit). You don’t need to install it separately.
    - Even you don't need to manually install Hibernate** when working with Spring Boot, especially for connecting a PostgreSQL database.
      
    - Spring Boot **automatically configures** Hibernate as part of its **Spring Data JPA** support. When you include the **`spring-boot-starter-data-jpa`** dependency.

## Steps to connect with PostgreSQL Database

1. Create `ObjectivesEntity.java` file inside `entities` directory.
```java
// Example
package com.learning.springboot.api.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity // To indicate JPA Entity, and it will be mapped to a database table.
@Table(name = "Objectives") // Explicitly Specify Table, If omitted, the table name defaults to the class name ("ObjectiveEntity").
public class ObjectivesEntity {

    // Field of class ---> Table column

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String objective;
}
```
2. Create Interface `ObjectiveRepository.java` inside `repositories` directory
```java
package com.learning.springboot.api.repositories;

import com.learning.springboot.api.entities.ObjectivesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface provides CRUD operations for the "ObjectivesEntity" class with a String type primary key.
/**
 * Syntax: JpaRepository<ENTITY_CLASS_NAME, TYPE_OF_PRIMARY_FIELD>
 */
public interface ObjetiveRepository extends JpaRepository<ObjectivesEntity, String> {
}
```
3. To configure the connection to a database, you'll need to define several predefined properties in the `application.properties` file.
```bash
# Minimum required properties

# DataSource Configuration (JDBC connection details)
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update   # Options: create, create-drop, update, validate
```

Done 🚀, You can see reflection(table created) to specified database.