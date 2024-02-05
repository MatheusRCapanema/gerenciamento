package com.example.gerenciamento.servico;


import com.example.gerenciamento.modelo.Pedido;
import com.example.gerenciamento.repositorio.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServico {

    private final PedidoRepositorio pedidoRepositorio;

    @Autowired
    public PedidoServico(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepositorio.save(pedido);
    }

    public Optional<Pedido> encontrarPorId(Long id) {
        return pedidoRepositorio.findById(id);
    }

    public List<Pedido> listarTodosPedidos() {
        return pedidoRepositorio.findAll();
    }

    public void removerPedido(Long id) {
        pedidoRepositorio.deleteById(id);
    }
}
