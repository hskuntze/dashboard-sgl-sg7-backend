package br.mil.eb.dashboard_sgl_sg7.dto;

import java.io.Serializable;

public class QtdMaterialSubsistemaDTO implements Serializable {
	private static final long serialVersionUID = 1642117809144888371L;

	private String subsistema;
	private Integer quantidade;

	public QtdMaterialSubsistemaDTO() {
	}

	public QtdMaterialSubsistemaDTO(String subsistema, Integer quantidade) {
		super();
		this.subsistema = subsistema;
		this.quantidade = quantidade;
	}

	public String getSubsistema() {
		return subsistema;
	}

	public void setSubsistema(String subsistema) {
		this.subsistema = subsistema;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}