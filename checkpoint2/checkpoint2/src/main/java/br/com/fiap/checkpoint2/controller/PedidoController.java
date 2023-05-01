package br.com.fiap.checkpoint2.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.repository.PedidoRepository;
import br.com.fiap.checkpoint2.service.PedidoService;
import dto.pedido.PedidoRequestCreate;
import dto.pedido.PedidoRequestUpdate;
import dto.pedido.SearchedPedido;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public List<SearchedPedido> listAll() {
		List<SearchedPedido> result = 
				pedidoService.list()
				.stream()
				.map(SearchedPedido::toDto)
				.collect(Collectors.toList());
		return result;
	}
	
	@PostMapping	
	public Pedido create(@RequestBody PedidoRequestCreate dto) {		
		Pedido pedido = new Pedido();
		
		pedido.setData_ped(dto.getData_ped());
		
		Pedido result = pedidoService.save(pedido);
		return result;
	}

	@PutMapping
	public Pedido update(@RequestBody PedidoRequestUpdate dto) {
		
		boolean exists =
				pedidoRepository.existsById(dto.getNum_ped());
		
		if (!exists) {
			throw new RuntimeException("Número do pedido não encontrado " + dto.getNum_ped());			
		}
		Pedido pedido = new Pedido();
		pedido.setNum_ped(dto.getNum_ped());
		pedido.setData_ped(dto.getData_ped());
		
		Pedido result = pedidoService.save(pedido);
		return result;
	}

	@DeleteMapping(value = "{num_ped}")
	public void delete(@PathVariable Long num_ped) {
		pedidoRepository.deleteById(num_ped);		
	}

	@GetMapping("/{num_ped}")
	public Pedido findById(@PathVariable Long num_ped) {
		return pedidoService.findById(num_ped);
	}
}
