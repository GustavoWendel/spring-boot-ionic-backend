package com.gustavowendel.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavowendel.cursomc.domain.Categoria;
import com.gustavowendel.cursomc.repositories.CategoriaRepository;
import com.gustavowendel.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {

	private final CategoriaRepository repo;

	@Autowired
	public CategoriaService(CategoriaRepository repo) {
		this.repo = repo;
	}

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

    public Categoria inserir(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
    }
}
