package com.cyber.financeiro.usuarios.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtTokenProvider {

  private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

  public String gerarToken(UUID usuarioId, String login) {
    return Jwts.builder()
            .setSubject(usuarioId.toString())
            .claim("login", login)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24h
            .signWith(key)
            .compact();
  }

  public UUID getUsuarioIdFromToken(String token) {
    String subject = Jwts.parserBuilder().setSigningKey(key).build()
            .parseClaimsJws(token).getBody().getSubject();
    return UUID.fromString(subject);
  }

  public boolean validarToken(String token) {
    try {
      Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public Key getKey() {
    return key;
  }

}
