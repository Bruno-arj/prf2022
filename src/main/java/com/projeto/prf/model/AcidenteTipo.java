package com.projeto.prf.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "acidente_tipo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "acidente")
public class AcidenteTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo")
    private Integer idTipo;

    @ManyToOne
    @JoinColumn(name = "id_acidente", nullable = false)
    private Acidente acidente;

    @Column(name = "tipo_acidente")
    private String tipoAcidente;

    @Column(name = "ordem_tipo_acidente")
    private Integer ordemTipoAcidente;
}