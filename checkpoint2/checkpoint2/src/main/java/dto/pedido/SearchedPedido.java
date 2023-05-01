package dto.pedido;

import br.com.fiap.checkpoint2.model.Pedido;

public class SearchedPedido {
	
	private Long num_ped;

	public Long getNum_ped() {
		return num_ped;
	}

	public void setNum_ped(Long num_ped) {
		this.num_ped = num_ped;
	}
	
	public static SearchedPedido toDto(Pedido pedido) {
		SearchedPedido dto = new SearchedPedido();
		dto.setNum_ped(pedido.getNum_ped());		
		return dto;
	}

}
