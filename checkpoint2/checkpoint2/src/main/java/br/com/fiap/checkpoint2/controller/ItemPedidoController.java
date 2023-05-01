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

import br.com.fiap.checkpoint2.model.ItemPedido;
import br.com.fiap.checkpoint2.repository.ItemPedidoRepository;
import br.com.fiap.checkpoint2.service.ItemPedidoService;
import dto.itemPedido.ItemPedidoRequestCreate;
import dto.itemPedido.ItemPedidoRequestUpdate;
import dto.itemPedido.SearchedItemPedido;


@RestController
@RequestMapping("/itens_pedidos")
public class ItemPedidoController {
	
	@Autowired
	private ItemPedidoService itemPedidoService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@GetMapping
	public List<SearchedItemPedido> listAll() {
		List<SearchedItemPedido> result = 
				itemPedidoService.list()
				.stream()
				.map(SearchedItemPedido::toDto)
				.collect(Collectors.toList());
		return result;
	}
	
	@PostMapping	
	public ItemPedido create(@RequestBody ItemPedidoRequestCreate dto) {		
		ItemPedido itemPedido = new ItemPedido();
		
		itemPedido.setQuant_item(dto.getQuant_item());
		itemPedido.setValor_total_item(dto.getValor_total_item());
		
		ItemPedido result = itemPedidoService.save(itemPedido);
		return result;
	}

	@PutMapping
	public ItemPedido update(@RequestBody ItemPedidoRequestUpdate dto) {
		
		boolean exists =
				itemPedidoRepository.existsById(dto.getSeq_item());
		
		if (!exists) {
			throw new RuntimeException("Sequência do pedido não encontrado " + dto.getSeq_item());			
		}
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setSeq_item(dto.getSeq_item());
		itemPedido.setQuant_item(dto.getQuant_item());
		itemPedido.setValor_total_item(dto.getValor_total_item());		

		ItemPedido result = itemPedidoService.save(itemPedido);
		return result;
	}

	@DeleteMapping(value = "{seq_item}")
	public void delete(@PathVariable Long seq_item) {
		itemPedidoRepository.deleteById(seq_item);		
	}

	@GetMapping("/{seq_item}")
	public ItemPedido findById(@PathVariable Long seq_item) {
		return itemPedidoService.findById(seq_item);
	}
}