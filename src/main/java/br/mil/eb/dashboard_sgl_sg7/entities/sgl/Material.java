package br.mil.eb.dashboard_sgl_sg7.entities.sgl;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "sad2_materiais")
public class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Lob
	private String observacao;

	public Material() {
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

	public void setCodicaoestocagem(String condicaoestocagem) {
		this.codicaoestocagem = condicaoestocagem;
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
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		Material other = (Material) obj;
		return Objects.equals(id, other.id);
	}
}