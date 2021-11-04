package com.crud.zitrus.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="produto")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Produto {

    @Id
    @GeneratedValue
    UUID id;

    String codigo;
    String descricao;
    String tipo;
    BigDecimal valorFornecedor;
    BigDecimal qtdEstoque;
}
