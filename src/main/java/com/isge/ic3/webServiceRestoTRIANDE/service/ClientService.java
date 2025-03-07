package com.isge.ic3.webServiceRestoTRIANDE.service;

import com.isge.ic3.webServiceRestoTRIANDE.model.Client;
import com.isge.ic3.webServiceRestoTRIANDE.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.Valid;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Retourne la liste de tous les clients
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Retourne un client par son ID
    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException("Client non trouvé avec l'ID " + id));
    }

    // Crée un client et valide les données
    @Transactional
    public Client createClient(@Valid Client client) {
        // Ici, la validation des données sera gérée par @Valid dans le contrôleur
        return clientRepository.save(client);
    }

    // Met à jour un client existant
    public Client updateClient(Long id, @Valid Client client) {
        Client existingClient = getClientById(id);
        existingClient.setNom(client.getNom());
        existingClient.setEmail(client.getEmail());
        existingClient.setAdresse(client.getAdresse());
        return clientRepository.save(existingClient);
    }

    // Supprime un client
    public void deleteClient(Long id) {
        Client existingClient = getClientById(id); // Vérifie si le client existe
        clientRepository.deleteById(id);
    }
}
