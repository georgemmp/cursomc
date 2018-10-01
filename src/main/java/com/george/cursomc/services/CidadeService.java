package com.george.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.george.cursomc.domain.Cidade;
import com.george.cursomc.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;
	
	public List<Cidade> findByEstado(Integer idEstado){
		return repository.findCidades(idEstado);
	}
}
