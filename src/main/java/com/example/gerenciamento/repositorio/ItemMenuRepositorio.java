package com.example.gerenciamento.repositorio;


import com.example.gerenciamento.modelo.ItemMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMenuRepositorio extends JpaRepository<ItemMenu, Long> {
}
