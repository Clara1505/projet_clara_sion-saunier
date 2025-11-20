package org.example.projet_clara_sionsaunier.controller;

import org.example.projet_clara_sionsaunier.model.CarteBancaire;
import org.example.projet_clara_sionsaunier.service.CarteBancaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carteBancaire")
public class CarteBancaireController {
    private final CarteBancaireService service;

    public CarteBancaireController(CarteBancaireService service) {
        this.service = service;
    }

    @PostMapping
    public CarteBancaire create(@RequestBody CarteBancaire c) {
        return service.create(c);
    }

    @GetMapping
    public List<CarteBancaire> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarteBancaire> get(@PathVariable Long id) {
        CarteBancaire c = service.get(id);
        return c == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(c);
    }
}
