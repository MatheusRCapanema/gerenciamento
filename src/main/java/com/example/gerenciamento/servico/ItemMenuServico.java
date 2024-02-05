package com.example.gerenciamento.servico;


import com.example.gerenciamento.modelo.ItemMenu;
import com.example.gerenciamento.repositorio.ItemMenuRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemMenuServico {

    private final ItemMenuRepositorio itemMenuRepositorio;

    @Autowired
    public ItemMenuServico(ItemMenuRepositorio itemMenuRepositorio) {
        this.itemMenuRepositorio = itemMenuRepositorio;
    }

    public ItemMenu adicionarItemMenu(ItemMenu itemMenu) {
        return itemMenuRepositorio.save(itemMenu);
    }

    public List<ItemMenu> listarTodosItens() {
        return itemMenuRepositorio.findAll();
    }

    public Optional<ItemMenu> encontrarPorId(Long id) {
        return itemMenuRepositorio.findById(id);
    }

    public ItemMenu atualizarItemMenu(ItemMenu itemMenu) {
        return itemMenuRepositorio.save(itemMenu); // O JPA atualiza se o item já existe
    }

    public void removerItemMenu(Long id) {
        itemMenuRepositorio.deleteById(id);
    }
}
