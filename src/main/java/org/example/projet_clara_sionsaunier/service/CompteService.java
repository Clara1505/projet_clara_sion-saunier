package org.example.projet_clara_sionsaunier.service;

import org.example.projet_clara_sionsaunier.model.Compte;
import org.example.projet_clara_sionsaunier.repository.CompteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService {
    private final CompteRepository repo;

    public CompteService(CompteRepository repo) {
        this.repo = repo;
    }

    public Compte save(Compte a) {
        return repo.save(a);
    }

    public List<Compte> list() {
        return repo.findAll();
    }

    public Compte get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
