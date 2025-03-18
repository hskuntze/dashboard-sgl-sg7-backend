package br.mil.eb.dashboard_sgl_sg7.dto;

public class QcpOMDTO {

	private String cmdo;
	private String latitude;
	private String longitude;
	private Integer previsto;
	private Integer efetivo;
	
	public QcpOMDTO(String cmdo, String latitude, String longitude, Integer previsto, Integer efetivo) {
		this.cmdo = cmdo;
		this.latitude = latitude;
		this.longitude = longitude;
		this.previsto = previsto;
		this.efetivo = efetivo;
	}

	public String getCmdo() {
		return cmdo;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public Integer getPrevisto() {
		return previsto;
	}

	public Integer getEfetivo() {
		return efetivo;
	}
}
