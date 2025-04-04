package br.mil.eb.dashboard_sgl_sg7.dto;

import java.io.Serializable;

import br.mil.eb.dashboard_sgl_sg7.entities.sg7.MaterialOperacao;

public class MaterialOperacaoDTO implements Serializable {
	
	private static final long serialVersionUID = 4376575661478391966L;
	
	private Long id;
	private Long codOp;
	private String material;
	private Integer qnt;
	
	public MaterialOperacaoDTO() {
	}
	
	public MaterialOperacaoDTO(MaterialOperacao entity) {
		this.id = entity.getId();
		this.codOp = entity.getCodOp();
		this.material = entity.getMaterial();
		this.qnt = entity.getQnt();
	}

	public Long getId() {
		return id;
	}

	public Long getCodOp() {
		return codOp;
	}

	public String getMaterial() {
		return material;
	}

	public Integer getQnt() {
		return qnt;
	}
}