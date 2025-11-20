package org.example.projet_clara_sionsaunier.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarteBancaire {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeCarte type;

    private boolean active = true;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}