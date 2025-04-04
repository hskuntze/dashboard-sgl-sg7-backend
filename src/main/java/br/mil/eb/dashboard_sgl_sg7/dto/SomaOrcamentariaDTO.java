package br.mil.eb.dashboard_sgl_sg7.dto;

import java.math.BigDecimal;

public class SomaOrcamentariaDTO {

	private BigDecimal provisaoRecebida;
	private BigDecimal despesasEmpenhadas;
	private BigDecimal despesasLiquidadas;
	private BigDecimal despesasPagas;
	
	public SomaOrcamentariaDTO() {
	}

	public SomaOrcamentariaDTO(BigDecimal provisaoRecebida, BigDecimal despesasEmpenhadas, BigDecimal despesasLiquidadas, BigDecimal despesasPagas) {
		this.provisaoRecebida = provisaoRecebida;
		this.despesasEmpenhadas = despesasEmpenhadas;
		this.despesasLiquidadas = despesasLiquidadas;
		this.despesasPagas = despesasPagas;
	}

	public BigDecimal getProvisaoRecebida() {
		return provisaoRecebida;
	}

	public BigDecimal getDespesasEmpenhadas() {
		return despesasEmpenhadas;
	}
	
	public BigDecimal getDespesasLiquidadas() {
		return despesasLiquidadas;
	}

	public BigDecimal getDespesasPagas() {
		return despesasPagas;
	}
}
