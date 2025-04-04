package br.mil.eb.dashboard_sgl_sg7.dto;

public class ValorTotalClassificacaoDiariasPassagensDTO {
		
	private String ano;
	private String classificacao;
	private Float total;
	
	public ValorTotalClassificacaoDiariasPassagensDTO() {
	}

	public ValorTotalClassificacaoDiariasPassagensDTO(String ano, String classificacao, Float total) {
		this.ano = ano;
		this.classificacao = classificacao;
		this.total = total;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}
}