package br.mil.eb.dashboard_sgl_sg7.dto;

import java.io.Serializable;

public class QtdMaterialCmdoDTO implements Serializable {
	private static final long serialVersionUID = 1642117809144888371L;

	private String cmdo;
	private Integer quantidade;

	public QtdMaterialCmdoDTO() {
	}

	public QtdMaterialCmdoDTO(String cmdo, Integer quantidade) {
		super();
		this.cmdo = cmdo;
		this.quantidade = quantidade;
	}

	public String getCmdo() {
		return cmdo;
	}

	public void setCmdo(String cmdo) {
		this.cmdo = cmdo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}