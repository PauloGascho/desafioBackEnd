package com.crud.zitrus.controllers;

import com.crud.zitrus.models.ConsultaDeProdutos;
import com.crud.zitrus.models.LucrosDoProduto;
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

    @GetMapping("codigo/{codigo}")
    Optional<Produto> getProdutoByCodigo(@PathVariable(value = "codigo") String codigo);

    @GetMapping("tipo/{tipo}")
    List<ConsultaDeProdutos> consultaProduto(@PathVariable(value = "tipo") String codigo);

    @GetMapping("/lucros")
    List<LucrosDoProduto> listarLucros();

    @GetMapping("/tipos")
    List<String> buscarTipos();

    @PostMapping
    Produto createProduto(@RequestBody Produto produto);

    @PutMapping
    Produto updateProduto(@RequestBody Produto produto);

    @DeleteMapping
    void deleteProduto(@RequestBody Produto produto);
}
