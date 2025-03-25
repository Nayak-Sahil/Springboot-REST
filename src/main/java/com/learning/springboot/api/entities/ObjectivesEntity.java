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
