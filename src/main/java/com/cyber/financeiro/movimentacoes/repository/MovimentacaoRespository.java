package com.cyber.financeiro.movimentacoes.repository;

import com.cyber.financeiro.movimentacoes.entity.MovimentacoesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovimentacaoRespository extends JpaRepository<MovimentacoesEntity, UUID> {

}
