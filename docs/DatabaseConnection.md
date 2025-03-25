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

- ## Connect Springboot application with Postgresql
    - We need following dependency must be installed:
        - `PostgreSQL Driver`
        - `Spring Data JPA`
  
    - ### Now, you might be wondering about why we didn't install `JDBC` OR `Hibernate`
        - **JDBC (Java Database Connectivity)** is already included in Java. It is part of the **Java Standard Library** and comes with the **JDK** (Java Development Kit). You don’t need to install it separately.
        - Even you don't need to manually install Hibernate** when working with Spring Boot, especially for connecting a PostgreSQL database.
        - Spring Boot **automatically configures** Hibernate as part of its **Spring Data JPA** support. When you include the **`spring-boot-starter-data-jpa`** dependency.