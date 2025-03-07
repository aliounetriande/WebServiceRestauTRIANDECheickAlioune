package com.isge.ic3.webServiceRestoTRIANDE.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom ne peut pas être vide")
    @Size(min = 3, max = 100, message = "Le nom doit avoir entre 3 et 100 caractères")
    private String nom;

    @NotBlank(message = "La description ne peut pas être vide")
    @Size(min = 10, max = 255, message = "La description doit avoir entre 10 et 255 caractères")
    private String description;

    @Positive(message = "Le prix doit être un montant positif")
    private double prix;

    @ManyToMany
    private List<Plat> plats;
}
