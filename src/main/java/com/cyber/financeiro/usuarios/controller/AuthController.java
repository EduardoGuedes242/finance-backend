package com.cyber.financeiro.usuarios.controller;

import com.cyber.financeiro.usuarios.config.JwtTokenProvider;
import com.cyber.financeiro.usuarios.entity.LoginRequestDTO;
import com.cyber.financeiro.usuarios.entity.UsuarioEntity;
import com.cyber.financeiro.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
  @Autowired
  UsuarioRepository usuarioRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  JwtTokenProvider tokenProvider;

  @PostMapping()
  public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginDTO) {
    UsuarioEntity usuario = usuarioRepository.findByLogin(loginDTO.login())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário ou senha inválidos"));

    if (!passwordEncoder.matches(loginDTO.senha(), usuario.getSenha())) {
      throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário ou senha inválidos");
    }

    String token = tokenProvider.gerarToken(usuario.getId(), usuario.getLogin());

    return ResponseEntity.ok(Map.of(
            "token", token,
            "nome", usuario.getNome(),
            "id", usuario.getId()
    ));
  }
}
