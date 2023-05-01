package dto.pedido;

import java.time.LocalDate;

public class PedidoRequestCreate {
	
	private LocalDate data_ped;

	public LocalDate getData_ped() {
		return data_ped;
	}

	public void setData_ped(LocalDate data_ped) {
		this.data_ped = data_ped;
	}
}
