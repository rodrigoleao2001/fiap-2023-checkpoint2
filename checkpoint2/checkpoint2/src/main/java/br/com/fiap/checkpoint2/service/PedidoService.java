package br.com.fiap.checkpoint2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.model.Pedido;
import br.com.fiap.checkpoint2.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> list() {
		return pedidoRepository.findAll();
	}
	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	public void delete(Long num_ped) {
	    pedidoRepository.deleteById(num_ped);
	}

	public Pedido findById(Long num_ped) {
	    Optional<Pedido> pedido = pedidoRepository.findById(num_ped);
	    return pedido.orElse(null);
	}
}
