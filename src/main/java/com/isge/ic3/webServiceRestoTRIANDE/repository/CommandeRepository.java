package com.isge.ic3.webServiceRestoTRIANDE.repository;

import com.isge.ic3.webServiceRestoTRIANDE.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
