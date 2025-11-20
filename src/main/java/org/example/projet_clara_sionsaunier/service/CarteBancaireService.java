package org.example.projet_clara_sionsaunier.service;

import org.example.projet_clara_sionsaunier.model.CarteBancaire;
import org.example.projet_clara_sionsaunier.repository.CarteBancaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteBancaireService {
    private final CarteBancaireRepository repo;

    public CarteBancaireService(CarteBancaireRepository repo) {
        this.repo = repo;
    }

    public CarteBancaire create(CarteBancaire c) {
        return repo.save(c);
    }

    public List<CarteBancaire> list() {
        return repo.findAll();
    }

    public CarteBancaire get(Long id) {
        return repo.findById(id).orElse(null);
    }
}
