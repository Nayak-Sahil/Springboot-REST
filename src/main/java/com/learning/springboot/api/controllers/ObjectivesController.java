package com.learning.springboot.api.controllers;

import com.learning.springboot.api.dto.ObjectivesDTO;
import com.learning.springboot.api.services.ObjectiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ObjectivesController {

    @Autowired
    ObjectiveService service;

    @GetMapping("/objectives")
    public List<ObjectivesDTO> getObjectives() {
        return service.getAllObjectives();
    }

    @GetMapping("/objectives/{id}")
    public ObjectivesDTO getObjective(@PathVariable("id") String id) {
        return service.getObjective(id);
    }

    @PostMapping("/objectives")
    public ObjectivesDTO insertObjectives(@RequestBody ObjectivesDTO data) {
        return service.insertObjective(data);
    }

    @DeleteMapping("/objectives/{id}")
    public void deleteObjectives(@PathVariable("id") String id) {
        service.deleteObjective(id);
    }
}
