package br.com.fiap.checkpoint2.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo_produto", updatable = false, nullable = false, unique = true)
	private Long cod_prod;
	@Column(name = "nome")
	private String nome_prod;
	@Column(name = "preco")
	private BigDecimal preco_prod;
	@Column(name = "data_validade")
	private LocalDate data_val_prod;
	@Column(name = "data_garantia")
	private LocalDate data_gar_prod;
	@Column(name = "em_estoque")
	private Boolean em_est_prod;



	public Long getCod_prod() {
		return cod_prod;
	}

	public void setCod_prod(Long cod_prod) {
		this.cod_prod = cod_prod;
	}

	public String getNome_prod() {
		return nome_prod;
	}

	public void setNome_prod(String nome_prod) {
		this.nome_prod = nome_prod;
	}

	public BigDecimal getPreco_prod() {
		return preco_prod;
	}

	public void setPreco_prod(BigDecimal preco_prod) {
		this.preco_prod = preco_prod;
	}

	public Boolean getEm_est_prod() {
		return em_est_prod;
	}

	public void setEm_est_prod(Boolean em_est_prod) {
		this.em_est_prod = em_est_prod;
	}

	public LocalDate getData_val_prod() {
		return data_val_prod;
	}

	public void setData_val_prod(LocalDate data_val_prod) {
		this.data_val_prod = data_val_prod;
	}

	public LocalDate getData_gar_prod() {
		return data_gar_prod;
	}

	public void setData_gar_prod(LocalDate data_gar_prod) {
		this.data_gar_prod = data_gar_prod;
	}
}
