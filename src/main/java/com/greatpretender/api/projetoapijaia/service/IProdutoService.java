package com.greatpretender.api.projetoapijaia.service;

import java.util.List;

import com.greatpretender.api.projetoapijaia.entity.Produto;

public interface IProdutoService {
    public Produto buscarPorId(Long id);
    public Produto novoProduto(Produto produto);
    public List<Produto> buscarTodosProdutos();
    public Produto deletarPorId(Long id);
}
