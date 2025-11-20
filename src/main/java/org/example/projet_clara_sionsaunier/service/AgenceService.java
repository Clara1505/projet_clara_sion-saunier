package org.example.projet_clara_sionsaunier.service;

import org.example.projet_clara_sionsaunier.model.Agence;
import org.example.projet_clara_sionsaunier.repository.AgenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenceService {
    private final AgenceRepository repo;

    public AgenceService(AgenceRepository repo) {
        this.repo = repo;
    }

    public Agence create(Agence agency) {
        return repo.save(agency);
    }

    public List<Agence> list() {
        return repo.findAll();
    }

    public Agence get(String id) {
        return repo.findById(id).orElse(null);
    }
}
