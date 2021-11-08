package com.crud.zitrus.controllers;


import com.crud.zitrus.models.ConsultaDeProdutos;
import com.crud.zitrus.models.LucrosDoProduto;
import com.crud.zitrus.models.Produto;
import com.crud.zitrus.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class ProdutoController implements ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> detalharProduto(UUID produtoId) {
        return produtoRepository.findById(produtoId);
    }

    public Optional<Produto> getProdutoByCodigo(String codigo) {
        return produtoRepository.findByCodigo(codigo);
    }

    public List<ConsultaDeProdutos> consultaProduto(String tipo) {
        return produtoRepository.consultaProduto(tipo);
    }

    public List<LucrosDoProduto> listarLucros() {
        return produtoRepository.listarLucros();
    };

    public List<String> buscarTipos() {
        return produtoRepository.getTipos();
    }

    @Override
    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produto updateProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void deleteProduto(Produto produto) {
        produtoRepository.delete(produto);
    }
}
