package com.example.gerenciamento.repositorio;


import com.example.gerenciamento.modelo.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepositorio extends JpaRepository<ItemPedido, Long> {
}
