package com.avanade.rpg.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSONAGEM")
@Entity

public class Personagem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "TIPO", nullable = false)
    private String tipo;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "VIDA", nullable = false)
    private double vida;
    @Column(name = "FORCA", nullable = false)
    private double forca;
    @Column(name = "DEFESA")
    private double defesa;
    @Column(name = "AGILIDADE")
    private double agilidade;
    @Column(name = "QTDDADOS")
    private double qtddados;
    @Column(name = "FACES")
    private double faces;


}
