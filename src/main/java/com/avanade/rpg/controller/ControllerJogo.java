package com.avanade.rpg.ControllerJogo;

import com.avanade.rpg.model.Jogo;
import com.avanade.rpg.model.Personagem;
import com.avanade.rpg.service.JogoService;
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
public class ControllerJogo {

    @Autowired
    private JogoService service;

    @GetMapping("/jogo")
    @ApiOperation("find a Jogo in RPG list")
    public ResponseEntity<List<Jogo>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/jogo/{id}")
    @ApiOperation("find a Jogo by it's id in the RPG list")
    public ResponseEntity<Jogo> getById(@PathVariable(value = "id") Long jogoID) {
        return new ResponseEntity<>(service.findById(jogoID), HttpStatus.OK);
    }

    @PostMapping("/jogo")
    @ApiOperation("Create a new Jogo in RPG list")
    public ResponseEntity<Jogo> create(@RequestBody Jogo jogo) {
        return new ResponseEntity<>(service.create(jogo), HttpStatus.CREATED);
    }

    @PutMapping("/jogo")
    @ApiOperation("Update a Jogo on RPG list")
    public ResponseEntity<Jogo> update(@RequestBody Jogo jogo) {
        return new ResponseEntity<>(service.update(jogo), HttpStatus.OK);
    }

    @DeleteMapping("/jogo")
    @ApiOperation("Delete a Jogo on RPG list")
    public ResponseEntity<HttpStatus> update(@RequestHeader Long jogoID) {
        service.delete(jogoID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/jogo/random")
    @ApiOperation("Create a random Jogo on RPG list")
    public ResponseEntity<Jogo> createRandom() {
        return new ResponseEntity<>(service.generateRandom(), HttpStatus.CREATED);
    }
}
