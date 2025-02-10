package br.mil.eb.dashboard_sgl_sg7.dto;

import java.io.Serializable;

public class QtdChamadoAnoDTO implements Serializable {
	private static final long serialVersionUID = 4392955232032699171L;

	private Integer ano;
	private Integer quantidade;

	public QtdChamadoAnoDTO() {
	}

	public QtdChamadoAnoDTO(Integer ano, Integer quantidade) {
		this.ano = ano;
		this.quantidade = quantidade;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}