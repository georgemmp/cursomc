package com.george.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.george.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
