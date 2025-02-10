package br.mil.eb.dashboard_sgl_sg7.entities.sgl;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sad2_chamados")
public class Chamado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String chamado;
	private Date dataAbertura;
	private Date datafalha;
	private String status;
	@Lob
	private String falha;
	private String disponibilidade;

	@ManyToOne
    @JoinColumn(name = "id_om", nullable = false)
	private OM om;

	@ManyToOne
    @JoinColumn(name = "id_material", nullable = false)
	private Material material;

	public Chamado() {
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getChamado() {
		return chamado;
	}

	public void setChamado(String chamado) {
		this.chamado = chamado;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDatafalha() {
		return datafalha;
	}

	public void setDatafalha(Date datafalha) {
		this.datafalha = datafalha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFalha() {
		return falha;
	}

	public void setFalha(String falha) {
		this.falha = falha;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public OM getOm() {
		return om;
	}

	public void setOm(OM om) {
		this.om = om;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || (getClass() != obj.getClass())) {
			return false;
		}
		Chamado other = (Chamado) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Chamado [codigo=" + codigo + ", chamado=" + chamado + ", dataAbertura=" + dataAbertura + ", datafalha="
				+ datafalha + ", status=" + status + ", falha=" + falha + ", disponibilidade=" + disponibilidade
				+ ", om=" + om + ", material=" + material + "]";
	}
}