package com.greatpretender.api.projetoapijaia.security;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.IOException;
import java.util.Date;

public class JwtUtils {

    private static final String KEY = "com.greatpretender.api.projetoapijaia";

    public static String generateToken(Authentication usuario) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        Login usuarioSemSenha = new Login();
        usuarioSemSenha.setUsername(usuario.getName());
        if(!usuario.getAuthorities().isEmpty()){
            usuarioSemSenha.setAuth(usuario.getAuthorities().iterator().next().getAuthority());
        }
        String usuarioJson = mapper.writeValueAsString(usuarioSemSenha);
        Date agora = new Date();
        Long hora = 1000L * 60L; //Uma Hora
        return Jwts.builder()
                .claim("userDetails", usuarioJson)
                .setIssuer("com.greatpretender.api.projetoapijaia")
                .setSubject(usuario.getName())
                .setExpiration(new Date(agora.getTime() + hora))
                .signWith(Keys.hmacShaKeyFor(KEY.getBytes()), SignatureAlgorithm.HS256).compact();
    }

    public static Authentication perseToken(String token)
        throws IOException, JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        String credentialsJson = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(KEY.getBytes())).build()
                .parseClaimsJws(token).getBody().get("UserDetails", String.class);
        Login usuario = mapper.readValue(credentialsJson, Login.class);
        UserDetails userDetails = User.builder().username(usuario.getUsername()).password("secret")
                .authorities(usuario.getAuth()).build();
        return new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword(), userDetails.getAuthorities());
    }
}
