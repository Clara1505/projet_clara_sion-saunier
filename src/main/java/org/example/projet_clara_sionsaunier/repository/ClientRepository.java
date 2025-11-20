package org.example.projet_clara_sionsaunier.repository;

import org.example.projet_clara_sionsaunier.model.Client;
import org.example.projet_clara_sionsaunier.model.Conseiller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByConseiller(Conseiller conseiller);
    long countByConseiller(Conseiller conseiller);
}
