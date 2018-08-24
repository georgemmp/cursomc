package com.george.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.george.cursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
