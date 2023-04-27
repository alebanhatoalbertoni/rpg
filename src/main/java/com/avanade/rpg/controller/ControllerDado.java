package com.avanade.rpg.controller;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

        import com.avanade.rpg.model.Personagem;
        import com.avanade.rpg.model.Jogo;
        import com.avanade.rpg.service.DadoService;

        import io.swagger.annotations.Api;
        import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/rpg")
@Api(value = "RPG API REST")
@CrossOrigin(origins = "*")
public class ControllerDado {

    @Autowired

    private DadoService service;
    private Personagem personagem;
    private Jogo jogo;

    @PostMapping("/ataque")
    @ApiOperation("getting dice's value for attack")
    public ResponseEntity<Double> ataque(@RequestBody Personagem personagem, Jogo jogo) {
        return new ResponseEntity<>(service.ataque(personagem, jogo), HttpStatus.OK);
    }

    @PostMapping("/defesa")
    @ApiOperation("getting dice's value for defense")
    public ResponseEntity<Double> defesa(@RequestBody Personagem personagem, Jogo jogo) {
        return new ResponseEntity<>(service.defesa(personagem, jogo), HttpStatus.OK);
    }

    @PostMapping("/dano")
    @ApiOperation("getting dice's value for damage")
    public ResponseEntity<Double> dano(@RequestBody Personagem personagem, Jogo jogo) {
        return new ResponseEntity<>(service.dano(personagem, jogo), HttpStatus.OK);
    }
}
