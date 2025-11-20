package org.example.projet_clara_sionsaunier.controller;

import org.example.projet_clara_sionsaunier.model.Conseiller;
import org.example.projet_clara_sionsaunier.service.ConseillerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conseiller")
public class ConseillerController {
    private final ConseillerService service;

    public ConseillerController(ConseillerService service) {
        this.service = service;
    }

    @PostMapping
    public Conseiller create(@RequestBody Conseiller a) {
        return service.create(a);
    }

    @GetMapping
    public List<Conseiller> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conseiller> get(@PathVariable Long id) {
        Conseiller a = service.get(id);
        return a == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(a);
    }
}
