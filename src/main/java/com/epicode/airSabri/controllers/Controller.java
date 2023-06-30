package com.epicode.airSabri.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
public class Controller {
    @GetMapping("/api/test")
    public String getTest() {
        return "test2345678";
    }
}
