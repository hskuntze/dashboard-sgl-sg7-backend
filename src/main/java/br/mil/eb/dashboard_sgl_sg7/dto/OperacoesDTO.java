package br.mil.eb.dashboard_sgl_sg7.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.mil.eb.dashboard_sgl_sg7.entities.sg7.Operacoes;

public class OperacoesDTO {
	
	private Long codigo;
	private String operacao;
	private String inicio;
	private String fim;
	private String cidade;
	private String estado;
	private String latitude;
	private String longitude;
	private String conceito;
	private Integer pessoalEnvolvido;
	
	private List<MaterialOperacaoDTO> materiais = new ArrayList<>();
	private List<MaterialOMOperacaoDTO> oms = new ArrayList<>();
	
	public OperacoesDTO() {
	}
	
	public OperacoesDTO(Operacoes operacao) {
		this.codigo = operacao.getCodigo();
		this.operacao = operacao.getOperacao();
		this.inicio = operacao.getInicio();
		this.fim = operacao.getFim();
		this.cidade = operacao.getCidade();
		this.estado = operacao.getEstado();
		this.latitude = operacao.getLatitude();
		this.longitude = operacao.getLongitude();
		this.conceito = operacao.getConceito();
		this.pessoalEnvolvido = operacao.getPessoalEnvolvido();
		
		this.materiais = operacao.getMateriais()
				.stream()
				.map(x -> new MaterialOperacaoDTO(x))
				.collect(Collectors.toList());
		
		this.oms = operacao.getOms()
				.stream()
				.map(x -> new MaterialOMOperacaoDTO(x))
				.collect(Collectors.toList());
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getOperacao() {
		return operacao;
	}

	public String getInicio() {
		return inicio;
	}

	public String getFim() {
		return fim;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getConceito() {
		return conceito;
	}

	public Integer getPessoalEnvolvido() {
		return pessoalEnvolvido;
	}

	public List<MaterialOperacaoDTO> getMateriais() {
		return materiais;
	}

	public List<MaterialOMOperacaoDTO> getOms() {
		return oms;
	}
}