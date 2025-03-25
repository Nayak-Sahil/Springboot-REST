package com.learning.springboot.api.controllers;

import com.learning.springboot.api.dto.KeyResultsDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyResultsController {

    @GetMapping("/key-results")
    public String getPreference(@RequestParam("id") String id) {
        return "You want objective of id " + id + " am i right?";
    }
}
