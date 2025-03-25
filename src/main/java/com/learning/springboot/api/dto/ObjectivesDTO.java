package com.learning.springboot.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// Lombok library helps reduce boilerplate code by automatically generating common methods
// such as getters, setters, constructors, and utility methods for our classes.

@Data // Automatically generates getters and setters for all fields,
@AllArgsConstructor // generate constructor used for initializing the class with all required values
@NoArgsConstructor // Generates a no-argument constructor
public class ObjectivesDTO {
    private long id;
    private String objective;
}
