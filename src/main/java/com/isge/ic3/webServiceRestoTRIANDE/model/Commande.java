package com.isge.ic3.webServiceRestoTRIANDE.model;
import jakarta.persistence.*;
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

    private LocalDateTime date;

    @ManyToMany
    private List<Plat> plats;

    @Enumerated(EnumType.STRING)
    private StatutCommande statut;

    @ManyToOne
    private Client client;

    private double prixTotal;
}
