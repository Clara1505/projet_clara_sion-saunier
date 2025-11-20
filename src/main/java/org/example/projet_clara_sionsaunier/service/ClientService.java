package org.example.projet_clara_sionsaunier.service;

import org.example.projet_clara_sionsaunier.model.CarteBancaire;
import org.example.projet_clara_sionsaunier.model.Client;
import org.example.projet_clara_sionsaunier.repository.CarteBancaireRepository;
import org.example.projet_clara_sionsaunier.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> getById(Long id) {
        return clientRepository.findById(id);
    }

    public Client update(Long id, Client newClientData) {
        return clientRepository.findById(id).map(client -> {
            client.setNom(newClientData.getNom());
            client.setPrenom(newClientData.getPrenom());
            client.setAdresse(newClientData.getAdresse());
            client.setCodePostal(newClientData.getCodePostal());
            client.setVille(newClientData.getVille());
            client.setTelephone(newClientData.getTelephone());
            return clientRepository.save(client);
        }).orElse(null);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
