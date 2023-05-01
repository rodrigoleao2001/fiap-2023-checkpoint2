package dto.pedido;

import java.time.LocalDate;

public class PedidoRequestUpdate {
	
	private Long num_ped;
	private LocalDate data_ped;
	
	public Long getNum_ped() {
		return num_ped;
	}
	public void setNum_ped(Long num_ped) {
		this.num_ped = num_ped;
	}
	public LocalDate getData_ped() {
		return data_ped;
	}
	public void setData_ped(LocalDate data_ped) {
		this.data_ped = data_ped;
	}
}
