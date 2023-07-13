package com.epicode.airSabri.controllers;

import com.epicode.airSabri.models.Aereo;
import com.epicode.airSabri.services.AereoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aerei")
public class AereoController {

    private final AereoService aereoService;

    @Autowired
    public AereoController(AereoService aereoService) {
        this.aereoService = aereoService;
    }

    @PostMapping
    public ResponseEntity<Aereo> addAereo(@RequestBody Aereo aereo) {
        Aereo newAereo = aereoService.saveAereo(aereo);
        return new ResponseEntity<>(newAereo, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Aereo>> getAllAerei() {
        List<Aereo> aerei = aereoService.getAllAerei();
        return new ResponseEntity<>(aerei, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aereo> getAereoById(@PathVariable("id") Long id) {
        Aereo aereo = aereoService.getAereoById(id);
        if (aereo != null) {
            return new ResponseEntity<>(aereo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
