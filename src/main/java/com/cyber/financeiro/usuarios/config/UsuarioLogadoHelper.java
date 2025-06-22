package com.cyber.financeiro.usuarios.config;

import com.cyber.financeiro.usuarios.entity.UsuarioEntity;
import com.cyber.financeiro.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.UUID;

public class UsuarioLogadoHelper {

  @Autowired
  UsuarioRepository usuarioRepository;


  public UsuarioEntity getUsuarioLogado() {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (principal instanceof UUID usuarioId) {
      return usuarioRepository.findById(usuarioId)
              .orElseThrow(() -> new RuntimeException("Usuário autenticado não encontrado"));
    }

    throw new RuntimeException("Principal inválido no contexto de segurança");
  }

  public UUID getIdUsuarioLogado() {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    if (principal instanceof UUID usuarioId) {
      return usuarioId;
    }

    throw new RuntimeException("Principal inválido no contexto de segurança");
  }

}
