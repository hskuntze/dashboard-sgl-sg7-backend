package br.mil.eb.dashboard_sgl_sg7.repositories.sg7;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.mil.eb.dashboard_sgl_sg7.entities.sg7.ExecucaoOrcamentaria;
import br.mil.eb.dashboard_sgl_sg7.projections.RestanteValorAno;
import br.mil.eb.dashboard_sgl_sg7.projections.TipoAcaoValor;
import br.mil.eb.dashboard_sgl_sg7.projections.UnidadeOrcamentaria;

@Repository
public interface ExecucaoOrcamentariaRepository extends JpaRepository<ExecucaoOrcamentaria, Integer> {
	
	@Query(nativeQuery = true, value = "SELECT  "
			+ "    ANO, "
			+ "    SUM(RESTOS_A_PAGAR_A_PAGAR_PROC_E_N_PROC) AS Valor "
			+ "FROM agge_rp_orcamentaria "
			+ "GROUP BY ANO")
	List<RestanteValorAno> getRestanteValorPorAno();

	@Query(nativeQuery = true, value = "SELECT "
			+ "    CASE "
			+ "        WHEN COD_UO = 52121 THEN 'Cmdo Ex' "
			+ "        WHEN COD_UO = 52921 THEN 'F Ex' "
			+ "        ELSE 'Destaque' "
			+ "    END AS `grupoCodUo`, "
			+ "    SUM(`1_PROVISAO_RECEBIDA`) AS `provisaoRecebida`, "
			+ "    SUM(`2_DESPESAS_EMPENHADAS`) AS `despesasEmpenhadas`, "
			+ "    SUM(`3_DESPESAS_LIQUIDADAS`) AS `despesasLiquidadas`, "
			+ "    SUM(`4_DESPESAS_PAGAS`) AS `despesasPagas` "
			+ "FROM `agge_exec_orcamentaria` "
			+ "WHERE COD_ND IN (339015, 339014, 449015) "
			+ "GROUP BY grupoCodUo "
			+ "ORDER BY grupoCodUo")
	List<UnidadeOrcamentaria> getDiariasPorUG();
	
	@Query(nativeQuery = true, value = "SELECT "
			+ "    CASE "
			+ "        WHEN agge_exec_orcamentaria.COD_UO = 52121 THEN 'Cmdo Ex' "
			+ "        WHEN agge_exec_orcamentaria.COD_UO = 52921 THEN 'F Ex' "
			+ "        ELSE 'Destaque' "
			+ "    END AS grupoCodUo, "
			+ "    SUM(`1_PROVISAO_RECEBIDA`) AS `provisaoRecebida`, "
			+ "    SUM(`2_DESPESAS_EMPENHADAS`) AS `despesasEmpenhadas`, "
			+ "    SUM(`3_DESPESAS_LIQUIDADAS`) AS `despesasLiquidadas`, "
			+ "    SUM(`4_DESPESAS_PAGAS`) AS `despesasPagas` "
			+ "FROM `agge_exec_orcamentaria` "
			+ "WHERE COD_ND IN (339033, 449033) "
			+ "GROUP BY 1 "
			+ "ORDER BY `grupoCodUo`")
	List<UnidadeOrcamentaria> getPassagensPorUG();
	
	@Query(nativeQuery = true, value = "SELECT "
			+ "    NOME_UG as grupoCodUo, "
			+ "    SUM(CASE WHEN '1_PROVISAO RECEBIDA' THEN `1_PROVISAO_RECEBIDA` ELSE 0 END) AS `provisaoRecebida`, "
			+ "    SUM(CASE WHEN '2_DESPESAS EMPENHADAS' THEN `2_DESPESAS_EMPENHADAS` ELSE 0 END) AS `despesasEmpenhadas`, "
			+ "    SUM(CASE WHEN '3_DESPESAS LIQUIDADAS' THEN `3_DESPESAS_LIQUIDADAS` ELSE 0 END) AS `despesasLiquidadas`, "
			+ "    SUM(CASE WHEN '4_DESPESAS PAGAS' THEN `4_DESPESAS_PAGAS` ELSE 0 END) AS `despesasPagas` "
			+ "FROM `agge_exec_orcamentaria` "
			+ "GROUP BY `NOME_UG` "
			+ "ORDER BY `NOME_UG`")
	List<UnidadeOrcamentaria> getExecucaoPorUG();
	
	@Query(nativeQuery = true, value = "SELECT  "
			+ "    ELEMENTO_DESPESA as grupoCodUo, "
			+ "    SUM(`1_PROVISAO_RECEBIDA`) AS `provisaoRecebida`, "
			+ "    SUM(`2_DESPESAS_EMPENHADAS`) AS `despesasEmpenhadas`, "
			+ "    SUM(`3_DESPESAS_LIQUIDADAS`) AS `despesasLiquidadas`, "
			+ "    SUM(`4_DESPESAS_PAGAS`) AS `despesasPagas` "
			+ "FROM `agge_exec_orcamentaria` "
			+ "WHERE COD_ND IN (339015, 339033, 339014, 449015, 449033) "
			+ "GROUP BY grupoCodUo "
			+ "ORDER BY grupoCodUo")
	List<UnidadeOrcamentaria> getExecucaoPorElemento();
	
	@Query(nativeQuery = true, value = "SELECT "
			+ "    CASE "
			+ "        WHEN agge_exec_orcamentaria.COD_UO = 52121 THEN 'Cmdo Ex' "
			+ "        WHEN agge_exec_orcamentaria.COD_UO = 52921 THEN 'F Ex' "
			+ "        ELSE 'Destaque' "
			+ "    END AS grupoCodUo, "
			+ "    SUM(`1_PROVISAO_RECEBIDA`) AS `provisaoRecebida`, "
			+ "    SUM(`2_DESPESAS_EMPENHADAS`) AS `despesasEmpenhadas`, "
			+ "    SUM(`3_DESPESAS_LIQUIDADAS`) AS `despesasLiquidadas`, "
			+ "    SUM(`4_DESPESAS_PAGAS`) AS `despesasPagas` "
			+ "FROM `agge_exec_orcamentaria` "
			+ "WHERE ANO = 2024 "
			+ "GROUP BY grupoCodUo "
			+ "ORDER BY grupoCodUo")
	List<UnidadeOrcamentaria> getExecucaoOrcamentaria2024();
	
	@Query(nativeQuery = true, value = "SELECT "
			+ "    CASE "
			+ "        WHEN agge_exec_orcamentaria.COD_UO = 52121 THEN 'Cmdo Ex' "
			+ "        WHEN agge_exec_orcamentaria.COD_UO = 52921 THEN 'F Ex' "
			+ "        ELSE 'Destaque' "
			+ "    END AS grupoCodUo, "
			+ "    SUM(`1_PROVISAO_RECEBIDA`) AS `provisaoRecebida`, "
			+ "    SUM(`2_DESPESAS_EMPENHADAS`) AS `despesasEmpenhadas`, "
			+ "    SUM(`3_DESPESAS_LIQUIDADAS`) AS `despesasLiquidadas`, "
			+ "    SUM(`4_DESPESAS_PAGAS`) AS `despesasPagas` "
			+ "FROM `agge_exec_orcamentaria` "
			+ "WHERE ANO = 2025 "
			+ "GROUP BY grupoCodUo "
			+ "ORDER BY grupoCodUo")
	List<UnidadeOrcamentaria> getExecucaoOrcamentaria2025();
	
	@Query(nativeQuery = true, value = "SELECT "
			+ "    CASE  "
			+ "        WHEN agge_exec_orcamentaria.COD_UO = 52121 THEN 'Cmdo Ex' "
			+ "        WHEN agge_exec_orcamentaria.COD_UO = 52921 THEN 'F Ex' "
			+ "        ELSE 'Destaque' "
			+ "    END AS grupoCodUo, "
			+ "    SUM(`1_PROVISAO_RECEBIDA`) AS `provisaoRecebida`, "
			+ "    SUM(`2_DESPESAS_EMPENHADAS`) AS `despesasEmpenhadas`, "
			+ "    SUM(`3_DESPESAS_LIQUIDADAS`) AS `despesasLiquidadas`, "
			+ "    SUM(`4_DESPESAS_PAGAS`) AS `despesasPagas` "
			+ "FROM `agge_exec_orcamentaria` "
			+ "WHERE ANO = 2024 AND COD_AO in ('147F', '15W6', '20XE', '20XJ', '14T5', '21D2') "
			+ "GROUP BY  grupoCodUo "
			+ "ORDER BY  grupoCodUo")
	List<UnidadeOrcamentaria> getExecucaoOrcamentaria2024TipoAcao();
	
	@Query(nativeQuery = true, value = "SELECT "
			+ "    CASE  "
			+ "        WHEN agge_exec_orcamentaria.COD_UO = 52121 THEN 'Cmdo Ex' "
			+ "        WHEN agge_exec_orcamentaria.COD_UO = 52921 THEN 'F Ex' "
			+ "        ELSE 'Destaque' "
			+ "    END AS grupoCodUo, "
			+ "    SUM(`1_PROVISAO_RECEBIDA`) AS `provisaoRecebida`, "
			+ "    SUM(`2_DESPESAS_EMPENHADAS`) AS `despesasEmpenhadas`, "
			+ "    SUM(`3_DESPESAS_LIQUIDADAS`) AS `despesasLiquidadas`, "
			+ "    SUM(`4_DESPESAS_PAGAS`) AS `despesasPagas` "
			+ "FROM `agge_exec_orcamentaria` "
			+ "WHERE ANO = 2025 AND COD_AO in ('147F', '15W6', '20XE', '20XJ', '14T5', '21D2') "
			+ "GROUP BY  grupoCodUo "
			+ "ORDER BY  grupoCodUo")
	List<UnidadeOrcamentaria> getExecucaoOrcamentaria2025TipoAcao();
	
	@Query(nativeQuery = true, value = "SELECT  "
			+ "    COD_ACAO AS tipo, "
			+ "    SUM(RESTOS_A_PAGAR_A_PAGAR_PROC_E_N_PROC) AS valor "
			+ "FROM agge_rp_orcamentaria "
			+ "WHERE COD_ACAO IN ('14T5', '147F', '20XE') "
			+ "GROUP BY tipo")
	List<TipoAcaoValor> getExecucaoTipoDeAcao();
}
