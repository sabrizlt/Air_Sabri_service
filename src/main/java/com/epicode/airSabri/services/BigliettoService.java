package com.epicode.airSabri.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.airSabri.models.Biglietto;
import com.epicode.airSabri.security.repository.BigliettoDAO;

@Service
public class BigliettoService {

    private final BigliettoDAO bigliettoRepository;

    @Autowired
    public BigliettoService(BigliettoDAO bigliettoRepository) {
        this.bigliettoRepository = bigliettoRepository;
    }

    public Biglietto createBiglietto(Biglietto biglietto) {
        return bigliettoRepository.save(biglietto);
    }

    public Biglietto getBigliettoById(Long id) {
        return bigliettoRepository.findById(id).orElse(null);
    }

    public Iterable<Biglietto> getAllBiglietti() {
        return bigliettoRepository.findAll();
    }

    public void deleteBiglietto(Long id) {
        bigliettoRepository.deleteById(id);
    }

    // Altre operazioni di business logic specifiche, se necessario

}

