package br.mil.eb.dashboard_sgl_sg7.dto;

import java.io.Serializable;
import java.util.Date;

import br.mil.eb.dashboard_sgl_sg7.entities.sg7.DemandaProjeto;

public class DemandaProjetoDTO implements Serializable {
	private static final long serialVersionUID = 5423221113020731480L;
	
	private Long id;
	private String projeto;
	private Long quantidade;
	private Date inicioPeriodo;
	private Date fimPeriodo;
	
	public DemandaProjetoDTO() {
	}
	
	public DemandaProjetoDTO(DemandaProjeto entity) {
		this.id = entity.getId();
		this.projeto = entity.getProjeto();
		this.quantidade = entity.getQuantidade();
		this.inicioPeriodo = entity.getInicioPeriodo();
		this.fimPeriodo = entity.getFimPeriodo();
	}

	public Long getId() {
		return id;
	}

	public String getProjeto() {
		return projeto;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public Date getInicioPeriodo() {
		return inicioPeriodo;
	}

	public Date getFimPeriodo() {
		return fimPeriodo;
	}
}