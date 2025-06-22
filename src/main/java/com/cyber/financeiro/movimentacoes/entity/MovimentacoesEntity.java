package com.cyber.financeiro.movimentacoes.entity;

import com.cyber.financeiro.usuarios.entity.UsuarioEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "movimentacoes")
public class MovimentacoesEntity {
  @Id
  @GeneratedValue
  @Column(name = "mvt_id")
  private UUID id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "usr_id")
  private UsuarioEntity usuario;

  @Column(name = "ctg_id")
  private UUID categoria;

  @Column(name = "mvt_tipo", nullable = false)
  private String tipo; // "receita" ou "despesa"

  @Column(name = "mvt_descricao", nullable = false)
  private String descricao;

  @Column(name = "mvt_valor", nullable = false)
  private BigDecimal valor;

  @Column(name = "mvt_data", nullable = false)
  private LocalDate data;

  @Column(name = "mvt_data_criacao", nullable = false)
  private LocalDateTime dataCriacao = LocalDateTime.now();

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UsuarioEntity getUsuario() {
    return usuario;
  }

  public void setUsuario(UsuarioEntity usuario) {
    this.usuario = usuario;
  }

  public UUID getCategoria() {
    return categoria;
  }

  public void setCategoria(UUID categoria) {
    this.categoria = categoria;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public LocalDateTime getDataCriacao() {
    return dataCriacao;
  }

  public void setDataCriacao(LocalDateTime dataCriacao) {
    this.dataCriacao = dataCriacao;
  }
}
