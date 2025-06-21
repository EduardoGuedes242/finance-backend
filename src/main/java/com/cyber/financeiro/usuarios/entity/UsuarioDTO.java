package com.cyber.financeiro.usuarios.entity;

public record UsuarioDTO(
        String nome,
        String login,
        String senha,
        String celular) {}
