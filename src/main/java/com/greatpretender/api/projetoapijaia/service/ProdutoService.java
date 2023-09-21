package com.greatpretender.api.projetoapijaia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatpretender.api.projetoapijaia.entity.Produto;
import com.greatpretender.api.projetoapijaia.repository.ProdutoRepository;

@Service
public class ProdutoService implements IProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepo;

    public Produto buscarPorId(Long id) {
        Optional<Produto> produtoOp = produtoRepo.findById(id);
        if (produtoOp.isPresent()) {
            return produtoOp.get();
        }
        throw new IllegalArgumentException("Id inválido!");
    }

    public Produto novoProduto(Produto Produto) {
        if(Produto == null  ||
                Produto.getNome() == null  ||
                Produto.getSetor() == null  ||
                Produto.getMarca() == null  ||
                Produto.getModelo() == null  ||
                Produto.getValidade() == null ) {
            throw new IllegalArgumentException("Nome inválido!");
        }
        return produtoRepo.save(Produto);
    }

    public List<Produto> buscarTodos() {
        return produtoRepo.findAll();
    }
}
