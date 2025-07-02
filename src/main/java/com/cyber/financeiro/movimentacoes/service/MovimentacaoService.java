package com.cyber.financeiro.movimentacoes.service;

import com.cyber.financeiro.movimentacoes.entity.MovimentacoesEntity;
import com.cyber.financeiro.movimentacoes.entity.dto.MovimentacaoRequestDTO;
import com.cyber.financeiro.movimentacoes.entity.dto.MovimentacaoResponseDTO;
import com.cyber.financeiro.movimentacoes.entity.dto.TotalizadorResponseDTO;
import com.cyber.financeiro.movimentacoes.repository.MovimentacaoRespository;
import com.cyber.financeiro.usuarios.config.UsuarioLogadoHelper;
import com.cyber.financeiro.usuarios.entity.UsuarioEntity;
import com.cyber.financeiro.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

  public List<MovimentacaoResponseDTO> listarMovimentacoesDoUsuario() {
    UUID usuarioId = usuarioLogadoHelper.getIdUsuarioLogado();
    return movimentacaoRespository.findByUsuario(usuarioId);
  }

  public TotalizadorResponseDTO totalizadorMovimentacoes() {
    UUID usuarioId = usuarioLogadoHelper.getIdUsuarioLogado();
    return movimentacaoRespository.totalizadorSaldo(usuarioId);
  }
}
