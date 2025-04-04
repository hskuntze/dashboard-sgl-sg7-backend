package br.mil.eb.dashboard_sgl_sg7.dto;

import java.io.Serializable;

import br.mil.eb.dashboard_sgl_sg7.entities.sg7.MaterialOMOperacao;

public class MaterialOMOperacaoDTO implements Serializable {
	
	private static final long serialVersionUID = 3587802111920760292L;
	
	private Long codOm;
	private String sigla;
	private Long codOp;
	private String operacao;
	
	public MaterialOMOperacaoDTO() {
	}
	
	public MaterialOMOperacaoDTO(MaterialOMOperacao entity) {
		this.codOm = entity.getCodOm();
		this.sigla = entity.getSigla();
		this.codOp = entity.getCodOp();
		this.operacao = entity.getOperacao();
	}

	public Long getCodOm() {
		return codOm;
	}

	public String getSigla() {
		return sigla;
	}

	public Long getCodOp() {
		return codOp;
	}

	public String getOperacao() {
		return operacao;
	}
}
