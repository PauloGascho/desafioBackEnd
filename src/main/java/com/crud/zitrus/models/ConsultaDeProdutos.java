package com.crud.zitrus.models;

import java.math.BigDecimal;

public interface ConsultaDeProdutos {
    String getCodigo();
    String getDescricao();
    BigDecimal getQtdSaida();
    BigDecimal getQtdDisponivel();
}
