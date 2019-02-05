package com.danielbispo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielbispo.cursomc.domain.Categoria;
import com.danielbispo.cursomc.repositories.CategoriaRepository;
import com.danielbispo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {

		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		
		// O obj deve sempre ter o seu Id nulo para poder ser inserido
		obj.setId(null);
		return repo.save(obj);
	}
}
