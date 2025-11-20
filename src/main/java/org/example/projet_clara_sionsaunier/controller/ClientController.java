package org.example.projet_clara_sionsaunier.controller;

import org.example.projet_clara_sionsaunier.model.Client;
import org.example.projet_clara_sionsaunier.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService service;

    public ClientController(ClientService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Client c) {
        try {
            return ResponseEntity.ok(service.create(c));
        } catch (IllegalStateException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping
    public List<Client> list() { return service.list(); }

    @GetMapping("/{id}")
    public ResponseEntity<Client> get(@PathVariable Long id) {
        Client c = service.get(id);
        return c == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(c);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
