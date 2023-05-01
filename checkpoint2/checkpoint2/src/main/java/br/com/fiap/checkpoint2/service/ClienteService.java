package br.com.fiap.checkpoint2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.model.Cliente;
import br.com.fiap.checkpoint2.repository.ClienteRepository;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> list() {
		return clienteRepository.findAll();
	}
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente findById(Long cod_cli) {
	    Optional<Cliente> cliente = clienteRepository.findById(cod_cli);
	    return cliente.orElse(null);
	}
}
