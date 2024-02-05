package com.example.gerenciamento.controlador;

import com.example.gerenciamento.modelo.ItemMenu;
import com.example.gerenciamento.servico.ItemMenuServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class ItemMenuControlador {

    private final ItemMenuServico itemMenuServico;

    @Autowired
    public ItemMenuControlador(ItemMenuServico itemMenuServico) {
        this.itemMenuServico = itemMenuServico;
    }

    @PostMapping("/itens")
    public ItemMenu adicionarItem(@RequestBody ItemMenu itemMenu) {
        return itemMenuServico.adicionarItemMenu(itemMenu);
    }

    @GetMapping("/itens")
    public List<ItemMenu> listarTodosItens() {
        return itemMenuServico.listarTodosItens();
    }

    @GetMapping("/itens/{id}")
    public ResponseEntity<ItemMenu> encontrarItemPorId(@PathVariable Long id) {
        return itemMenuServico.encontrarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/itens")
    public ItemMenu atualizarItem(@RequestBody ItemMenu itemMenu) {
        return itemMenuServico.atualizarItemMenu(itemMenu);
    }

    @DeleteMapping("/itens/{id}")
    public ResponseEntity<Void> removerItem(@PathVariable Long id) {
        itemMenuServico.removerItemMenu(id);
        return ResponseEntity.ok().build();
    }
}
