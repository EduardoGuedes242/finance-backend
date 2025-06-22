package com.cyber.financeiro.movimentacoes.controller;

import com.cyber.financeiro.movimentacoes.entity.dto.MovimentacaoRequestDTO;
import com.cyber.financeiro.movimentacoes.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {


  @Autowired
  MovimentacaoService movimentacaoService;

  @PostMapping
  String registerMovimentacao(@RequestBody MovimentacaoRequestDTO movimentacaoRequestDTO) {
   movimentacaoService.registerMovimentacao(movimentacaoRequestDTO);
    return "Movimentacao registrada com sucesso";
  }
}
