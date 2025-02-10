package br.mil.eb.dashboard_sgl_sg7.entities.safe;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "safe.etapas")
public class Etapa {


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
    private String cdEtapaAClonar;
    private String zoomEtapa;
    private String cdContrato;
    private String zoomContrato;
    private String zoomFaseIdentifiers;
    private String zoomFaseDescriptions;
    private String zoomFase;
    private String siglaSecao;
    private String zoomSecao;
    private String cdEtapa;
    private String nmEtapa;
    private String matriculaFiscal;
    private String zoomFiscal;
    private String cdIdentificador;
    private String dsSiglaTipoEtapa;
    private String zoomTipoEtapa;
    private String selProgramacao;
    private String cdNaturezaTributaria;
    private String zoomNaturezaTributaria;
    private String metodoAceitacao;
    private String dsDescricao;
    private String selRequisitoExterno;
    private String dtCadastroEtapa;
    private String dtInicioExecucao;
    private String dtApresentacao;
    private String dtApresentacaoRealizado;
    private String dtRecebimento;
    private String consideraValorCaput;
    private String vlEtapa;
    private String aplicaFat;
    private String selProcessoPatrimonio;
    private String situacaoFisica;
    private String idPasta;
    private String zoomPasta;
    private String hiddenLinkRaiz;
    private String justificativa;
    private String vlAprovadoEtapa;
    private String vlSobAnalise;
    private String vlEmMedicao;
    private String vlEmVerificacao;
    private String vlEmLiquidacao;
    private String vlEmPagamento;
    private String vlPago;
    private String versaoEtapa;
    private String acaoVersaoEtapa;
    private String controleAcao;
    private String nmUsuarioVersao;
    private String cdUsuarioVersao;
    private String dsVersaoEtapa;
    private String vlTotalCustoAdm;
    private String camposTimeline;

    public Etapa() {
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

	public String getCdEtapaAClonar() {
		return cdEtapaAClonar;
	}

	public void setCdEtapaAClonar(String cdEtapaAClonar) {
		this.cdEtapaAClonar = cdEtapaAClonar;
	}

	public String getZoomEtapa() {
		return zoomEtapa;
	}

	public void setZoomEtapa(String zoomEtapa) {
		this.zoomEtapa = zoomEtapa;
	}

	public String getCdContrato() {
		return cdContrato;
	}

	public void setCdContrato(String cdContrato) {
		this.cdContrato = cdContrato;
	}

	public String getZoomContrato() {
		return zoomContrato;
	}

	public void setZoomContrato(String zoomContrato) {
		this.zoomContrato = zoomContrato;
	}

	public String getZoomFaseIdentifiers() {
		return zoomFaseIdentifiers;
	}

	public void setZoomFaseIdentifiers(String zoomFaseIdentifiers) {
		this.zoomFaseIdentifiers = zoomFaseIdentifiers;
	}

	public String getZoomFaseDescriptions() {
		return zoomFaseDescriptions;
	}

	public void setZoomFaseDescriptions(String zoomFaseDescriptions) {
		this.zoomFaseDescriptions = zoomFaseDescriptions;
	}

	public String getZoomFase() {
		return zoomFase;
	}

	public void setZoomFase(String zoomFase) {
		this.zoomFase = zoomFase;
	}

	public String getSiglaSecao() {
		return siglaSecao;
	}

	public void setSiglaSecao(String siglaSecao) {
		this.siglaSecao = siglaSecao;
	}

	public String getZoomSecao() {
		return zoomSecao;
	}

	public void setZoomSecao(String zoomSecao) {
		this.zoomSecao = zoomSecao;
	}

	public String getCdEtapa() {
		return cdEtapa;
	}

	public void setCdEtapa(String cdEtapa) {
		this.cdEtapa = cdEtapa;
	}

	public String getNmEtapa() {
		return nmEtapa;
	}

	public void setNmEtapa(String nmEtapa) {
		this.nmEtapa = nmEtapa;
	}

	public String getMatriculaFiscal() {
		return matriculaFiscal;
	}

	public void setMatriculaFiscal(String matriculaFiscal) {
		this.matriculaFiscal = matriculaFiscal;
	}

	public String getZoomFiscal() {
		return zoomFiscal;
	}

	public void setZoomFiscal(String zoomFiscal) {
		this.zoomFiscal = zoomFiscal;
	}

	public String getCdIdentificador() {
		return cdIdentificador;
	}

	public void setCdIdentificador(String cdIdentificador) {
		this.cdIdentificador = cdIdentificador;
	}

	public String getDsSiglaTipoEtapa() {
		return dsSiglaTipoEtapa;
	}

	public void setDsSiglaTipoEtapa(String dsSiglaTipoEtapa) {
		this.dsSiglaTipoEtapa = dsSiglaTipoEtapa;
	}

	public String getZoomTipoEtapa() {
		return zoomTipoEtapa;
	}

	public void setZoomTipoEtapa(String zoomTipoEtapa) {
		this.zoomTipoEtapa = zoomTipoEtapa;
	}

	public String getSelProgramacao() {
		return selProgramacao;
	}

	public void setSelProgramacao(String selProgramacao) {
		this.selProgramacao = selProgramacao;
	}

	public String getCdNaturezaTributaria() {
		return cdNaturezaTributaria;
	}

	public void setCdNaturezaTributaria(String cdNaturezaTributaria) {
		this.cdNaturezaTributaria = cdNaturezaTributaria;
	}

	public String getZoomNaturezaTributaria() {
		return zoomNaturezaTributaria;
	}

	public void setZoomNaturezaTributaria(String zoomNaturezaTributaria) {
		this.zoomNaturezaTributaria = zoomNaturezaTributaria;
	}

	public String getMetodoAceitacao() {
		return metodoAceitacao;
	}

	public void setMetodoAceitacao(String metodoAceitacao) {
		this.metodoAceitacao = metodoAceitacao;
	}

	public String getDsDescricao() {
		return dsDescricao;
	}

	public void setDsDescricao(String dsDescricao) {
		this.dsDescricao = dsDescricao;
	}

	public String getSelRequisitoExterno() {
		return selRequisitoExterno;
	}

	public void setSelRequisitoExterno(String selRequisitoExterno) {
		this.selRequisitoExterno = selRequisitoExterno;
	}

	public String getDtCadastroEtapa() {
		return dtCadastroEtapa;
	}

	public void setDtCadastroEtapa(String dtCadastroEtapa) {
		this.dtCadastroEtapa = dtCadastroEtapa;
	}

	public String getDtInicioExecucao() {
		return dtInicioExecucao;
	}

	public void setDtInicioExecucao(String dtInicioExecucao) {
		this.dtInicioExecucao = dtInicioExecucao;
	}

	public String getDtApresentacao() {
		return dtApresentacao;
	}

	public void setDtApresentacao(String dtApresentacao) {
		this.dtApresentacao = dtApresentacao;
	}

	public String getDtApresentacaoRealizado() {
		return dtApresentacaoRealizado;
	}

	public void setDtApresentacaoRealizado(String dtApresentacaoRealizado) {
		this.dtApresentacaoRealizado = dtApresentacaoRealizado;
	}

	public String getDtRecebimento() {
		return dtRecebimento;
	}

	public void setDtRecebimento(String dtRecebimento) {
		this.dtRecebimento = dtRecebimento;
	}

	public String getConsideraValorCaput() {
		return consideraValorCaput;
	}

	public void setConsideraValorCaput(String consideraValorCaput) {
		this.consideraValorCaput = consideraValorCaput;
	}

	public String getVlEtapa() {
		return vlEtapa;
	}

	public void setVlEtapa(String vlEtapa) {
		this.vlEtapa = vlEtapa;
	}

	public String getAplicaFat() {
		return aplicaFat;
	}

	public void setAplicaFat(String aplicaFat) {
		this.aplicaFat = aplicaFat;
	}

	public String getSelProcessoPatrimonio() {
		return selProcessoPatrimonio;
	}

	public void setSelProcessoPatrimonio(String selProcessoPatrimonio) {
		this.selProcessoPatrimonio = selProcessoPatrimonio;
	}

	public String getSituacaoFisica() {
		return situacaoFisica;
	}

	public void setSituacaoFisica(String situacaoFisica) {
		this.situacaoFisica = situacaoFisica;
	}

	public String getIdPasta() {
		return idPasta;
	}

	public void setIdPasta(String idPasta) {
		this.idPasta = idPasta;
	}

	public String getZoomPasta() {
		return zoomPasta;
	}

	public void setZoomPasta(String zoomPasta) {
		this.zoomPasta = zoomPasta;
	}

	public String getHiddenLinkRaiz() {
		return hiddenLinkRaiz;
	}

	public void setHiddenLinkRaiz(String hiddenLinkRaiz) {
		this.hiddenLinkRaiz = hiddenLinkRaiz;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public String getVlAprovadoEtapa() {
		return vlAprovadoEtapa;
	}

	public void setVlAprovadoEtapa(String vlAprovadoEtapa) {
		this.vlAprovadoEtapa = vlAprovadoEtapa;
	}

	public String getVlSobAnalise() {
		return vlSobAnalise;
	}

	public void setVlSobAnalise(String vlSobAnalise) {
		this.vlSobAnalise = vlSobAnalise;
	}

	public String getVlEmMedicao() {
		return vlEmMedicao;
	}

	public void setVlEmMedicao(String vlEmMedicao) {
		this.vlEmMedicao = vlEmMedicao;
	}

	public String getVlEmVerificacao() {
		return vlEmVerificacao;
	}

	public void setVlEmVerificacao(String vlEmVerificacao) {
		this.vlEmVerificacao = vlEmVerificacao;
	}

	public String getVlEmLiquidacao() {
		return vlEmLiquidacao;
	}

	public void setVlEmLiquidacao(String vlEmLiquidacao) {
		this.vlEmLiquidacao = vlEmLiquidacao;
	}

	public String getVlEmPagamento() {
		return vlEmPagamento;
	}

	public void setVlEmPagamento(String vlEmPagamento) {
		this.vlEmPagamento = vlEmPagamento;
	}

	public String getVlPago() {
		return vlPago;
	}

	public void setVlPago(String vlPago) {
		this.vlPago = vlPago;
	}

	public String getVersaoEtapa() {
		return versaoEtapa;
	}

	public void setVersaoEtapa(String versaoEtapa) {
		this.versaoEtapa = versaoEtapa;
	}

	public String getAcaoVersaoEtapa() {
		return acaoVersaoEtapa;
	}

	public void setAcaoVersaoEtapa(String acaoVersaoEtapa) {
		this.acaoVersaoEtapa = acaoVersaoEtapa;
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

	public String getDsVersaoEtapa() {
		return dsVersaoEtapa;
	}

	public void setDsVersaoEtapa(String dsVersaoEtapa) {
		this.dsVersaoEtapa = dsVersaoEtapa;
	}

	public String getVlTotalCustoAdm() {
		return vlTotalCustoAdm;
	}

	public void setVlTotalCustoAdm(String vlTotalCustoAdm) {
		this.vlTotalCustoAdm = vlTotalCustoAdm;
	}

	public String getCamposTimeline() {
		return camposTimeline;
	}

	public void setCamposTimeline(String camposTimeline) {
		this.camposTimeline = camposTimeline;
	}
}