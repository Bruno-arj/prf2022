package com.projeto.prf.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"acidente", "veiculo"})
public class Pessoa {

    @Id
    private Integer pesid;

    @ManyToOne
    @JoinColumn(name = "id_acidente", nullable = false)
    private Acidente acidente;

    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;

    @Column(name = "tipo_envolvido")
    private String tipoEnvolvido;

    @Column(name = "estado_fisico")
    private String estadoFisico;

    private Integer idade;

    private String sexo;

    private Integer ilesos;

    @Column(name = "feridos_leves")
    private Integer feridosLeves;

    @Column(name = "feridos_graves")
    private Integer feridosGraves;

    private Integer mortos;
}