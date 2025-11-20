package org.example.projet_clara_sionsaunier.model;

import jakarta.persistence.Entity;

@Entity
public class CompteEpargne extends Compte {
    private double taux = 3.00;
}
