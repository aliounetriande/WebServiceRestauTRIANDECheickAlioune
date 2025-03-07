package com.isge.ic3.webServiceRestoTRIANDE.service;

import com.isge.ic3.webServiceRestoTRIANDE.model.Commande;
import com.isge.ic3.webServiceRestoTRIANDE.repository.CommandeRepository;
import com.isge.ic3.webServiceRestoTRIANDE.exception.CommandeNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        // Si la commande n'est pas trouvée, lancer une exception spécifique
        return commandeRepository.findById(id).orElseThrow(() -> new CommandeNotFoundException("Commande non trouvée"));
    }

    @Transactional
    public Commande createCommande(Commande commande) {
        // Validation ou autres logiques supplémentaires peuvent être ajoutées ici si nécessaire
        return commandeRepository.save(commande);
    }

    @Transactional
    public Commande updateCommande(Long id, Commande commande) {
        Commande existingCommande = getCommandeById(id);

        // Mise à jour des données
        existingCommande.setClient(commande.getClient());
        existingCommande.setStatut(commande.getStatut());
        existingCommande.setPlats(commande.getPlats());
        existingCommande.setPrixTotal(commande.getPrixTotal());
        existingCommande.setDate(commande.getDate());

        // Sauvegarde des modifications
        return commandeRepository.save(existingCommande);
    }

    public void deleteCommande(Long id) {
        // Vérification avant la suppression
        Commande commande = getCommandeById(id);
        commandeRepository.deleteById(id);
    }
}
