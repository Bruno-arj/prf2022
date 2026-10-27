package com.projeto.prf.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "acidente_causa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "acidente")
public class AcidenteCausa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_causa")
    private Integer idCausa;

    @ManyToOne
    @JoinColumn(name = "id_acidente", nullable = false)
    private Acidente acidente;

    @Column(name = "causa_acidente")
    private String causaAcidente;

    @Column(name = "causa_principal")
    private Boolean causaPrincipal;
}