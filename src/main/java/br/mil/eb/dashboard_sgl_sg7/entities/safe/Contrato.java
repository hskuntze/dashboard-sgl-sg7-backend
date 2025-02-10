package br.mil.eb.dashboard_sgl_sg7.entities.safe;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "safe.contratos")
public class Contrato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private int companyId;
    private int cardId;
    private int documentId;
    private int version;
    private String tableId;
    private Date anonymizationDate;
    private Integer anonymizationUserId;
    private String dsDescricaoRegistro;
    private String cbContratoAtivo;
    private String cdRegistro;
    private String nmContrato;
    private String cdContrato;
    private String nmContratada;
    private String dsCnpjContratada;
    private String nmContratante;
    private String idContratante;
    private String nmGestorContrato;
    private String idGestorContrato;
    private String mailGestorContrato;
    private String dtInicioVigencia;
    private String dtFimVigencia;
    private String dtInicioReal;
    private String dtEncerramentoReal;
    private String cbContratoDefesa;
    private String cbTipoContrato;
    private String nmFase;
    private String idFase;
    private String cbSituacao;
    private String nmRepresentantesContrato;
    private String idRepresentantesContrato;
    private String nmGrupoApoiadores;
    private String numIdGrupoApoiadores;
    private String cbUsuarioFluig;
    private String nmPrepostoAdicional;
    private String nmPreposto;
    private String idPreposto;
    private String vlCpfPreposto;
    private String dsEmailPreposto;
    private String vlTelefonePreposto;
    private String vlRgPreposto;
    private String dsObjetoContrato;
    private String hiddenDsObjetoContrato;
    private String cbModalidadeContratacao;
    private String idModalidadeContratacao;
    private String vlNumeroIdContratacao;
    private String tipoContratoOutros;
    private String vlTotalContrato;
    private String vlEmpenhado;
    private String idPastaRaiz;
    private String nmPastaRaiz;
    private String hiddenLinkRaiz;
    private String tpVersionamentoContrato;
    private String versaoContrato;
    private String acaoVersaoContrato;
    private String controleAcao;
    private String nmUsuarioVersao;
    private String cdUsuarioVersao;
    private String dsVersaoContrato;
    private String camposTimeline;
    private String nmSituacao;
    private String descIncoterms;
    private String descMoeda;
    private String dtContratoCambio;
    private String idContratoCambio;
    private String cotacaoCambio;
    private String valorMoedaEstrangeira;
    private String naturezaContrato;
    private String nmPrograma;
    private String selGrauPrioridade;

    public Contrato() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public Date getAnonymizationDate() {
		return anonymizationDate;
	}

	public void setAnonymizationDate(Date anonymizationDate) {
		this.anonymizationDate = anonymizationDate;
	}

	public Integer getAnonymizationUserId() {
		return anonymizationUserId;
	}

	public void setAnonymizationUserId(Integer anonymizationUserId) {
		this.anonymizationUserId = anonymizationUserId;
	}

	public String getDsDescricaoRegistro() {
		return dsDescricaoRegistro;
	}

	public void setDsDescricaoRegistro(String dsDescricaoRegistro) {
		this.dsDescricaoRegistro = dsDescricaoRegistro;
	}

	public String getCbContratoAtivo() {
		return cbContratoAtivo;
	}

	public void setCbContratoAtivo(String cbContratoAtivo) {
		this.cbContratoAtivo = cbContratoAtivo;
	}

	public String getCdRegistro() {
		return cdRegistro;
	}

	public void setCdRegistro(String cdRegistro) {
		this.cdRegistro = cdRegistro;
	}

	public String getNmContrato() {
		return nmContrato;
	}

	public void setNmContrato(String nmContrato) {
		this.nmContrato = nmContrato;
	}

	public String getCdContrato() {
		return cdContrato;
	}

	public void setCdContrato(String cdContrato) {
		this.cdContrato = cdContrato;
	}

	public String getNmContratada() {
		return nmContratada;
	}

	public void setNmContratada(String nmContratada) {
		this.nmContratada = nmContratada;
	}

	public String getDsCnpjContratada() {
		return dsCnpjContratada;
	}

	public void setDsCnpjContratada(String dsCnpjContratada) {
		this.dsCnpjContratada = dsCnpjContratada;
	}

	public String getNmContratante() {
		return nmContratante;
	}

	public void setNmContratante(String nmContratante) {
		this.nmContratante = nmContratante;
	}

	public String getIdContratante() {
		return idContratante;
	}

	public void setIdContratante(String idContratante) {
		this.idContratante = idContratante;
	}

	public String getNmGestorContrato() {
		return nmGestorContrato;
	}

	public void setNmGestorContrato(String nmGestorContrato) {
		this.nmGestorContrato = nmGestorContrato;
	}

	public String getIdGestorContrato() {
		return idGestorContrato;
	}

	public void setIdGestorContrato(String idGestorContrato) {
		this.idGestorContrato = idGestorContrato;
	}

	public String getMailGestorContrato() {
		return mailGestorContrato;
	}

	public void setMailGestorContrato(String mailGestorContrato) {
		this.mailGestorContrato = mailGestorContrato;
	}

	public String getDtInicioVigencia() {
		return dtInicioVigencia;
	}

	public void setDtInicioVigencia(String dtInicioVigencia) {
		this.dtInicioVigencia = dtInicioVigencia;
	}

	public String getDtFimVigencia() {
		return dtFimVigencia;
	}

	public void setDtFimVigencia(String dtFimVigencia) {
		this.dtFimVigencia = dtFimVigencia;
	}

	public String getDtInicioReal() {
		return dtInicioReal;
	}

	public void setDtInicioReal(String dtInicioReal) {
		this.dtInicioReal = dtInicioReal;
	}

	public String getDtEncerramentoReal() {
		return dtEncerramentoReal;
	}

	public void setDtEncerramentoReal(String dtEncerramentoReal) {
		this.dtEncerramentoReal = dtEncerramentoReal;
	}

	public String getCbContratoDefesa() {
		return cbContratoDefesa;
	}

	public void setCbContratoDefesa(String cbContratoDefesa) {
		this.cbContratoDefesa = cbContratoDefesa;
	}

	public String getCbTipoContrato() {
		return cbTipoContrato;
	}

	public void setCbTipoContrato(String cbTipoContrato) {
		this.cbTipoContrato = cbTipoContrato;
	}

	public String getNmFase() {
		return nmFase;
	}

	public void setNmFase(String nmFase) {
		this.nmFase = nmFase;
	}

	public String getIdFase() {
		return idFase;
	}

	public void setIdFase(String idFase) {
		this.idFase = idFase;
	}

	public String getCbSituacao() {
		return cbSituacao;
	}

	public void setCbSituacao(String cbSituacao) {
		this.cbSituacao = cbSituacao;
	}

	public String getNmRepresentantesContrato() {
		return nmRepresentantesContrato;
	}

	public void setNmRepresentantesContrato(String nmRepresentantesContrato) {
		this.nmRepresentantesContrato = nmRepresentantesContrato;
	}

	public String getIdRepresentantesContrato() {
		return idRepresentantesContrato;
	}

	public void setIdRepresentantesContrato(String idRepresentantesContrato) {
		this.idRepresentantesContrato = idRepresentantesContrato;
	}

	public String getNmGrupoApoiadores() {
		return nmGrupoApoiadores;
	}

	public void setNmGrupoApoiadores(String nmGrupoApoiadores) {
		this.nmGrupoApoiadores = nmGrupoApoiadores;
	}

	public String getNumIdGrupoApoiadores() {
		return numIdGrupoApoiadores;
	}

	public void setNumIdGrupoApoiadores(String numIdGrupoApoiadores) {
		this.numIdGrupoApoiadores = numIdGrupoApoiadores;
	}

	public String getCbUsuarioFluig() {
		return cbUsuarioFluig;
	}

	public void setCbUsuarioFluig(String cbUsuarioFluig) {
		this.cbUsuarioFluig = cbUsuarioFluig;
	}

	public String getNmPrepostoAdicional() {
		return nmPrepostoAdicional;
	}

	public void setNmPrepostoAdicional(String nmPrepostoAdicional) {
		this.nmPrepostoAdicional = nmPrepostoAdicional;
	}

	public String getNmPreposto() {
		return nmPreposto;
	}

	public void setNmPreposto(String nmPreposto) {
		this.nmPreposto = nmPreposto;
	}

	public String getIdPreposto() {
		return idPreposto;
	}

	public void setIdPreposto(String idPreposto) {
		this.idPreposto = idPreposto;
	}

	public String getVlCpfPreposto() {
		return vlCpfPreposto;
	}

	public void setVlCpfPreposto(String vlCpfPreposto) {
		this.vlCpfPreposto = vlCpfPreposto;
	}

	public String getDsEmailPreposto() {
		return dsEmailPreposto;
	}

	public void setDsEmailPreposto(String dsEmailPreposto) {
		this.dsEmailPreposto = dsEmailPreposto;
	}

	public String getVlTelefonePreposto() {
		return vlTelefonePreposto;
	}

	public void setVlTelefonePreposto(String vlTelefonePreposto) {
		this.vlTelefonePreposto = vlTelefonePreposto;
	}

	public String getVlRgPreposto() {
		return vlRgPreposto;
	}

	public void setVlRgPreposto(String vlRgPreposto) {
		this.vlRgPreposto = vlRgPreposto;
	}

	public String getDsObjetoContrato() {
		return dsObjetoContrato;
	}

	public void setDsObjetoContrato(String dsObjetoContrato) {
		this.dsObjetoContrato = dsObjetoContrato;
	}

	public String getHiddenDsObjetoContrato() {
		return hiddenDsObjetoContrato;
	}

	public void setHiddenDsObjetoContrato(String hiddenDsObjetoContrato) {
		this.hiddenDsObjetoContrato = hiddenDsObjetoContrato;
	}

	public String getCbModalidadeContratacao() {
		return cbModalidadeContratacao;
	}

	public void setCbModalidadeContratacao(String cbModalidadeContratacao) {
		this.cbModalidadeContratacao = cbModalidadeContratacao;
	}

	public String getIdModalidadeContratacao() {
		return idModalidadeContratacao;
	}

	public void setIdModalidadeContratacao(String idModalidadeContratacao) {
		this.idModalidadeContratacao = idModalidadeContratacao;
	}

	public String getVlNumeroIdContratacao() {
		return vlNumeroIdContratacao;
	}

	public void setVlNumeroIdContratacao(String vlNumeroIdContratacao) {
		this.vlNumeroIdContratacao = vlNumeroIdContratacao;
	}

	public String getTipoContratoOutros() {
		return tipoContratoOutros;
	}

	public void setTipoContratoOutros(String tipoContratoOutros) {
		this.tipoContratoOutros = tipoContratoOutros;
	}

	public String getVlTotalContrato() {
		return vlTotalContrato;
	}

	public void setVlTotalContrato(String vlTotalContrato) {
		this.vlTotalContrato = vlTotalContrato;
	}

	public String getVlEmpenhado() {
		return vlEmpenhado;
	}

	public void setVlEmpenhado(String vlEmpenhado) {
		this.vlEmpenhado = vlEmpenhado;
	}

	public String getIdPastaRaiz() {
		return idPastaRaiz;
	}

	public void setIdPastaRaiz(String idPastaRaiz) {
		this.idPastaRaiz = idPastaRaiz;
	}

	public String getNmPastaRaiz() {
		return nmPastaRaiz;
	}

	public void setNmPastaRaiz(String nmPastaRaiz) {
		this.nmPastaRaiz = nmPastaRaiz;
	}

	public String getHiddenLinkRaiz() {
		return hiddenLinkRaiz;
	}

	public void setHiddenLinkRaiz(String hiddenLinkRaiz) {
		this.hiddenLinkRaiz = hiddenLinkRaiz;
	}

	public String getTpVersionamentoContrato() {
		return tpVersionamentoContrato;
	}

	public void setTpVersionamentoContrato(String tpVersionamentoContrato) {
		this.tpVersionamentoContrato = tpVersionamentoContrato;
	}

	public String getVersaoContrato() {
		return versaoContrato;
	}

	public void setVersaoContrato(String versaoContrato) {
		this.versaoContrato = versaoContrato;
	}

	public String getAcaoVersaoContrato() {
		return acaoVersaoContrato;
	}

	public void setAcaoVersaoContrato(String acaoVersaoContrato) {
		this.acaoVersaoContrato = acaoVersaoContrato;
	}

	public String getControleAcao() {
		return controleAcao;
	}

	public void setControleAcao(String controleAcao) {
		this.controleAcao = controleAcao;
	}

	public String getNmUsuarioVersao() {
		return nmUsuarioVersao;
	}

	public void setNmUsuarioVersao(String nmUsuarioVersao) {
		this.nmUsuarioVersao = nmUsuarioVersao;
	}

	public String getCdUsuarioVersao() {
		return cdUsuarioVersao;
	}

	public void setCdUsuarioVersao(String cdUsuarioVersao) {
		this.cdUsuarioVersao = cdUsuarioVersao;
	}

	public String getDsVersaoContrato() {
		return dsVersaoContrato;
	}

	public void setDsVersaoContrato(String dsVersaoContrato) {
		this.dsVersaoContrato = dsVersaoContrato;
	}

	public String getCamposTimeline() {
		return camposTimeline;
	}

	public void setCamposTimeline(String camposTimeline) {
		this.camposTimeline = camposTimeline;
	}

	public String getNmSituacao() {
		return nmSituacao;
	}

	public void setNmSituacao(String nmSituacao) {
		this.nmSituacao = nmSituacao;
	}

	public String getDescIncoterms() {
		return descIncoterms;
	}

	public void setDescIncoterms(String descIncoterms) {
		this.descIncoterms = descIncoterms;
	}

	public String getDescMoeda() {
		return descMoeda;
	}

	public void setDescMoeda(String descMoeda) {
		this.descMoeda = descMoeda;
	}

	public String getDtContratoCambio() {
		return dtContratoCambio;
	}

	public void setDtContratoCambio(String dtContratoCambio) {
		this.dtContratoCambio = dtContratoCambio;
	}

	public String getIdContratoCambio() {
		return idContratoCambio;
	}

	public void setIdContratoCambio(String idContratoCambio) {
		this.idContratoCambio = idContratoCambio;
	}

	public String getCotacaoCambio() {
		return cotacaoCambio;
	}

	public void setCotacaoCambio(String cotacaoCambio) {
		this.cotacaoCambio = cotacaoCambio;
	}

	public String getValorMoedaEstrangeira() {
		return valorMoedaEstrangeira;
	}

	public void setValorMoedaEstrangeira(String valorMoedaEstrangeira) {
		this.valorMoedaEstrangeira = valorMoedaEstrangeira;
	}

	public String getNaturezaContrato() {
		return naturezaContrato;
	}

	public void setNaturezaContrato(String naturezaContrato) {
		this.naturezaContrato = naturezaContrato;
	}

	public String getNmPrograma() {
		return nmPrograma;
	}

	public void setNmPrograma(String nmPrograma) {
		this.nmPrograma = nmPrograma;
	}

	public String getSelGrauPrioridade() {
		return selGrauPrioridade;
	}

	public void setSelGrauPrioridade(String selGrauPrioridade) {
		this.selGrauPrioridade = selGrauPrioridade;
	}
}