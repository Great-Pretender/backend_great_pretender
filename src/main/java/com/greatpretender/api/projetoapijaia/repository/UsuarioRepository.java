package com.greatpretender.api.projetoapijaia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatpretender.api.projetoapijaia.entity.Servico;
import com.greatpretender.api.projetoapijaia.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    UserDetails findByCargo(String nome);
    Optional<Usuario> findByNome(String nome);

    List<Usuario> findUsuarioBySetorId(Long idUsuario);
    
}
