package com.george.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.george.cursomc.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
}
