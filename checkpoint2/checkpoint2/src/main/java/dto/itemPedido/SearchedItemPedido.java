package dto.itemPedido;

import br.com.fiap.checkpoint2.model.ItemPedido;

public class SearchedItemPedido {
	
	private Long seq_item;

	public Long getSeq_item() {
		return seq_item;
	}

	public void setSeq_item(Long seq_item) {
		this.seq_item = seq_item;
	}
	
	public static SearchedItemPedido toDto(ItemPedido itemPedido) {
		SearchedItemPedido dto = new SearchedItemPedido();
		dto.setSeq_item(itemPedido.getSeq_item());		
		return dto;
	}

}
