package com.george.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.george.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
