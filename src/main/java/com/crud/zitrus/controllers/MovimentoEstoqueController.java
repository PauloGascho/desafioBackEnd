package com.crud.zitrus.controllers;

import com.crud.zitrus.models.MovimentoEstoque;
import com.crud.zitrus.repositories.MovimentoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class MovimentoEstoqueController implements MovimentoEstoqueResource{

    @Autowired
    MovimentoEstoqueRepository movimentoEstoqueRepository;

    @Override
    public List<MovimentoEstoque> listarMovimentos() { return movimentoEstoqueRepository.findAll(); }

    @Override
    public Optional<MovimentoEstoque> detalharMovimento(UUID movimentoId) {
        return movimentoEstoqueRepository.findById(movimentoId);
    }

    @Override
    public MovimentoEstoque createMovimento(MovimentoEstoque movimentoEstoque) {
        return movimentoEstoqueRepository.save(movimentoEstoque);
    }
}
