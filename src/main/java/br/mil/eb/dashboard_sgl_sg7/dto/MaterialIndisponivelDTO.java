package br.mil.eb.dashboard_sgl_sg7.dto;

public class MaterialIndisponivelDTO {
	private String cmdo;
	private String rm;
	private String de;
	private String bda;
	private String om;
	private String idsigelog;
	private String equipamento;
	private String modelo;
	private String fabricante;
	private String pn;
	private String sn;
	private String motivoindisp;
	private String subsistema;
	private String grupo;
	private String tipoEqp;
	
	public MaterialIndisponivelDTO() {
	}

	public MaterialIndisponivelDTO(String cmdo, String rm, String de, String bda, String om, String idsigelog,
			String equipamento, String modelo, String fabricante, String pn, String sn, String motivoindisp,
			String subsistema, String grupo, String tipoEqp) {
		this.cmdo = cmdo;
		this.rm = rm;
		this.de = de;
		this.bda = bda;
		this.om = om;
		this.idsigelog = idsigelog;
		this.equipamento = equipamento;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.pn = pn;
		this.sn = sn;
		this.motivoindisp = motivoindisp;
		this.subsistema = subsistema;
		this.grupo = grupo;
		this.tipoEqp = tipoEqp;
	}

	public String getCmdo() {
		return cmdo;
	}

	public String getRm() {
		return rm;
	}

	public String getDe() {
		return de;
	}

	public String getBda() {
		return bda;
	}

	public String getOm() {
		return om;
	}

	public String getIdsigelog() {
		return idsigelog;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public String getModelo() {
		return modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public String getPn() {
		return pn;
	}

	public String getSn() {
		return sn;
	}

	public String getMotivoindisp() {
		return motivoindisp;
	}

	public String getSubsistema() {
		return subsistema;
	}

	public String getGrupo() {
		return grupo;
	}

	public String getTipoEqp() {
		return tipoEqp;
	}
}