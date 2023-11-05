package com.greatpretender.api.projetoapijaia.service;

import com.greatpretender.api.projetoapijaia.entity.Usuario;
import com.greatpretender.api.projetoapijaia.repository.UsuarioRepository;
import com.greatpretender.api.projetoapijaia.utils.RoleUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SegurancaService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    RoleUtils resUtils;

    @Override
    public UserDetails loadUserByUsername (String username)
        throws UsernameNotFoundException {
        Optional<Usuario> usuarioOp = usuarioRepo.findByNome(username);

        if(usuarioOp.isEmpty()){
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        Usuario usuario = usuarioOp.get();
        return User.builder().username(usuario.getNome()).password(usuario.getSenha())
                .authorities(resUtils.ListCargo(usuario.getCargo()))
                            .build();
    }
}
