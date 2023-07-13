package com.epicode.airSabri.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epicode.airSabri.models.Aereo;
import com.epicode.airSabri.models.Biglietto;
import com.epicode.airSabri.models.MyUser;
import com.epicode.airSabri.security.repository.BigliettoDAO;
import com.epicode.airSabri.security.repository.UtenteDAO;

@Service
public class BigliettoService {

    private final BigliettoDAO bigliettoRepository;
    
    @Autowired
    UtenteDAO utenteRepository;

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

    public List<Biglietto> getAllBiglietti() { 
        return bigliettoRepository.findAll();
    }
   
	public List<Biglietto> findTicket(String username) {
		MyUser u = utenteRepository.findByUserName(username).get();
		List<Biglietto> lista = u.getBiglietti();
		return lista;
	}
}

