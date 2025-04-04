package br.mil.eb.dashboard_sgl_sg7.dto;

import java.math.BigDecimal;

public class TipoAcaoValorDTO {

	private String tipo;
	private BigDecimal valor;
	
	public TipoAcaoValorDTO() {
	}

	public TipoAcaoValorDTO(String tipo, BigDecimal valor) {
		this.tipo = tipo;
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}
}
