package com.avanade.rpg.controller;

import com.avanade.rpg.model.Personagem;
import com.avanade.rpg.service.PersonagemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rpg")
@Api(value = "RPGs API REST")
@CrossOrigin(origins = "*")
public class Controller {

    @Autowired
    private PersonagemService service;

    @GetMapping("/rpg")
    @ApiOperation("find a Personagem in RPG list")
    public ResponseEntity<List<Personagem>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/rpg/{id}")
    @ApiOperation("find a Personagem by it's id in the RPG list")
    public ResponseEntity<Personagem> getById(@PathVariable(value = "id") Long personagemID) {
        return new ResponseEntity<>(service.findById(personagemID), HttpStatus.OK);
    }

    @PostMapping("/rpg")
    @ApiOperation("Create a new Personagem in RPG list")
    public ResponseEntity<Personagem> create(@RequestBody Personagem personagem) {
        return new ResponseEntity<>(service.create(personagem), HttpStatus.CREATED);
    }

    @PutMapping("/rpg")
    @ApiOperation("Update a Personagem on RPG list")
    public ResponseEntity<Personagem> update(@RequestBody Personagem personagem) {
        return new ResponseEntity<>(service.update(personagem), HttpStatus.OK);
    }

    @DeleteMapping("/rpg")
    @ApiOperation("Delete a Personagem on RPG list")
    public ResponseEntity<HttpStatus> update(@RequestHeader Long personagemID) {
        service.delete(personagemID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/rpg/random")
    @ApiOperation("Create a random Personagem on RPG list")
    public ResponseEntity<Personagem> createRandom() {
        return new ResponseEntity<>(service.generateRandom(), HttpStatus.CREATED);
    }
}