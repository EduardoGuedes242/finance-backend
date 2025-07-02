package com.cyber.financeiro.movimentacoes.controller;

import com.cyber.financeiro.movimentacoes.entity.dto.MovimentacaoRequestDTO;
import com.cyber.financeiro.movimentacoes.entity.dto.MovimentacaoResponseDTO;
import com.cyber.financeiro.movimentacoes.entity.dto.TotalizadorResponseDTO;
import com.cyber.financeiro.movimentacoes.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {


  @Autowired
  MovimentacaoService movimentacaoService;

  @PostMapping
  private String registerMovimentacao(@RequestBody MovimentacaoRequestDTO movimentacaoRequestDTO) {
   movimentacaoService.registerMovimentacao(movimentacaoRequestDTO);
    return "Movimentacao registrada com sucesso";
  }

  @GetMapping
  private List<MovimentacaoResponseDTO> listaMovimentacao() {
    return movimentacaoService.listarMovimentacoesDoUsuario();
  }

  @GetMapping("/totalizador")
  private TotalizadorResponseDTO totalizadorMovimentacao() {
    return movimentacaoService.totalizadorMovimentacoes();
  }
}
