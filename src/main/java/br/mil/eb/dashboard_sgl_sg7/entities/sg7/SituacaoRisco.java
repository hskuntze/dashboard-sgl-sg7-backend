package br.mil.eb.dashboard_sgl_sg7.entities.sg7;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dashboard_situacao_risco")
public class SituacaoRisco {

	@Id
	private Long id;
	private String projeto;
	private Integer baixo;
	private Integer medio;
	private Integer alto;
	private Integer extremo;
	
	public SituacaoRisco() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjeto() {
		return projeto;
	}

	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

	public Integer getBaixo() {
		return baixo;
	}

	public void setBaixo(Integer baixo) {
		this.baixo = baixo;
	}

	public Integer getMedio() {
		return medio;
	}

	public void setMedio(Integer medio) {
		this.medio = medio;
	}

	public Integer getAlto() {
		return alto;
	}

	public void setAlto(Integer alto) {
		this.alto = alto;
	}

	public Integer getExtremo() {
		return extremo;
	}

	public void setExtremo(Integer extremo) {
		this.extremo = extremo;
	}
}