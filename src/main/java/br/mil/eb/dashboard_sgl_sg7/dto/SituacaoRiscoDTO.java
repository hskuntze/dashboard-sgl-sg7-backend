package br.mil.eb.dashboard_sgl_sg7.dto;

import br.mil.eb.dashboard_sgl_sg7.entities.sg7.SituacaoRisco;

public class SituacaoRiscoDTO {

	private Long id;
	private String projeto;
	private Integer baixo;
	private Integer medio;
	private Integer alto;
	private Integer extremo;
	
	public SituacaoRiscoDTO() {
	}
	
	public SituacaoRiscoDTO(SituacaoRisco entity) {
		this.id = entity.getId();
		this.projeto = entity.getProjeto();
		this.baixo = entity.getBaixo();
		this.medio = entity.getMedio();
		this.alto = entity.getAlto();
		this.extremo = entity.getExtremo();
	}

	public Long getId() {
		return id;
	}

	public String getProjeto() {
		return projeto;
	}

	public Integer getBaixo() {
		return baixo;
	}

	public Integer getMedio() {
		return medio;
	}

	public Integer getAlto() {
		return alto;
	}

	public Integer getExtremo() {
		return extremo;
	}
}