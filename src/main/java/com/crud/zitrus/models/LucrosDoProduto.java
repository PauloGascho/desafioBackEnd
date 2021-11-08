package com.crud.zitrus.models;

import java.math.BigDecimal;

public interface LucrosDoProduto {
    String getCodigo();
    String getDescricao();
    BigDecimal getQtdSaida();
    BigDecimal getLucro();
}
