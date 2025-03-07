package com.isge.ic3.webServiceRestoTRIANDE.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;
    private String adresse;

    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;
}
