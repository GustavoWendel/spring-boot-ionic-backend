package com.gustavowendel.cursomc.services;

import com.gustavowendel.cursomc.domain.Pedido;
import com.gustavowendel.cursomc.repositories.PedidoRepository;
import com.gustavowendel.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

	private final PedidoRepository repo;

	@Autowired
	public PedidoService(PedidoRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
}
