package com.avanade.rpg.service;

import com.avanade.rpg.exception.InvalidInputException;
import com.avanade.rpg.exception.ResourceNotFoundException;
import com.avanade.rpg.model.Personagem;
import com.avanade.rpg.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository repository;

    @Autowired
    private BoredApiService boredApiService;

    public Personagem create(Personagem personagem) {
       return this.repository.save(personagem);
    }

    public List<Personagem> findAll() {
        return repository.findAll();
    }

    public Personagem findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Personagem not found with ID: " + id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Personagem update(Personagem personagem) {
        if (personagem.getId() == null) {
            throw new InvalidInputException("There is no ID");
        }
        return repository.save(personagem);
    }

    public Personagem generateRandom() {
        Personagem personagem = new Personagem();
        return create(personagem);
    }
}