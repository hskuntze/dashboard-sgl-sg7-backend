package br.mil.eb.dashboard_sgl_sg7.dto;

import java.io.Serializable;

public class QtdMaterialCidadeEstadoDTO implements Serializable {
	private static final long serialVersionUID = 1642117809144888371L;

	private String cidadeestado;
	private Integer quantidade;

	public QtdMaterialCidadeEstadoDTO() {
	}

	public QtdMaterialCidadeEstadoDTO(String cidadeestado, Integer quantidade) {
		super();
		this.cidadeestado = cidadeestado;
		this.quantidade = quantidade;
	}

	public String getCidadeestado() {
		return cidadeestado;
	}

	public void setCidadeestado(String cidadeestado) {
		this.cidadeestado = cidadeestado;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}