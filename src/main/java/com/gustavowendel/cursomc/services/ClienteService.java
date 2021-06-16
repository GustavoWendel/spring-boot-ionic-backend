package com.gustavowendel.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavowendel.cursomc.domain.Cliente;
import com.gustavowendel.cursomc.repositories.ClienteRepository;
import com.gustavowendel.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	private final ClienteRepository repo;

	@Autowired
	public ClienteService(ClienteRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
}
