package br.mil.eb.dashboard_sgl_sg7.dto;

import java.io.Serializable;

import br.mil.eb.dashboard_sgl_sg7.entities.sgl.Material;

public class MaterialDTO implements Serializable {
	private static final long serialVersionUID = -3204941781541185952L;
	
	private Long id;
	private String pn;
	private String nomenclatura;
	private String codigoembraer;
	private String codigoestocagem;
	private String descricaopningles;
	private String descricaopnportugues;
	private String fabricante;
	private String nsn;
	private String peso;
	private String mtbf;
	private String qdtembalagem;
	private String tempovidautil;
	private String tempoestoque;
	private String materialperigoso;
	private String codicaoestocagem;
	private String classe;
	private String idsigelog;
	private String observacao;
	
	public MaterialDTO() {
	}
	
	public MaterialDTO(Material m) {
	    this.id = m.getId();
	    this.pn = m.getPn();
	    this.nomenclatura = m.getNomenclatura();
	    this.codigoembraer = m.getCodigoembraer();
	    this.codigoestocagem = m.getCodigoestocagem();
	    this.descricaopningles = m.getDescricaopningles();
	    this.descricaopnportugues = m.getDescricaopnportugues();
	    this.fabricante = m.getFabricante();
	    this.nsn = m.getNsn();
	    this.peso = m.getPeso();
	    this.mtbf = m.getMtbf();
	    this.qdtembalagem = m.getQdtembalagem();
	    this.tempovidautil = m.getTempovidautil();
	    this.tempoestoque = m.getTempoestoque();
	    this.materialperigoso = m.getMaterialperigoso();
	    this.codicaoestocagem = m.getCodicaoestocagem();
	    this.classe = m.getClasse();
	    this.idsigelog = m.getIdsigelog();
	    this.observacao = m.getObservacao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPn() {
		return pn;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	public String getNomenclatura() {
		return nomenclatura;
	}

	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}

	public String getCodigoembraer() {
		return codigoembraer;
	}

	public void setCodigoembraer(String codigoembraer) {
		this.codigoembraer = codigoembraer;
	}

	public String getCodigoestocagem() {
		return codigoestocagem;
	}

	public void setCodigoestocagem(String codigoestocagem) {
		this.codigoestocagem = codigoestocagem;
	}

	public String getDescricaopningles() {
		return descricaopningles;
	}

	public void setDescricaopningles(String descricaopningles) {
		this.descricaopningles = descricaopningles;
	}

	public String getDescricaopnportugues() {
		return descricaopnportugues;
	}

	public void setDescricaopnportugues(String descricaopnportugues) {
		this.descricaopnportugues = descricaopnportugues;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getNsn() {
		return nsn;
	}

	public void setNsn(String nsn) {
		this.nsn = nsn;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getMtbf() {
		return mtbf;
	}

	public void setMtbf(String mtbf) {
		this.mtbf = mtbf;
	}

	public String getQdtembalagem() {
		return qdtembalagem;
	}

	public void setQdtembalagem(String qdtembalagem) {
		this.qdtembalagem = qdtembalagem;
	}

	public String getTempovidautil() {
		return tempovidautil;
	}

	public void setTempovidautil(String tempovidautil) {
		this.tempovidautil = tempovidautil;
	}

	public String getTempoestoque() {
		return tempoestoque;
	}

	public void setTempoestoque(String tempoestoque) {
		this.tempoestoque = tempoestoque;
	}

	public String getMaterialperigoso() {
		return materialperigoso;
	}

	public void setMaterialperigoso(String materialperigoso) {
		this.materialperigoso = materialperigoso;
	}

	public String getCodicaoestocagem() {
		return codicaoestocagem;
	}

	public void setCodicaoestocagem(String codicaoestocagem) {
		this.codicaoestocagem = codicaoestocagem;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getIdsigelog() {
		return idsigelog;
	}

	public void setIdsigelog(String idsigelog) {
		this.idsigelog = idsigelog;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "MaterialDTO [id=" + id + ", pn=" + pn + ", nomenclatura=" + nomenclatura + ", codigoembraer="
				+ codigoembraer + ", codigoestocagem=" + codigoestocagem + ", descricaopningles=" + descricaopningles
				+ ", descricaopnportugues=" + descricaopnportugues + ", fabricante=" + fabricante + ", nsn=" + nsn
				+ ", peso=" + peso + ", mtbf=" + mtbf + ", qdtembalagem=" + qdtembalagem + ", tempovidautil="
				+ tempovidautil + ", tempoestoque=" + tempoestoque + ", materialperigoso=" + materialperigoso
				+ ", codicaoestocagem=" + codicaoestocagem + ", classe=" + classe + ", idsigelog=" + idsigelog
				+ ", observacao=" + observacao + "]";
	}
}