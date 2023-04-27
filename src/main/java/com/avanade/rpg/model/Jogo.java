package com.avanade.rpg.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "JOGO")
@Entity
public class Jogo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "ID_JOGADOR1")
    private Long idjogador1;
    @Column(name = "ID_JOGADOR2")
    private Long idjogador2;
    @Column(name = "VOLTAS")
    private Integer voltas;
    @Column(name="IS_FIMJOGO")
    private Boolean isfimjogo;
}