package com.cyber.financeiro.movimentacoes.entity.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record MovimentacaoResponseDTO(
        UUID id,
        String tipo,
        String descricao,
        BigDecimal valor,
        LocalDate data,
        LocalDateTime dataCriacao,
        UUID categoriaId,
        String categoriaDescricao
) {}