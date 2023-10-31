package com.greatpretender.api.projetoapijaia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatpretender.api.projetoapijaia.entity.Usuario;
import com.greatpretender.api.projetoapijaia.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepo;

    //Metodo para o login do usuario
    @Autowired
    private PasswordEncoder encoder;
    public Usuario novoUsuario(Usuario usuario) {
        if(usuario == null ||
                usuario.getAutorizacoes().isEmpty() ||
                usuario.getNome() == null ||
                usuario.getNome().isBlank() ||
                usuario.getSenha() == null ||
                usuario.getSenha().isBlank()) {
            throw new RuntimeException("Dados invalidos para usuario!");
        }
        List<Autorizacao> autorizacoes = new ArrayList<Autorizacao>();
        for(Autorizacao aut: usuario.getAutorizacoes()) {
            Autorizacao nova;
            if(aut.getId() == null) {
                nova = novaAutorizacao(aut);
            }
            else {
                Optional<Autorizacao> autOp = autorizacaoRepo.findById(aut.getId());
                if(autOp.isEmpty()) {
                    throw new RuntimeException("Autorizacao com id " +
                            aut.getId() + " nao encontrada!");
                }
                nova = autOp.get();
            }
            autorizacoes.add(nova);
        }
        usuario.setAutorizacoes(autorizacoes);
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return usuarioRepo.save(usuario);
    }


    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuarioOp = usuarioRepo.findById(id);
        if (usuarioOp.isPresent()) {
            return usuarioOp.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    @Transactional
    public Usuario novoUsuario(Usuario usuario) {
        
        if(usuario == null ||
                usuario.getCpf() == null ||
                usuario.getCpf().isBlank() ||
                usuario.getNome() == null ||
                usuario.getSetor() == null ||
                usuario.getCargo() == null ||
                usuario.getNome().isBlank() ||
                usuario.getSenha() == null ||
                usuario.getSenha().isBlank() ||
                usuario.getEmail() == null ||
                usuario.getEmail().isBlank()
                ) {
            
            throw new IllegalArgumentException("Dados inválidos!");
        }
        return usuarioRepo.save(usuario);
    }

    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepo.findAll();
    }

    public Usuario deletarPorId(Long id){
        Optional<Usuario> usuarioOp = usuarioRepo.findById(id);
        if(usuarioOp.isPresent()){
            
            usuarioRepo.deleteById(id);
            return usuarioOp.get();
        }
        throw new IllegalArgumentException("ID inválido!");
    }
}
