package com.cyber.financeiro.usuarios.controller;

import com.cyber.financeiro.usuarios.entity.UsuarioDTO;
import com.cyber.financeiro.usuarios.entity.UsuarioEntity;
import com.cyber.financeiro.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

  @Autowired
  UsuarioService usuarioService;

  @PostMapping
  String createUser(@RequestBody UsuarioDTO usuarioDTO) {
    return "Usuario criado com sucesso";
  };

}
