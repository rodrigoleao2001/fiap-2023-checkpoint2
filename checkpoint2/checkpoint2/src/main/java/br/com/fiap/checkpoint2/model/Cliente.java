package br.com.fiap.checkpoint2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "codigo_cliente", updatable = false, nullable = false, unique = true)
	private Long cod_cli;
	@Column(name = "nome")
	private String nome_cli;
	@Column(name = "inscricao_federal")
	private Long ins_fed_cli;
	@Column (name = "cep")
	private Long cep_cli;
	
	public Long getCod_cli() {
		return cod_cli;
	}
	public void setCod_cli(Long cod_cli) {
		this.cod_cli = cod_cli;
	}
	public String getNome_cli() {
		return nome_cli;
	}
	public void setNome_cli(String nome_cli) {
		this.nome_cli = nome_cli;
	}
	public Long getIns_fed_cli() {
		return ins_fed_cli;
	}
	public void setIns_fed_cli(Long ins_fed_cli) {
		this.ins_fed_cli = ins_fed_cli;
	}
	public Long getCep_cli() {
		return cep_cli;
	}
	public void setCep_cli(Long cep_cli) {
		this.cep_cli = cep_cli;
	}
	
}
