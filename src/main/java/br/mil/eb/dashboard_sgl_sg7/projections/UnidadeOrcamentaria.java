package br.mil.eb.dashboard_sgl_sg7.projections;

import java.math.BigDecimal;

public interface UnidadeOrcamentaria {

	String getGrupoCodUo();
	BigDecimal getProvisaoRecebida();
	BigDecimal getDespesasEmpenhadas();
	BigDecimal getDespesasLiquidadas();
	BigDecimal getDespesasPagas();
}
