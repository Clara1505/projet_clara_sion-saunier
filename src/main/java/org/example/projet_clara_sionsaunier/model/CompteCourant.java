package org.example.projet_clara_sionsaunier.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class CompteCourant extends Compte {
    private double decouvert = 1000.0;
}
