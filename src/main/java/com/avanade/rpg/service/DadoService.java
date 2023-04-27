package com.avanade.rpg.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.avanade.rpg.model.Personagem;
import com.avanade.rpg.model.Jogo;
import com.google.gson.Gson;

@Service
public class DadoService {

    private Jogo jogo;

    public long init(Jogo jogo) {
        double init1, init2;

        double char1 = jogo.getIdjogador1();
        double char2 = jogo.getIdjogador2();
        double win;

        do {
            init1 = dado(1, 20);
            init2 = dado(1, 20);
        } while (init1 != init2);

        if (init1 > init2) {
            win = char1;
        } else {
            win = char2;
        }

        return (long) win;
    }

    public double ataque(Personagem personagem, Jogo jogo) {

        double ataque = dado(1, 12) + personagem.getForca()
                + personagem.getAgilidade();

        return ataque;
    }

    public double defesa(Personagem personagem, Jogo jogo) {

        double defesa = dado(1, 12) + personagem.getDefesa()
                + personagem.getAgilidade();

        return defesa;
    }

    public double dano(Personagem personagem, Jogo jogo) {

        double dano = dado(personagem.getQtddados(), personagem.getFaces());

    return dano;

    }

    private double dado(double qtd, double faces) {

        // define the range
        double min = 1;
        double range = faces - min + 1;
        double sum = 0;

        for (double i = 0; i < qtd; i++) {
            sum += (double) (Math.random() * range);
        }

        return sum;
    }

}