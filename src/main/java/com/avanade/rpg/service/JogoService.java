package com.avanade.rpg.service;

import com.avanade.rpg.exception.InvalidInputException;
import com.avanade.rpg.exception.ResourceNotFoundException;
import com.avanade.rpg.model.Jogo;
import com.avanade.rpg.model.Personagem;
import com.avanade.rpg.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    @Autowired
    private JogoRepository repository;

    @Autowired
    private BoredApiService boredApiService;

    public Jogo create(Jogo jogo) {
        return this.repository.save(jogo);
    }
    public List<Jogo> findAll() {
        return repository.findAll();
    }

    public Jogo findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Jogo not found with ID: " + id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Jogo update(Jogo jogo) {
        if (jogo.getId() == null) {
            throw new InvalidInputException("There is no ID");
        }
        return repository.save(jogo);
    }

    public Jogo generateRandom() {
        Jogo jogo = new Jogo();
        return create(jogo);
    }
}

