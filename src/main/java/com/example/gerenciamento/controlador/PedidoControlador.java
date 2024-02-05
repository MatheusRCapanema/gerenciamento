package com.example.gerenciamento.controlador;

import com.example.gerenciamento.modelo.Pedido;
import com.example.gerenciamento.servico.PedidoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoControlador {

    private final PedidoServico pedidoServico;

    @Autowired
    public PedidoControlador(PedidoServico pedidoServico) {
        this.pedidoServico = pedidoServico;
    }

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        return pedidoServico.criarPedido(pedido);
    }

    @GetMapping
    public List<Pedido> listarTodosPedidos() {
        return pedidoServico.listarTodosPedidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> encontrarPedidoPorId(@PathVariable Long id) {
        return pedidoServico.encontrarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPedido(@PathVariable Long id) {
        pedidoServico.removerPedido(id);
        return ResponseEntity.ok().build();
    }
}
