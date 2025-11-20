package org.example.projet_clara_sionsaunier.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agence {
    @Id
    @Column(length = 5)
    private Long id;

    private LocalDate dateCration;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gerant_id")
    private Gerant gerant;

    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    private List<Conseiller> conseiller = new ArrayList<>();
}
