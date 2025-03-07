package com.isge.ic3.webServiceRestoTRIANDE.controller;

import com.isge.ic3.webServiceRestoTRIANDE.model.Plat;
import com.isge.ic3.webServiceRestoTRIANDE.service.PlatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plats") // 📌 Toutes les routes commenceront par /api/plats
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
    public ResponseEntity<Plat> createPlat(@RequestBody Plat plat) {
        return ResponseEntity.ok(platService.createPlat(plat));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plat> updatePlat(@PathVariable Long id, @RequestBody Plat plat) {
        return ResponseEntity.ok(platService.updatePlat(id, plat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlat(@PathVariable Long id) {
        platService.deletePlat(id);
        return ResponseEntity.noContent().build();
    }
}
