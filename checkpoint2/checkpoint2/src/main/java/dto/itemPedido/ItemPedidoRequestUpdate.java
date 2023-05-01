package dto.itemPedido;

import java.math.BigDecimal;

public class ItemPedidoRequestUpdate {
	
	private Long seq_item;
	private BigDecimal quant_item;
	private BigDecimal valor_total_item;
	
	public Long getSeq_item() {
		return seq_item;
	}
	public void setSeq_item(Long seq_item) {
		this.seq_item = seq_item;
	}
	public BigDecimal getQuant_item() {
		return quant_item;
	}
	public void setQuant_item(BigDecimal quant_item) {
		this.quant_item = quant_item;
	}
	public BigDecimal getValor_total_item() {
		return valor_total_item;
	}
	public void setValor_total_item(BigDecimal valor_total_item) {
		this.valor_total_item = valor_total_item;
	}
}
