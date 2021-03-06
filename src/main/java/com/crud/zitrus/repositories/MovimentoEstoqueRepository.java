package com.crud.zitrus.repositories;

import com.crud.zitrus.models.MovimentoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovimentoEstoqueRepository extends JpaRepository<MovimentoEstoque, UUID> {
}