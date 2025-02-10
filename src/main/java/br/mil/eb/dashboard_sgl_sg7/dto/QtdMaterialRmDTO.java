package br.mil.eb.dashboard_sgl_sg7.dto;

import java.io.Serializable;

public class QtdMaterialRmDTO implements Serializable {
	private static final long serialVersionUID = 1642117809144888371L;

	private String rm;
	private Integer quantidade;

	public QtdMaterialRmDTO() {
	}

	public QtdMaterialRmDTO(String rm, Integer quantidade) {
		this.rm = rm;
		this.quantidade = quantidade;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}