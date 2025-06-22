package com.cyber.financeiro.movimentacoes.service;

import com.cyber.financeiro.movimentacoes.entity.MovimentacoesEntity;
import com.cyber.financeiro.movimentacoes.entity.dto.MovimentacaoRequestDTO;
import com.cyber.financeiro.movimentacoes.repository.MovimentacaoRespository;
import com.cyber.financeiro.usuarios.config.UsuarioLogadoHelper;
import com.cyber.financeiro.usuarios.entity.UsuarioEntity;
import com.cyber.financeiro.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentacaoService {

  @Autowired
  MovimentacaoRespository movimentacaoRespository;

  @Autowired
  private UsuarioLogadoHelper usuarioLogadoHelper;

  @Autowired
  private UsuarioRepository usuarioRepository;
  public void registerMovimentacao(MovimentacaoRequestDTO movimentacaoRequestDTO) {
    MovimentacoesEntity movimentacoes = new MovimentacoesEntity();

    UsuarioEntity usuario = usuarioLogadoHelper.getUsuarioLogado();

    movimentacoes.setUsuario(usuario);
    movimentacoes.setCategoria(movimentacaoRequestDTO.categoria());
    movimentacoes.setTipo(movimentacaoRequestDTO.tipo());
    movimentacoes.setDescricao(movimentacaoRequestDTO.descricao());
    movimentacoes.setValor(movimentacaoRequestDTO.valor());
    movimentacoes.setData(movimentacaoRequestDTO.data());

    movimentacaoRespository.save(movimentacoes);
  }
}
