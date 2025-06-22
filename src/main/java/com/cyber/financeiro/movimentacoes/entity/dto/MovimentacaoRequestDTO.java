package com.cyber.financeiro.movimentacoes.entity.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record MovimentacaoRequestDTO(
        UUID categoria,
        String tipo, // "receita" ou "despesa"
        String descricao,
        BigDecimal valor,
        LocalDate data
) {}