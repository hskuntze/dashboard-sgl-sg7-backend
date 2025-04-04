package br.mil.eb.dashboard_sgl_sg7.entities.sg7;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "material_operacoes")
public class MaterialOperacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO")
	private Long id;
	@Column(name = "COD_OP")
	private Long codOp;
	private String material;
	private Integer qnt;
	
	public MaterialOperacao() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodOp() {
		return codOp;
	}

	public void setCodOp(Long codOp) {
		this.codOp = codOp;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Integer getQnt() {
		return qnt;
	}

	public void setQnt(Integer qnt) {
		this.qnt = qnt;
	}
}