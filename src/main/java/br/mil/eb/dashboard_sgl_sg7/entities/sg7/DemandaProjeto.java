package br.mil.eb.dashboard_sgl_sg7.entities.sg7;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dashboard_demandas_projetos")
public class DemandaProjeto {

	@Id
	private Long id;
	private String projeto;
	private Long quantidade;
	@Column(name = "inicio_periodo")
	private Date inicioPeriodo;
	@Column(name = "fim_periodo")
	private Date fimPeriodo;
	
	public DemandaProjeto() {
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

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Date getInicioPeriodo() {
		return inicioPeriodo;
	}

	public void setInicioPeriodo(Date inicioPeriodo) {
		this.inicioPeriodo = inicioPeriodo;
	}

	public Date getFimPeriodo() {
		return fimPeriodo;
	}

	public void setFimPeriodo(Date fimPeriodo) {
		this.fimPeriodo = fimPeriodo;
	}
}