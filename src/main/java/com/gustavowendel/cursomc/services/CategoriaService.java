package com.gustavowendel.cursomc.services;

import java.util.Optional;

import com.gustavowendel.cursomc.services.exceptions.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

    public Categoria inserir(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
    }

    public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
    }

	public void delete(Integer id) {
		find(id);
		try{
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e){
  			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
}
