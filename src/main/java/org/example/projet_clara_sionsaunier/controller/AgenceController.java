package org.example.projet_clara_sionsaunier.controller;

import org.example.projet_clara_sionsaunier.model.Agence;
import org.example.projet_clara_sionsaunier.service.AgenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/agence")
public class AgenceController {
    private final AgenceService service;

    public AgenceController(AgenceService service) {
        this.service = service;
    }

    @PostMapping
    public Agence create(@RequestBody Agence a) {
        return service.create(a);
    }

    @GetMapping
    public List<Agence> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agence> get(@PathVariable String id) {
        Agence a = service.get(id);
        return a == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(a);
    }
}
