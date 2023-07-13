package com.epicode.airSabri.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.airSabri.models.Aereo;
import com.epicode.airSabri.security.repository.AereoDAO;

import java.util.List;

@Service
public class AereoService {

    private final AereoDAO aereoDAO;

    @Autowired
    public AereoService(AereoDAO aereoDAO) {
        this.aereoDAO = aereoDAO;
    }

    public Aereo saveAereo(Aereo aereo) {
        return aereoDAO.save(aereo);
    }

    public List<Aereo> getAllAerei() {
        return aereoDAO.findAll();
    }

    public Aereo getAereoById(Long id) {
        return aereoDAO.findById(id).orElse(null);
    }
}
