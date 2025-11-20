package org.example.projet_clara_sionsaunier.controller;

import org.example.projet_clara_sionsaunier.model.Compte;
import org.example.projet_clara_sionsaunier.service.CompteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/compte")
public class CompteController {
    private final CompteService service;

    public CompteController(CompteService service) {
        this.service = service;
    }

    @PostMapping
    public Compte create(@RequestBody Compte a) {
        return service.save(a);
    }

    @GetMapping
    public List<Compte> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compte> get(@PathVariable Long id) {
        Compte a = service.get(id);
        return a == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(a);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
