package com.isge.ic3.webServiceRestoTRIANDE.model;
import jakarta.persistence.*;
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

    private String nom;
    private double prix;
    private String description;
    private String categorie;

    @ElementCollection
    private List<String> allergenes;

    private boolean disponible;
}