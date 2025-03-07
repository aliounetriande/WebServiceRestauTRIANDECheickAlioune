package com.isge.ic3.webServiceRestoTRIANDE.controller;

import com.isge.ic3.webServiceRestoTRIANDE.exception.MenuNotFoundException;
import com.isge.ic3.webServiceRestoTRIANDE.model.Menu;
import com.isge.ic3.webServiceRestoTRIANDE.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    // Récupérer tous les menus
    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    // Récupérer un menu par ID
    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(menuService.getMenuById(id));
        } catch (MenuNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Créer un nouveau menu
    @PostMapping
    public ResponseEntity<?> createMenu(@Valid @RequestBody Menu menu, BindingResult bindingResult) {
        // Vérifier les erreurs de validation
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().stream()
                    .map(objectError -> {
                        FieldError fieldError = (FieldError) objectError;
                        return fieldError.getField() + ": " + fieldError.getDefaultMessage();
                    })
                    .collect(Collectors.joining(", "));
            return ResponseEntity.badRequest().body(errorMessage);
        }
        return ResponseEntity.ok(menuService.createMenu(menu));
    }

    // Mettre à jour un menu existant
    @PutMapping("/{id}")
    public ResponseEntity<?> updateMenu(@PathVariable Long id, @Valid @RequestBody Menu menu, BindingResult bindingResult) {
        // Vérifier les erreurs de validation
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().stream()
                    .map(objectError -> {
                        FieldError fieldError = (FieldError) objectError;
                        return fieldError.getField() + ": " + fieldError.getDefaultMessage();
                    })
                    .collect(Collectors.joining(", "));
            return ResponseEntity.badRequest().body(errorMessage);
        }
        try {
            return ResponseEntity.ok(menuService.updateMenu(id, menu));
        } catch (MenuNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Supprimer un menu
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        try {
            menuService.deleteMenu(id);
            return ResponseEntity.noContent().build();
        } catch (MenuNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
