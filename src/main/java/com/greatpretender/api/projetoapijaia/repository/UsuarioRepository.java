package com.greatpretender.api.projetoapijaia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatpretender.api.projetoapijaia.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Optional<Usuario> findByNome(String nome);
    
}
