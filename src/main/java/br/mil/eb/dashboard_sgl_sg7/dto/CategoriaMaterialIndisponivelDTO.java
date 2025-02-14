package br.mil.eb.dashboard_sgl_sg7.dto;

import java.io.Serializable;

public class CategoriaMaterialIndisponivelDTO implements Serializable {
	private static final long serialVersionUID = 4835750983986150144L;
	
	private String categoria;
	private Integer quantidade;
	
	public CategoriaMaterialIndisponivelDTO() {
	}

	public CategoriaMaterialIndisponivelDTO(String categoria, Integer quantidade) {
		super();
		this.categoria = categoria;
		this.quantidade = quantidade;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}