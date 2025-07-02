package com.cyber.financeiro.movimentacoes.entity.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

public record MovimentacaoResponseDTO(
        String usuario,
        String categoria,
        UUID movimentacaoId,
        String tipo,
        String descricao,
        BigDecimal valor,
        Date data,
        Timestamp dataCriacao
) {}