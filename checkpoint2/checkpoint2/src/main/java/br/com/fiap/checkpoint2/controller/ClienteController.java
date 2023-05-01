package br.com.fiap.checkpoint2.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.checkpoint2.model.Cliente;
import br.com.fiap.checkpoint2.repository.ClienteRepository;
import br.com.fiap.checkpoint2.service.ClienteService;
import dto.cliente.ClienteRequestCreate;
import dto.cliente.ClienteRequestUpdate;
import dto.cliente.SearchedCliente;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<SearchedCliente> listAll() {
		List<SearchedCliente> result = 
				clienteService.list()
				.stream()
				.map(SearchedCliente::toDto)
				.collect(Collectors.toList());
		return result;
	}
	
	@PostMapping	
	public Cliente create(@RequestBody ClienteRequestCreate dto) {		
		Cliente cliente = new Cliente();
		
		cliente.setNome_cli(dto.getNome_cli());
		cliente.setIns_fed_cli(dto.getIns_fed_cli());
		cliente.setCep_cli(dto.getCep_cli());
		
		Cliente result = clienteService.save(cliente);
		return result;
	}

	@PutMapping
	public Cliente update(@RequestBody ClienteRequestUpdate dto) {
		
		boolean exists =
				clienteRepository.existsById(dto.getCod_cli());
		
		if (!exists) {
			throw new RuntimeException("Código do Cliente não encontrado " + dto.getCod_cli());			
		}
		Cliente cliente = new Cliente();
		cliente.setCod_cli(dto.getCod_cli());
		cliente.setNome_cli(dto.getNome_cli());
		cliente.setIns_fed_cli(dto.getIns_fed_cli());	
		cliente.setCep_cli(dto.getCep_cli());

		Cliente result = clienteService.save(cliente);
		return result;
	}

	@DeleteMapping(value = "{cod_cli}")
	public void delete(@PathVariable Long cod_cli) {
		clienteRepository.deleteById(cod_cli);		
	}

	@GetMapping("/{cod_cli}")
	public Cliente findById(@PathVariable Long cod_cli) {
		return clienteService.findById(cod_cli);
	}
}
