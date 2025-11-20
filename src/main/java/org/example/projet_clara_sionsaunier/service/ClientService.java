package org.example.projet_clara_sionsaunier.service;

import org.example.projet_clara_sionsaunier.model.CarteBancaire;
import org.example.projet_clara_sionsaunier.model.Client;
import org.example.projet_clara_sionsaunier.repository.CarteBancaireRepository;
import org.example.projet_clara_sionsaunier.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepo;
    private final CarteBancaireRepository cardRepo;

    public ClientService(ClientRepository clientRepo, CarteBancaireRepository cardRepo) {
        this.clientRepo = clientRepo;
        this.cardRepo = cardRepo;
    }

    public Client create(Client client) {
        if (client.getConseiller() != null) {
            long count = clientRepo.countByConseiller(client.getConseiller());
            if (count >= 10) {
                throw new IllegalStateException("Ce conseiller a déjà 10 clients maximum.");
            }
        }
        return clientRepo.save(client);
    }

    public List<Client> list() {
        return clientRepo.findAll();
    }

    public Client get(Long id) {
        return clientRepo.findById(id).orElse(null);
    }

    @Transactional
    public void deleteClient(Long clientId) {
        Client c = clientRepo.findById(clientId).orElse(null);
        if (c == null) return;

        List<CarteBancaire> cards = cardRepo.findByClient(c);
        for (CarteBancaire card : cards) {
            card.setActive(false);
            card.setClient(null);
            cardRepo.save(card);
        }

        clientRepo.delete(c); // cascade removes accounts (one-to-one with orphanRemoval)
    }
}
