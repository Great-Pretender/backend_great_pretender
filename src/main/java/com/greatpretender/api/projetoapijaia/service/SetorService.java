package com.greatpretender.api.projetoapijaia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.greatpretender.api.projetoapijaia.entity.Setor;
import com.greatpretender.api.projetoapijaia.repository.SetorRepository;



@Service
public class SetorService implements ISetorService{
    @Autowired
    private SetorRepository setorRepo;

    @PreAuthorize("hasAnyRole('ADMIN')")
    public Setor buscarPorId(Long id) {
        Optional<Setor> setorOp = setorRepo.findById(id);
        if (setorOp.isPresent()) {
            return setorOp.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    public Setor novoSetor(Setor setor) {
        if(setor == null  ||
                setor.getNome() == null) {
            throw new IllegalArgumentException("Nome inválido!");
        }
        return setorRepo.save(setor);
    }

    // Lista todos dos sertores
    @PreAuthorize("hasAnyRole('TECNICO', 'ADMIN')")
    public List<Setor> buscarTodosSetores() {
        return (List<Setor>) setorRepo.findAll();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    public Setor deletarPorId(Long id){
        Optional<Setor> setorOp = setorRepo.findById(id);
        if(setorOp.isPresent()){
            
            setorRepo.deleteById(id);
            return setorOp.get();
        }
        throw new IllegalArgumentException("ID inválido!");
    }



}
