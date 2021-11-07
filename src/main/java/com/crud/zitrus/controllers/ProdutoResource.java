package com.crud.zitrus.controllers;

import com.crud.zitrus.models.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "http://localhost:8080")
public interface ProdutoResource {
    @GetMapping
    List<Produto> listarProdutos();

    @GetMapping("/{id}")
    Optional<Produto> detalharProduto(@PathVariable(value = "id") UUID produtoId);

    @PostMapping
    Produto createProduto(@RequestBody Produto produto);

    @PutMapping
    Produto updateProduto(@RequestBody Produto produto);

    @DeleteMapping
    void deleteProduto(@RequestBody Produto produto);
}
