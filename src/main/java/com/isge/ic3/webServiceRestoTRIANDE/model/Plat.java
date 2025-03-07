package com.isge.ic3.webServiceRestoTRIANDE.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom du plat ne peut pas être vide")
    private String nom;

    @NotNull(message = "Le prix ne peut pas être nul")
    private double prix;

    private String description;

    @Enumerated(EnumType.STRING)
    private CategoriePlat categorie;

    @ElementCollection
    private List<String> allergenes;

    private boolean disponible;
}

enum CategoriePlat {
    ENTREE,
    PLAT_PRINCIPAL,
    DESSERT
}
