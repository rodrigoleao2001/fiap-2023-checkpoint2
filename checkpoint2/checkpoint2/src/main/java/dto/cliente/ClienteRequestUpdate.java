package dto.cliente;


public class ClienteRequestUpdate {
	
	private Long cod_cli;
	private String nome_cli;
	private Long ins_fed_cli;
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
