package com.greatpretender.api.projetoapijaia.service;

import java.util.List;

import com.greatpretender.api.projetoapijaia.entity.Item;

import com.greatpretender.api.projetoapijaia.entity.Setor;

public interface IItemService {
    public Item buscarPorId(Long id);
    public Item novoItem(Item item);
    public List<Item> buscarTodosItems();
    public Item deletarPorId(Long id);
    public List<Item> buscarPorIdSetor(Setor nomeSetor);
}
