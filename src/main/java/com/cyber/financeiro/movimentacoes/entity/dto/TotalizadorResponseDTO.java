package com.cyber.financeiro.movimentacoes.entity.dto;

import java.math.BigDecimal;

public record TotalizadorResponseDTO(
        BigDecimal receita,
        BigDecimal despesa,
        BigDecimal total

        ) {}
