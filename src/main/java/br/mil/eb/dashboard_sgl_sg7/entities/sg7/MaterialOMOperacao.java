package br.mil.eb.dashboard_sgl_sg7.entities.sg7;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "view_om_operacoes")
public class MaterialOMOperacao {

	@Id
	@Column(name = "COD_OM")
	private Long codOm;
	private String sigla;
	@Column(name = "COD_OP")
	private Long codOp;
	private String operacao;
	
	public MaterialOMOperacao() {
	}

	public Long getCodOm() {
		return codOm;
	}

	public void setCodOm(Long codOm) {
		this.codOm = codOm;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Long getCodOp() {
		return codOp;
	}

	public void setCodOp(Long codOp) {
		this.codOp = codOp;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
}