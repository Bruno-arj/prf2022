package com.projeto.prf.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "veiculo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "acidente")
public class Veiculo {

    @Id
    @Column(name = "id_veiculo")
    private Integer idVeiculo;

    @ManyToOne
    @JoinColumn(name = "id_acidente", nullable = false)
    private Acidente acidente;

    @Column(name = "tipo_veiculo")
    private String tipoVeiculo;

    private String marca;

    @Column(name = "ano_fabricacao")
    private Integer anoFabricacao;
}