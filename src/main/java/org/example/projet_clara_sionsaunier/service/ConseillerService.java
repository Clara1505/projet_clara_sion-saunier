package org.example.projet_clara_sionsaunier.service;

import org.example.projet_clara_sionsaunier.model.Conseiller;
import org.example.projet_clara_sionsaunier.repository.AgenceRepository;
import org.example.projet_clara_sionsaunier.repository.ConseillerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConseillerService {
    private final ConseillerRepository repo;

    public ConseillerService(ConseillerRepository repo) {
        this.repo = repo;
    }

    public Conseiller create(Conseiller a) {
        return repo.save(a);
    }

    public List<Conseiller> list() {
        return repo.findAll();
    }
    public Conseiller get(Long id) {
        return repo.findById(id).orElse(null);
    }
}
