package com.isge.ic3.webServiceRestoTRIANDE.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La date de la commande ne peut pas être nulle")
    private LocalDateTime date;

    @ManyToMany
    private List<Plat> plats;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Le statut de la commande ne peut pas être nul")
    private StatutCommande statut;

    @ManyToOne
    @NotNull(message = "Le client ne peut pas être nul")
    private Client client;

    @PositiveOrZero(message = "Le prix total doit être positif ou nul")
    private double prixTotal;
}
