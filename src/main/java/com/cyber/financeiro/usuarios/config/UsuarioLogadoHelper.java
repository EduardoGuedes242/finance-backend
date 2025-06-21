package com.cyber.financeiro.usuarios.config;

import org.springframework.security.core.context.SecurityContextHolder;

import java.util.UUID;

public class UsuarioLogadoHelper {
  public static UUID getIdUsuarioLogado() {
    return (UUID) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }
}
