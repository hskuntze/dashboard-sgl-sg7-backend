package br.mil.eb.dashboard_sgl_sg7.entities.sg7;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import br.mil.eb.dashboard_sgl_sg7.entities.sg7.ids.QcpOMId;

@Entity
@Immutable
@Table(name = "qcp_om_com_exis_prev_view")
@IdClass(QcpOMId.class)
public class QcpOM {
	
	@Id
	@Column(name = "Cmdo_Mil_A")
	private String cmdoMilA;
	private String rm;
	private String bda;
	private String de;
	private String sigla;
	private String lat;
	private String longi;
	private String posto;
	@Column(name = "QTD_MIL_PREV")
	private Integer qtdMilPrev;
	@Column(name = "QTD_MIL_EFETIVO")
	private Integer qtdMilEfetivo;
	
	public QcpOM() {
	}

	public String getCmdoMilA() {
		return cmdoMilA;
	}

	public void setCmdoMilA(String cmdoMilA) {
		this.cmdoMilA = cmdoMilA;
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLongi() {
		return longi;
	}

	public void setLongi(String longi) {
		this.longi = longi;
	}

	public String getPosto() {
		return posto;
	}

	public void setPosto(String posto) {
		this.posto = posto;
	}

	public Integer getQtdMilPrev() {
		return qtdMilPrev;
	}

	public void setQtdMilPrev(Integer qtdMilPrev) {
		this.qtdMilPrev = qtdMilPrev;
	}

	public Integer getQtdMilEfetivo() {
		return qtdMilEfetivo;
	}

	public void setQtdMilEfetivo(Integer qtdMilEfetivo) {
		this.qtdMilEfetivo = qtdMilEfetivo;
	}

	public String getBda() {
		return bda;
	}

	public void setBda(String bda) {
		this.bda = bda;
	}

	@Override
	public String toString() {
		return "QcpOM [cmdoMilA=" + cmdoMilA + ", rm=" + rm + ", de=" + de + ", sigla=" + sigla + ", lat=" + lat
				+ ", longi=" + longi + ", posto=" + posto + ", qtdMilPrev=" + qtdMilPrev + ", qtdMilEfetivo="
				+ qtdMilEfetivo + "]";
	}
}