package br.mil.eb.dashboard_sgl_sg7.dto;

public class QtdMaterialDisponibilidadeCmdoDTO {

	private String cmdo;
	private Integer disponivel;
	private Integer indisponivel;
	
	public QtdMaterialDisponibilidadeCmdoDTO() {
	}

	public QtdMaterialDisponibilidadeCmdoDTO(String cmdo, Integer disponivel, Integer indisponivel) {
		this.cmdo = cmdo;
		this.disponivel = disponivel;
		this.indisponivel = indisponivel;
	}

	public String getCmdo() {
		return cmdo;
	}

	public Integer getDisponivel() {
		return disponivel;
	}

	public Integer getIndisponivel() {
		return indisponivel;
	}
}
