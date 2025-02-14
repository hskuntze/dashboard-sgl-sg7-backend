package br.mil.eb.dashboard_sgl_sg7.entities.sg7;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sg7.view_material_georef")
public class MaterialOM {

	@Column(name = "cmdo_ods")
	private String cmdoOds;
	private String rm;
	private String de;
	private String bda;
	private String om;
	private String cidade;
	private String estado;
	private String latitude;
	private String longitude;
	private String idsigelog;
	private String equipamento;
	private String modelo;
	private String fabricante;
	private String pn;
	
	@Id
	private String sn;
	private String disponibilidade;
	private String motivoindisp;
	private String subsistema;
	private String grupo;
	@Column(name = "tipo_eqp")
	private String tipoEqp;
	
	public MaterialOM() {
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

	public String getIdsigelog() {
		return idsigelog;
	}

	public void setIdsigelog(String idsigelog) {
		this.idsigelog = idsigelog;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public String getSubsistema() {
		return subsistema;
	}

	public void setSubsistema(String subsistema) {
		this.subsistema = subsistema;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getTipoEqp() {
		return tipoEqp;
	}

	public void setTipoEqp(String tipoEqp) {
		this.tipoEqp = tipoEqp;
	}

	@Override
	public String toString() {
		return "MaterialOM [cmdoOds=" + cmdoOds + ", rm=" + rm + ", de=" + de + ", bda=" + bda + ", om="
				+ om + ", cidade=" + cidade + ", estado=" + estado + ", latitude=" + latitude + ", longitude="
				+ longitude + ", idsigelog=" + idsigelog + ", equipamento=" + equipamento + ", modelo=" + modelo
				+ ", fabricante=" + fabricante + ", pn=" + pn + ", sn=" + sn + ", disponibilidade=" + disponibilidade
				+ ", motivoindisp=" + motivoindisp + ", subsistema=" + subsistema + ", grupo=" + grupo + ", tipoEqp="
				+ tipoEqp + "]";
	}
}