package br.com.fiap.checkpoint2.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "numero_pedido", updatable = false, nullable = false, unique = true)
	private Long num_ped;
	@Column(name = "data_pedido")
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
