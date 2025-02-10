package br.mil.eb.dashboard_sgl_sg7.entities.sg7;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sg7.view_material_om")
public class MaterialOM {

	@Id
	private Long id;

	private String cmdo;
	private String rm;
	private String de;
	private String bda;
	private String om;
	private String cidadeestado;
	private String nomeeqp;
	private String modelo;
	private String fabricante;
	private String pn;
	private String sn;
	private String disponibilidade;
	private String motivoindisp;

	public MaterialOM() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCmdo() {
		return cmdo;
	}

	public void setCmdo(String cmdo) {
		this.cmdo = cmdo;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public String getDe() {
		return de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public String getBda() {
		return bda;
	}

	public void setBda(String bda) {
		this.bda = bda;
	}

	public String getOm() {
		return om;
	}

	public void setOm(String om) {
		this.om = om;
	}

	public String getCidadeestado() {
		return cidadeestado;
	}

	public void setCidadeestado(String cidadeestado) {
		this.cidadeestado = cidadeestado;
	}

	public String getNomeeqp() {
		return nomeeqp;
	}

	public void setNomeeqp(String nomeeqp) {
		this.nomeeqp = nomeeqp;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getPn() {
		return pn;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getMotivoindisp() {
		return motivoindisp;
	}

	public void setMotivoindisp(String motivoindisp) {
		this.motivoindisp = motivoindisp;
	}

	@Override
	public String toString() {
		return "MaterialOM [id=" + id + ", cmdo=" + cmdo + ", rm=" + rm + ", de=" + de + ", bda=" + bda + ", om=" + om
				+ ", cidadeestado=" + cidadeestado + ", nomeeqp=" + nomeeqp + ", modelo=" + modelo + ", fabricante="
				+ fabricante + ", pn=" + pn + ", sn=" + sn + ", disponibilidade=" + disponibilidade + ", motivoindisp="
				+ motivoindisp + "]";
	}
}