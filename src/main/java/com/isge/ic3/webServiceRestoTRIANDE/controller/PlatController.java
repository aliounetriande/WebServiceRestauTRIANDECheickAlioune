package com.isge.ic3.webServiceRestoTRIANDE.controller;

import com.isge.ic3.webServiceRestoTRIANDE.model.Plat;
import com.isge.ic3.webServiceRestoTRIANDE.service.PlatService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/plats") // 📌 Toutes les routes commenceront par /api/plats
@Validated
public class PlatController {

    private final PlatService platService;

    public PlatController(PlatService platService) {
        this.platService = platService;
    }

    @GetMapping
    public List<Plat> getAllPlats() {
        return platService.getAllPlats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plat> getPlatById(@PathVariable Long id) {
        return ResponseEntity.ok(platService.getPlatById(id));
    }

    @PostMapping
    public ResponseEntity<Plat> createPlat(@Valid @RequestBody Plat plat) {
        Plat createdPlat = platService.createPlat(plat);
        return ResponseEntity.status(201).body(createdPlat); // Status 201 pour une ressource créée
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plat> updatePlat(@PathVariable Long id, @Valid @RequestBody Plat plat) {
        Plat updatedPlat = platService.updatePlat(id, plat);
        return ResponseEntity.ok(updatedPlat);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlat(@PathVariable Long id) {
        platService.deletePlat(id);
        return ResponseEntity.noContent().build(); // Code 204 pour une suppression réussie
    }
}
