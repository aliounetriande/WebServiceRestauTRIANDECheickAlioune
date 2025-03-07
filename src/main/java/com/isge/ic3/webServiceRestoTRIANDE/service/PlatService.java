package com.isge.ic3.webServiceRestoTRIANDE.service;

import com.isge.ic3.webServiceRestoTRIANDE.model.Plat;
import com.isge.ic3.webServiceRestoTRIANDE.repository.PlatRepository;
import com.isge.ic3.webServiceRestoTRIANDE.exception.PlatNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class PlatService {

    private final PlatRepository platRepository;

    public PlatService(PlatRepository platRepository) {
        this.platRepository = platRepository;
    }

    public List<Plat> getAllPlats() {
        return platRepository.findAll();
    }

    public Plat getPlatById(Long id) {
        Optional<Plat> platOpt = platRepository.findById(id);
        if (platOpt.isPresent()) {
            return platOpt.get();
        } else {
            throw new PlatNotFoundException("Plat avec ID " + id + " non trouvé");
        }
    }

    public Plat createPlat(@Valid Plat plat) {
        // Validation côté serveur avec les annotations @Valid
        if (plat.getPrix() <= 0) {
            throw new IllegalArgumentException("Le prix du plat doit être supérieur à 0");
        }
        return platRepository.save(plat);
    }

    public Plat updatePlat(Long id, @Valid Plat plat) {
        Plat existingPlat = getPlatById(id);

        // Mise à jour des champs du plat
        existingPlat.setNom(plat.getNom());
        existingPlat.setPrix(plat.getPrix());
        existingPlat.setDescription(plat.getDescription());
        existingPlat.setCategorie(plat.getCategorie());
        existingPlat.setAllergenes(plat.getAllergenes());
        existingPlat.setDisponible(plat.isDisponible());

        return platRepository.save(existingPlat);
    }

    public void deletePlat(Long id) {
        Plat plat = getPlatById(id); // Cette méthode jette déjà une exception si le plat n'est pas trouvé
        platRepository.delete(plat);
    }
}
