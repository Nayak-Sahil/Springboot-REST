package com.learning.springboot.api.controllers;

import com.learning.springboot.api.dto.ObjectivesDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjectivesController {

    @GetMapping("/objectives")
    public ObjectivesDTO getObjectives() {
        return new ObjectivesDTO(1, "Hire softwarecrafts person");
    }
}
