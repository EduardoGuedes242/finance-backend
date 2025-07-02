package com.cyber.financeiro.movimentacoes.repository;

import com.cyber.financeiro.movimentacoes.entity.MovimentacoesEntity;
import com.cyber.financeiro.movimentacoes.entity.dto.MovimentacaoResponseDTO;
import com.cyber.financeiro.movimentacoes.entity.dto.TotalizadorResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MovimentacaoRespository extends JpaRepository<MovimentacoesEntity, UUID> {

  @Query(value = """
        SELECT 
            u.usr_nome AS usuario,
            c.ctg_descricao AS categoria,
            m.mvt_id AS movimentacaoId,
            m.mvt_tipo AS tipo,
            m.mvt_descricao AS descricao,
            m.mvt_valor AS valor,
            m.mvt_data AS data,
            m.mvt_data_criacao AS dataCriacao
        FROM movimentacoes m
        JOIN usuarios u ON u.usr_id = m.usr_id
        JOIN categorias c ON c.ctg_id = m.ctg_id
        WHERE m.usr_id = :usuarioId
        ORDER BY m.mvt_data DESC
    """, nativeQuery = true)
  List<MovimentacaoResponseDTO> findByUsuario(@Param("usuarioId") UUID usuarioId);

  @Query(value = """
        SELECT
                COALESCE(SUM(CASE WHEN mvt_tipo = 'despesa' THEN mvt_valor END), 0) AS despesa,
                COALESCE(SUM(CASE WHEN mvt_tipo = 'receita' THEN mvt_valor END), 0) AS receita,
                COALESCE(SUM(CASE WHEN mvt_tipo = 'receita' THEN mvt_valor END), 0) -
                COALESCE(SUM(CASE WHEN mvt_tipo = 'despesa' THEN mvt_valor END), 0) AS total
              FROM movimentacoes
              WHERE usr_id = :usuarioId;
    """, nativeQuery = true)
  TotalizadorResponseDTO totalizadorSaldo(@Param("usuarioId") UUID usuarioId);

}
