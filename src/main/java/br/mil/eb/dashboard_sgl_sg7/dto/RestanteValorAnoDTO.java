package br.mil.eb.dashboard_sgl_sg7.dto;

import java.math.BigDecimal;

public class RestanteValorAnoDTO {

	private String ano;
	private BigDecimal valor;
	
	public RestanteValorAnoDTO() {
	}
	public RestanteValorAnoDTO(String ano, BigDecimal valor) {
		this.ano = ano;
		this.valor = valor;
	}

	public String getAno() {
		return ano;
	}

	public BigDecimal getValor() {
		return valor;
	}
}
