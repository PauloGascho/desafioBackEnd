package com.crud.zitrus.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

@Getter
@Setter
@Entity
@Table(name="movimento_estoque")
public class MovimentoEstoque {
    @Id
    @GeneratedValue
    UUID id;

    @ManyToOne
    @JoinColumn(
            name = "produto_id",
            foreignKey = @ForeignKey(name = "movimentacao_estoque_produto")
    )
    Produto produto;

    String tipo;

    BigDecimal valor;

    @DateTimeFormat(iso = DATE_TIME)
    ZonedDateTime dataDaVenda;

    BigDecimal qtdMovimentada;
}
