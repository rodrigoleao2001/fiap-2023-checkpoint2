package dto.cliente;

import br.com.fiap.checkpoint2.model.Cliente;

public class SearchedCliente {
	
	private Long cod_cli;
	private String nome_cli;
	
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
	
	public static SearchedCliente toDto(Cliente cliente) {
		SearchedCliente dto = new SearchedCliente();
		dto.setCod_cli(cliente.getCod_cli());
		dto.setNome_cli(cliente.getNome_cli());		
		return dto;
	}

}
