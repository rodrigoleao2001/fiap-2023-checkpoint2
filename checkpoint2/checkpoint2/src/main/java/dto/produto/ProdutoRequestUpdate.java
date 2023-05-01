package dto.produto;

import java.math.BigDecimal;
import java.time.LocalDate;


public class ProdutoRequestUpdate {
	
	private Long cod_prod;
	private String nome_prod;
	private BigDecimal preco_prod;
	private LocalDate data_val_prod;
	private LocalDate data_gar_prod;
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
	public Boolean getEm_est_prod() {
		return em_est_prod;
	}
	public void setEm_est_prod(Boolean em_est_prod) {
		this.em_est_prod = em_est_prod;
	}
}
