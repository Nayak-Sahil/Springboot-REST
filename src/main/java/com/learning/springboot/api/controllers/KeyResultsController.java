package com.learning.springboot.api.controllers;

import com.learning.springboot.api.dto.KeyResultsDTO;
import com.learning.springboot.api.services.KeyResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KeyResultsController {

    @Autowired
    KeyResultService service;

    @GetMapping("/key-results")
    public List<KeyResultsDTO> getKeyResults() {
        return service.getAllKeyResults();
    }

    @GetMapping("/key-results/{id}")
    public KeyResultsDTO getKeyResultById(@PathVariable("id") String id) {
        return service.getKeyResultById(id);
    }

    @PostMapping("/key-results")
    public KeyResultsDTO insertKeyResult(@RequestBody KeyResultsDTO data) {
        return service.insertKeyResult(data);
    }

    @DeleteMapping("/key-results/{id}")
    public void deleteKeyResult(@PathVariable("id") String id) {
        service.deleteKeyResult(id);
    }

}
