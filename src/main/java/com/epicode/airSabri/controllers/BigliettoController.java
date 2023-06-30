package com.epicode.airSabri.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.airSabri.models.Biglietto;
import com.epicode.airSabri.models.MyUser;
import com.epicode.airSabri.security.payload.BigliettoDTO;
import com.epicode.airSabri.services.BigliettoService;
import com.epicode.airSabri.services.UtenteService;

import jakarta.annotation.security.PermitAll;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("api/auth")
public class BigliettoController {

	@Autowired
	private UtenteService utenteService;
	
    private final BigliettoService bigliettoService;

    @Autowired
    public BigliettoController(BigliettoService bigliettoService) {
        this.bigliettoService = bigliettoService;
    }

    @PostMapping("/biglietti")
    @PermitAll
    public ResponseEntity<String> createBiglietto(@RequestBody BigliettoDTO biglietto) {
        MyUser currentUser = utenteService.findByUsername(biglietto.getUsername());
        Biglietto b = new Biglietto();
        b.setArrivo(biglietto.getArrivo());
        b.setBagagli(biglietto.getBagagli());
        b.setPartenza(biglietto.getPartenza());
        b.setDataAndata(biglietto.getDataAndata());
        b.setDataRitorno(biglietto.getDataRitorno());
        b.setNumeroBiglietto(biglietto.getNumeroBiglietto());
        b.setUser(currentUser);

        bigliettoService.createBiglietto(b);

        return new ResponseEntity<>("Biglietto creato con successo." , HttpStatus.CREATED);
    }

}
