package br.mil.eb.dashboard_sgl_sg7.dto;

import java.io.Serializable;

public class QtdMaterialDisponibilidadeDTO implements Serializable {
	private static final long serialVersionUID = 1642117809144888371L;

	private String disponibilidade;
	private Integer quantidade;

	public QtdMaterialDisponibilidadeDTO() {
	}

	public QtdMaterialDisponibilidadeDTO(String disponibilidade, Integer quantidade) {
		this.disponibilidade = disponibilidade;
		this.quantidade = quantidade;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}