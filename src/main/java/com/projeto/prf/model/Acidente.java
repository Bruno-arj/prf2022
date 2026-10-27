package com.projeto.prf.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "acidente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Acidente {

    @Id
    @Column(name = "id_acidente")
    private Integer idAcidente;

    @Column(name = "data_acidente")
    private LocalDate dataAcidente;

    @Column(name = "dia_semana")
    private String diaSemana;

    private LocalTime horario;

    private String uf;

    private Integer br;

    private BigDecimal km;

    private String municipio;

    @Column(name = "classificacao_acidente")
    private String classificacaoAcidente;

    @Column(name = "fase_dia")
    private String faseDia;

    @Column(name = "sentido_via")
    private String sentidoVia;

    @Column(name = "condicao_meteorologica")
    private String condicaoMeteorologica;

    @Column(name = "tipo_pista")
    private String tipoPista;

    @Column(name = "tracado_via")
    private String tracadoVia;

    @Column(name = "uso_solo")
    private String usoSolo;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private String regional;

    private String delegacia;

    private String uop;
}