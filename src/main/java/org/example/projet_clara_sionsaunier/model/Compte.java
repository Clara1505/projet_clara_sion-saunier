package org.example.projet_clara_sionsaunier.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "acct_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Compte {
    @Id
    private String numero;

    private double solde;
    private LocalDate dateOuverture;
}
