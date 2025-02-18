package br.mil.eb.dashboard_sgl_sg7.dto;

public class QtdMaterialTipoEqpDTO {

	private String tipo;
	private Integer existente;
	private Integer previsto;
	
	public QtdMaterialTipoEqpDTO() {
	}

	public QtdMaterialTipoEqpDTO(String tipo, Integer existente, Integer previsto) {
		this.tipo = tipo;
		this.existente = existente;
		this.previsto = previsto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getExistente() {
		return existente;
	}

	public void setExistente(Integer existente) {
		this.existente = existente;
	}

	public Integer getPrevisto() {
		return previsto;
	}

	public void setPrevisto(Integer previsto) {
		this.previsto = previsto;
	}
}