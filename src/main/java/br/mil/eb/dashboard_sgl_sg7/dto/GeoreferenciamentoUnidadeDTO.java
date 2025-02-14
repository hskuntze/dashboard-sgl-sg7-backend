package br.mil.eb.dashboard_sgl_sg7.dto;

import java.io.Serializable;

public class GeoreferenciamentoUnidadeDTO implements Serializable {
	private static final long serialVersionUID = 9096772519384820497L;
	
	private String equipamento;
	private String om;
	private String bda;
	private String rm;
	private String cmdoOds;
	private String cidade;
	private String estado;
	private String latitude;
	private String longitude;
	
	public GeoreferenciamentoUnidadeDTO() {
	}

	public GeoreferenciamentoUnidadeDTO(String equipamento, String om, String bda, String rm, String cmdoOds, String cidade, String estado, String latitude, String longitude) {
		this.equipamento = equipamento;
		this.om = om;
		this.bda = bda;
		this.rm = rm;
		this.cmdoOds = cmdoOds;
		this.cidade = cidade;
		this.estado = estado;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public String getOm() {
		return om;
	}

	public void setOm(String om) {
		this.om = om;
	}

	public String getBda() {
		return bda;
	}

	public void setBda(String bda) {
		this.bda = bda;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public String getCmdoOds() {
		return cmdoOds;
	}

	public void setCmdoOds(String cmdoOds) {
		this.cmdoOds = cmdoOds;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}