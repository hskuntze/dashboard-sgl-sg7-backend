package br.mil.eb.dashboard_sgl_sg7.dto;

import java.io.Serializable;

public class QtdMaterialBdaDTO implements Serializable {
	private static final long serialVersionUID = 1642117809144888371L;

	private String bda;
	private Integer quantidade;

	public QtdMaterialBdaDTO() {
	}

	public QtdMaterialBdaDTO(String bda, Integer quantidade) {
		this.bda = bda;
		this.quantidade = quantidade;
	}

	public String getBda() {
		return bda;
	}

	public void setBda(String bda) {
		this.bda = bda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}