package br.mil.eb.dashboard_sgl_sg7.dto;

public class GeoreferenciamentoCmdoDTO {

	private String cmdoOds;
	private String longitude;
	private String latitude;
	private String quantidade;
	
	public GeoreferenciamentoCmdoDTO() {
	}

	public GeoreferenciamentoCmdoDTO(String cmdoOds, String longitude, String latitude, String quantidade) {
		this.cmdoOds = cmdoOds;
		this.longitude = longitude;
		this.latitude = latitude;
		this.quantidade = quantidade;
	}

	public String getCmdoOds() {
		return cmdoOds;
	}

	public void setCmdoOds(String cmdoOds) {
		this.cmdoOds = cmdoOds;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
}