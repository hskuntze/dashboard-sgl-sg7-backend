package br.mil.eb.dashboard_sgl_sg7.entities.sgl;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "sad2_patrimonio")
public class Patrimonio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String pn;

	@Temporal(TemporalType.DATE)
	private Date datarecebimento;

	@Temporal(TemporalType.DATE)
	private Date datainiciogarantia;

	@Temporal(TemporalType.DATE)
	private Date datafimgarantia;

	private Integer tempogarantia;
	private String tipodocumento;
	private String numerodocumento;

	@Temporal(TemporalType.DATE)
	private Date data;
	private String numeroserie;
	private String subsistema;
	private String embraer;

	@ManyToOne
    @JoinColumn(name = "om", nullable = false)
	private OM om;

	@ManyToOne
    @JoinColumn(name = "material", nullable = false)
	private Material material;

	public Patrimonio() {
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

	public Date getDatarecebimento() {
		return datarecebimento;
	}

	public void setDatarecebimento(Date datarecebimento) {
		this.datarecebimento = datarecebimento;
	}

	public Date getDatainiciogarantia() {
		return datainiciogarantia;
	}

	public void setDatainiciogarantia(Date datainiciogarantia) {
		this.datainiciogarantia = datainiciogarantia;
	}

	public Date getDatafimgarantia() {
		return datafimgarantia;
	}

	public void setDatafimgarantia(Date datafimgarantia) {
		this.datafimgarantia = datafimgarantia;
	}

	public Integer getTempogarantia() {
		return tempogarantia;
	}

	public void setTempogarantia(Integer tempogarantia) {
		this.tempogarantia = tempogarantia;
	}

	public String getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getNumerodocumento() {
		return numerodocumento;
	}

	public void setNumerodocumento(String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNumeroserie() {
		return numeroserie;
	}

	public void setNumeroserie(String numeroserie) {
		this.numeroserie = numeroserie;
	}

	public String getSubsistema() {
		return subsistema;
	}

	public void setSubsistema(String subsistema) {
		this.subsistema = subsistema;
	}

	public String getEmbraer() {
		return embraer;
	}

	public void setEmbraer(String embraer) {
		this.embraer = embraer;
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
		Patrimonio other = (Patrimonio) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Patrimonio [id=" + id + ", pn=" + pn + ", datarecebimento=" + datarecebimento + ", datainiciogarantia="
				+ datainiciogarantia + ", datafimgarantia=" + datafimgarantia + ", tempogarantia=" + tempogarantia
				+ ", numerodocumento=" + numerodocumento + ", data=" + data + ", numeroserie=" + numeroserie
				+ ", subsistema=" + subsistema + ", embraer=" + embraer + ", om=" + om + ", material=" + material + "]";
	}
}