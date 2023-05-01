package br.com.fiap.checkpoint2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.model.ItemPedido;
import br.com.fiap.checkpoint2.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public List<ItemPedido> list() {
		return itemPedidoRepository.findAll();
	}
	public ItemPedido save(ItemPedido itemPedido) {
		return itemPedidoRepository.save(itemPedido);
	}

	public ItemPedido findById(Long seq_item) {
	    Optional<ItemPedido> itemPedido = itemPedidoRepository.findById(seq_item);
	    return itemPedido.orElse(null);
	}
}
