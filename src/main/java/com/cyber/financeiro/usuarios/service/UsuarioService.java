package com.cyber.financeiro.usuarios.service;
import com.cyber.financeiro.usuarios.config.UsuarioLogadoHelper;
import com.cyber.financeiro.usuarios.entity.UsuarioDTO;
import com.cyber.financeiro.usuarios.entity.UsuarioEntity;
import com.cyber.financeiro.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

  @Autowired
  UsuarioRepository usuarioRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  UsuarioLogadoHelper usuarioLogadoHelper;

  public void CreateUser(UsuarioDTO usuarioDto) {

    UsuarioEntity usuario = new UsuarioEntity();
    usuario.setNome(usuarioDto.nome());
    usuario.setLogin(usuarioDto.login());
    usuario.setCelular(usuarioDto.celular());
    usuario.setSenha(passwordEncoder.encode(usuarioDto.senha()));

    usuarioRepository.save(usuario);
  }
}
