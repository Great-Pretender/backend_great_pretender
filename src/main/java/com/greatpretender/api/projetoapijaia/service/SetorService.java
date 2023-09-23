package com.greatpretender.api.projetoapijaia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatpretender.api.projetoapijaia.entity.Setor;
import com.greatpretender.api.projetoapijaia.entity.Usuario;
import com.greatpretender.api.projetoapijaia.repository.SetorRepository;
import com.greatpretender.api.projetoapijaia.repository.UsuarioRepository;



@Service
public class SetorService implements ISetorService{
    @Autowired
    private SetorRepository setorRepo;

    
    public Setor buscarPorId(Long id) {
        Optional<Setor> setorOp = setorRepo.findById(id);
        if (setorOp.isPresent()) {
            return setorOp.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    public Setor novoSetor(Setor setor) {
        if(setor == null  ||
                setor.getNome() == null) {
            throw new IllegalArgumentException("Nome inválido!");
        }
        return setorRepo.save(setor);
    }

    // Lista todos dos sertores
    public List<Setor> buscarTodosSetores() {
        return (List<Setor>) setorRepo.findAll();
    }


}
