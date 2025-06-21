package com.cyber.financeiro.usuarios.repository;


import com.cyber.financeiro.usuarios.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {

  public Optional<UsuarioEntity> findByLogin(String login);
}
