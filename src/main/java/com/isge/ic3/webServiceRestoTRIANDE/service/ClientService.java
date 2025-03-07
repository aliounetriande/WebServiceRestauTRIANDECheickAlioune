package com.isge.ic3.webServiceRestoTRIANDE.service;

import com.isge.ic3.webServiceRestoTRIANDE.model.Client;
import com.isge.ic3.webServiceRestoTRIANDE.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvé"));
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client client) {
        Client existingClient = getClientById(id);
        existingClient.setNom(client.getNom());
        existingClient.setEmail(client.getEmail());
        existingClient.setAdresse(client.getAdresse());
        return clientRepository.save(existingClient);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
