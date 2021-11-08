package com.crud.zitrus.repositories;

import com.crud.zitrus.models.ConsultaDeProdutos;
import com.crud.zitrus.models.LucrosDoProduto;
import com.crud.zitrus.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

    Optional<Produto> findByCodigo(String codigo);

    @Query("select p.codigo as codigo, " +
            "p.descricao as descricao, " +
            "sum(me.qtdMovimentada) as qtdSaida, " +
            "sum(p.qtdEstoque - me.qtdMovimentada) as qtdDisponivel " +
            "from MovimentoEstoque me " +
            "join Produto p " +
            "on p.id = me.produto.id " +
            "where p.tipo = ?1 " +
            "and me.tipo = 'saida' " +
            "group by p.codigo, p.descricao")
    List<ConsultaDeProdutos> consultaProduto(String tipo);

    @Query("select p.codigo as codigo, " +
            "p.descricao as descricao, " +
            "sum(me.qtdMovimentada) as qtdSaida, " +
            "sum(p.valorFornecedor * me.qtdMovimentada) as lucro " +
            "from MovimentoEstoque me " +
            "join Produto p " +
            "on p.id = me.produto.id " +
            "where me.tipo = 'saida' " +
            "group by p.codigo, p.descricao "
    )
    List<LucrosDoProduto> listarLucros();

    @Query("select distinct p.tipo from Produto p")
    List<String> getTipos();
}
