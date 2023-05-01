package dto.produto;

import br.com.fiap.checkpoint2.model.Produto;

public class SearchedProduto {
	
	private Long cod_prod;
	private String nome_prod;
	
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
	
	public static SearchedProduto toDto(Produto produto) {
		SearchedProduto dto = new SearchedProduto();
		dto.setCod_prod(produto.getCod_prod());
		dto.setNome_prod(produto.getNome_prod());		
		return dto;
	}

}
