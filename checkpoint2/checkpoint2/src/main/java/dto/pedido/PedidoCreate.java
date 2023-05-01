package dto.pedido;

import java.time.LocalDate;

public class PedidoCreate {
	
	private LocalDate data_ped;

	public LocalDate getData_ped() {
		return data_ped;
	}

	public void setData_ped(LocalDate data_ped) {
		this.data_ped = data_ped;
	}
}
