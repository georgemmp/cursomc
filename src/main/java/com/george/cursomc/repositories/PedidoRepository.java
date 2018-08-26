package com.george.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.george.cursomc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
}
