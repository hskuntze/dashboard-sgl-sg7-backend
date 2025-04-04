package br.mil.eb.dashboard_sgl_sg7.entities.sg7;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dashboard_execucao_financeira")
public class ExecucaoFinanceira {

	@Id
	private Long id;
	private String projeto;
	private BigDecimal pdr2024;
	private BigDecimal descentralizado;
	private BigDecimal empenhado;
	private BigDecimal rpnp;
	
	public ExecucaoFinanceira() {
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

	public BigDecimal getPdr2024() {
		return pdr2024;
	}

	public void setPdr2024(BigDecimal pdr2024) {
		this.pdr2024 = pdr2024;
	}

	public BigDecimal getDescentralizado() {
		return descentralizado;
	}

	public void setDescentralizado(BigDecimal descentralizado) {
		this.descentralizado = descentralizado;
	}

	public BigDecimal getEmpenhado() {
		return empenhado;
	}

	public void setEmpenhado(BigDecimal empenhado) {
		this.empenhado = empenhado;
	}

	public BigDecimal getRpnp() {
		return rpnp;
	}

	public void setRpnp(BigDecimal rpnp) {
		this.rpnp = rpnp;
	}
}