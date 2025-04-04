package br.mil.eb.dashboard_sgl_sg7.dto;

public class ValorTotalCodAoDiariasPassagensDTO {
		
	private String ano;
	private String codAo;
	private Float total;
	
	public ValorTotalCodAoDiariasPassagensDTO() {
	}

	public ValorTotalCodAoDiariasPassagensDTO(String ano, String codAo, Float total) {
		this.ano = ano;
		this.codAo = codAo;
		this.total = total;
	}

	public String getCodAo() {
		return codAo;
	}

	public void setCodAo(String codAo) {
		this.codAo = codAo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}
}