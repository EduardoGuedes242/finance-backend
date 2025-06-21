package com.cyber.financeiro.usuarios.entity;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "usr_id", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "usr_nome", nullable = false)
  private String nome;

  @Column(name = "usr_login", nullable = false, unique = true)
  private String login;

  @Column(name = "usr_senha", nullable = false)
  private String senha;

  @Column(name = "usr_celular", nullable = false)
  private String celular;

  public UsuarioEntity() {}

  public UsuarioEntity(UUID id, String nome, String login, String senha, String celular) {
    this.id = id;
    this.nome = nome;
    this.login = login;
    this.senha = senha;
    this.celular = celular;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getCelular() {
    return celular;
  }

  public void setCelular(String celular) {
    this.celular = celular;
  }
}
