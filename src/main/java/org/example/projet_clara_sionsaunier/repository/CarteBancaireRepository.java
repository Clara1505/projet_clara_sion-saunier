package org.example.projet_clara_sionsaunier.repository;

import org.example.projet_clara_sionsaunier.model.CarteBancaire;
import org.example.projet_clara_sionsaunier.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarteBancaireRepository extends JpaRepository<CarteBancaire, Long> {
    List<CarteBancaire> findByClient(Client client);
}
