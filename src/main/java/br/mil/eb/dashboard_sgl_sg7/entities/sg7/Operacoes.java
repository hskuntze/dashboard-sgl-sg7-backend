package br.mil.eb.dashboard_sgl_sg7.entities.sg7;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "operacoes")
public class Operacoes {

	@Id
	private Long codigo;
	private String operacao;
	private String inicio;
	private String fim;
	private String cidade;
	private String estado;
	private String latitude;
	private String longitude;
	private String conceito;
	@Column(name = "PESSOAL_ENVOLVIDO")
	private Integer pessoalEnvolvido;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "COD_OP", referencedColumnName = "codigo")
    private Set<MaterialOperacao> materiais = new HashSet<>();
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "COD_OP", referencedColumnName = "codigo")
	private Set<MaterialOMOperacao> oms = new HashSet<>();
	
	public Operacoes() {
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFim() {
		return fim;
	}

	public void setFim(String fim) {
		this.fim = fim;
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

	public String getConceito() {
		return conceito;
	}

	public void setConceito(String conceito) {
		this.conceito = conceito;
	}

	public Integer getPessoalEnvolvido() {
		return pessoalEnvolvido;
	}

	public void setPessoalEnvolvido(Integer pessoalEnvolvido) {
		this.pessoalEnvolvido = pessoalEnvolvido;
	}

	public Set<MaterialOperacao> getMateriais() {
		return materiais;
	}

	public Set<MaterialOMOperacao> getOms() {
		return oms;
	}
}