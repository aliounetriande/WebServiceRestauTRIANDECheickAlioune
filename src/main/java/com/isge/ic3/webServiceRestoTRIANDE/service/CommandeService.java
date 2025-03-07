package com.isge.ic3.webServiceRestoTRIANDE.service;

import com.isge.ic3.webServiceRestoTRIANDE.model.Commande;
import com.isge.ic3.webServiceRestoTRIANDE.repository.CommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id).orElseThrow(() -> new RuntimeException("Commande non trouvée"));
    }

    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    public Commande updateCommande(Long id, Commande commande) {
        Commande existingCommande = getCommandeById(id);
        existingCommande.setClient(commande.getClient());
        existingCommande.setStatut(commande.getStatut());
        return commandeRepository.save(existingCommande);
    }

    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }
}