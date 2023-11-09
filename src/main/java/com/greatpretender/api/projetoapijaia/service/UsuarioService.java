package com.greatpretender.api.projetoapijaia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatpretender.api.projetoapijaia.entity.Setor;
import com.greatpretender.api.projetoapijaia.entity.Usuario;
import com.greatpretender.api.projetoapijaia.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private PasswordEncoder encoder;

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
               // usuario.getCargo() == null ||
                usuario.getNome().isBlank() ||
                usuario.getSenha() == null ||
                usuario.getSenha().isBlank() ||
                usuario.getEmail() == null ||
                usuario.getEmail().isBlank()
                ) {
            
            throw new IllegalArgumentException("Dados inválidos!");
        }
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        return usuarioRepo.save(usuario);
    }

     public List<Usuario> buscarPorIdSetor(Setor idSetor){
        
        try{
        List<Usuario> servicos = usuarioRepo.findUsuarioBySetorId(idSetor.getId());
       
            return servicos;
        } catch (Exception e) {
        
        throw new IllegalArgumentException("Id inválido! "+ e);
            }
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
