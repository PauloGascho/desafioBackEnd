package com.crud.zitrus.controllers;

import com.crud.zitrus.models.MovimentoEstoque;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/movimento-estoque")
@CrossOrigin(origins = "http://localhost:8080")
public interface MovimentoEstoqueResource {
    @GetMapping
    List<MovimentoEstoque> listarMovimentos();

    @GetMapping("/{id}")
    Optional<MovimentoEstoque> detalharMovimento(@PathVariable(value = "id") UUID movimentoId);

    @PostMapping
    MovimentoEstoque createMovimento(@RequestBody MovimentoEstoque movimentoEstoque);
}
