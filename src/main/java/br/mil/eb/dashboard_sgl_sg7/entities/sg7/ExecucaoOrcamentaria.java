package br.mil.eb.dashboard_sgl_sg7.entities.sg7;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "agge_exec_orcamentaria")
public class ExecucaoOrcamentaria {

	@Id
	@Column(name = "CODIGO")
	private Integer codigo;
	@Column(name = "COD_UO")
	private Integer codUo;
	@Column(name = "NOME_UNIDADE_ORCAMENTARIA")
	private String nomeUnidadeOrcamentaria;
	@Column(name = "GRUPO_DESPESA")
	private String grupoDespesa;
	@Column(name = "NOME_DESPESA")
	private String nomeDespesa;
	@Column(name = "1_PROVISAO_RECEBIDA")
	private Double provisaoRecebida;
	@Column(name = "2_DESPESAS_EMPENHADAS")
	private Double despesasEmpenhadas;
	@Column(name = "3_DESPESAS_LIQUIDADAS")
	private Double despesasLiquidas;
	@Column(name = "4_DESPESAS_PAGAS")
	private Double despesasPagas;
	
	public ExecucaoOrcamentaria() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodUo() {
		return codUo;
	}

	public void setCodUo(Integer codUo) {
		this.codUo = codUo;
	}

	public String getNomeUnidadeOrcamentaria() {
		return nomeUnidadeOrcamentaria;
	}

	public void setNomeUnidadeOrcamentaria(String nomeUnidadeOrcamentaria) {
		this.nomeUnidadeOrcamentaria = nomeUnidadeOrcamentaria;
	}

	public String getGrupoDespesa() {
		return grupoDespesa;
	}

	public void setGrupoDespesa(String grupoDespesa) {
		this.grupoDespesa = grupoDespesa;
	}

	public String getNomeDespesa() {
		return nomeDespesa;
	}

	public void setNomeDespesa(String nomeDespesa) {
		this.nomeDespesa = nomeDespesa;
	}

	public Double getProvisaoRecebida() {
		return provisaoRecebida;
	}

	public void setProvisaoRecebida(Double provisaoRecebida) {
		this.provisaoRecebida = provisaoRecebida;
	}

	public Double getDespesasEmpenhadas() {
		return despesasEmpenhadas;
	}

	public void setDespesasEmpenhadas(Double despesasEmpenhadas) {
		this.despesasEmpenhadas = despesasEmpenhadas;
	}

	public Double getDespesasLiquidas() {
		return despesasLiquidas;
	}

	public void setDespesasLiquidas(Double despesasLiquidas) {
		this.despesasLiquidas = despesasLiquidas;
	}

	public Double getDespesasPagas() {
		return despesasPagas;
	}

	public void setDespesasPagas(Double despesasPagas) {
		this.despesasPagas = despesasPagas;
	}

	@Override
	public String toString() {
		return "ExecucaoOrcamentaria [codigo=" + codigo + ", codUo=" + codUo + ", nomeUnidadeOrcamentaria="
				+ nomeUnidadeOrcamentaria + ", grupoDespesa=" + grupoDespesa + ", nomeDespesa=" + nomeDespesa
				+ ", provisaoRecebida=" + provisaoRecebida + ", despesasEmpenhadas=" + despesasEmpenhadas
				+ ", despesasLiquidas=" + despesasLiquidas + ", despesasPagas=" + despesasPagas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExecucaoOrcamentaria other = (ExecucaoOrcamentaria) obj;
		return Objects.equals(codigo, other.codigo);
	}
}
