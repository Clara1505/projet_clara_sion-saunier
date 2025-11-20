package org.example.projet_clara_sionsaunier.repository;

import org.example.projet_clara_sionsaunier.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
