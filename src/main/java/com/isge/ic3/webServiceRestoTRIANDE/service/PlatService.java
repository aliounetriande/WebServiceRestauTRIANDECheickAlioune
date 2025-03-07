package com.isge.ic3.webServiceRestoTRIANDE.service;

import com.isge.ic3.webServiceRestoTRIANDE.model.Plat;
import com.isge.ic3.webServiceRestoTRIANDE.repository.PlatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatService {

    private final PlatRepository platRepository;

    public PlatService(PlatRepository platRepository) {
        this.platRepository = platRepository;
    }

    public List<Plat> getAllPlats() {
        return platRepository.findAll();
    }

    public Plat getPlatById(Long id) {
        return platRepository.findById(id).orElseThrow(() -> new RuntimeException("Plat non trouvé"));
    }

    public Plat createPlat(Plat plat) {
        return platRepository.save(plat);
    }

    public Plat updatePlat(Long id, Plat plat) {
        Plat existingPlat = getPlatById(id);
        existingPlat.setNom(plat.getNom());
        existingPlat.setPrix(plat.getPrix());
        return platRepository.save(existingPlat);
    }

    public void deletePlat(Long id) {
        platRepository.deleteById(id);
    }
}