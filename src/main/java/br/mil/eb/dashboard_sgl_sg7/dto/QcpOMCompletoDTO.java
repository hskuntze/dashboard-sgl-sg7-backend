package br.mil.eb.dashboard_sgl_sg7.dto;

import br.mil.eb.dashboard_sgl_sg7.entities.sg7.QcpOM;

public class QcpOMCompletoDTO {

	private String cmdoMilA;
	private String rm;
	private String bda;
	private String de;
	private String sigla;
	private String lat;
	private String longi;
	private String posto;
	private Integer qtdMilPrev;
	private Integer qtdMilEfetivo;
	
	public QcpOMCompletoDTO() {
	}
	
	public QcpOMCompletoDTO(QcpOM el) {
		this.cmdoMilA = el.getCmdoMilA();
		this.rm = el.getRm();
		this.de = el.getDe();
		this.sigla = el.getSigla();
		this.lat = el.getLat();
		this.longi = el.getLongi();
		this.bda = el.getBda();
		this.posto = el.getPosto();
		this.qtdMilPrev = el.getQtdMilPrev();
		this.qtdMilEfetivo = el.getQtdMilEfetivo();
	}

	public String getCmdoMilA() {
		return cmdoMilA;
	}

	public String getRm() {
		return rm;
	}

	public String getDe() {
		return de;
	}

	public String getSigla() {
		return sigla;
	}

	public String getBda() {
		return bda;
	}

	public String getLat() {
		return lat;
	}

	public String getLongi() {
		return longi;
	}

	public String getPosto() {
		return posto;
	}

	public Integer getQtdMilPrev() {
		return qtdMilPrev;
	}

	public Integer getQtdMilEfetivo() {
		return qtdMilEfetivo;
	}
}
