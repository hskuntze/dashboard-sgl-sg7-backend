package br.mil.eb.dashboard_sgl_sg7.repositories.sg7;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.mil.eb.dashboard_sgl_sg7.entities.sg7.MaterialOM;
import br.mil.eb.dashboard_sgl_sg7.projections.CategoraMaterialIndisponivel;
import br.mil.eb.dashboard_sgl_sg7.projections.GeorefenciamentoUnidades;
import br.mil.eb.dashboard_sgl_sg7.projections.GeoreferenciamentoCmdo;
import br.mil.eb.dashboard_sgl_sg7.projections.QtdMaterialBDA;
import br.mil.eb.dashboard_sgl_sg7.projections.QtdMaterialCidadeEstado;
import br.mil.eb.dashboard_sgl_sg7.projections.QtdMaterialRM;
import br.mil.eb.dashboard_sgl_sg7.projections.QtdMaterialTipoEqp;
import br.mil.eb.dashboard_sgl_sg7.projections.ValorTotalClassificacaoDiariasPassagens;
import br.mil.eb.dashboard_sgl_sg7.projections.ValorTotalCodAODiariasPassagens;

@Repository
public interface MaterialOMRepository extends JpaRepository<MaterialOM, String>{
	
	@Query("SELECT DISTINCT m FROM MaterialOM m WHERE m.sn = :sn")
	Optional<MaterialOM> getMaterialBySn(String sn);
	
	@Query("SELECT DISTINCT m FROM MaterialOM m "
			+ "WHERE (m.disponibilidade = 'Indisponível' OR m.disponibilidade = 'Disponível') "
			+ "AND (LOWER (m.equipamento) LIKE LOWER(CONCAT('%', :equipamento, '%'))) "
			+ "AND (LOWER (m.pn) LIKE LOWER(CONCAT('%', :pn, '%'))) "
			+ "AND (LOWER (m.sn) LIKE LOWER(CONCAT('%', :sn, '%'))) "
			+ "AND (LOWER (m.cmdoOds) LIKE LOWER(CONCAT('%', :cmdo, '%'))) "
			+ "GROUP BY m.sn")
	Page<MaterialOM> findAllMaterial(Pageable pageable, String equipamento, String pn, String sn, String cmdo);

	@Query("SELECT DISTINCT m FROM MaterialOM m "
			+ "WHERE m.disponibilidade = 'Disponível' "
			+ "AND (LOWER (m.equipamento) LIKE LOWER(CONCAT('%', :equipamento, '%'))) "
			+ "AND (LOWER (m.pn) LIKE LOWER(CONCAT('%', :pn, '%'))) "
			+ "AND (LOWER (m.sn) LIKE LOWER(CONCAT('%', :sn, '%'))) "
			+ "GROUP BY m.sn")
	Page<MaterialOM> findMaterialDisponivel(Pageable pageable, String equipamento, String pn, String sn);

	@Query("SELECT DISTINCT m FROM MaterialOM m "
			+ "WHERE m.disponibilidade = 'Indisponível' "
			+ "AND (LOWER (m.equipamento) LIKE LOWER(CONCAT('%', :equipamento, '%'))) "
			+ "AND (LOWER (m.pn) LIKE LOWER(CONCAT('%', :pn, '%'))) "
			+ "AND (LOWER (m.sn) LIKE LOWER(CONCAT('%', :sn, '%'))) "
			+ "GROUP BY m.sn")
	Page<MaterialOM> findMaterialIndisponivel(Pageable pageable, String equipamento, String pn, String sn);
	
	@Query(value = "SELECT SUM(contador) FROM ("
		     + "SELECT COUNT(DISTINCT m.sn) AS contador FROM sg7.view_material_georef m GROUP BY m.disponibilidade"
		     + ") AS subquery", 
		     nativeQuery = true)
	Integer getQuantidadeTotalMaterial();
	
	@Query(value = "SELECT SUM(contador) "
			+ "FROM ("
			+ "    SELECT COUNT(DISTINCT m.sn) AS contador, m.ESTADO "
			+ "    FROM sg7.view_material_georef m "
			+ "    GROUP BY m.disponibilidade, m.ESTADO "
			+ ") AS subquery "
			+ "WHERE ESTADO = :uf "
			+ "   OR ESTADO = :uf", nativeQuery = true)
	Integer getQuantidadeTotalMaterialPorUf(String uf);
	
	@Query(value = "SELECT "
			+ "    ESTADO AS CIDADEESTADO, "
			+ "    COUNT(DISTINCT SN) AS 'Quantidade' "
			+ "FROM sg7.view_material_georef "
			+ "WHERE ESTADO <> '' "
			+ "AND ESTADO IS NOT NULL "
			+ "AND CMDO_ODS = :cmdo "
			+ "GROUP BY CIDADEESTADO "
			+ "ORDER BY Quantidade DESC", nativeQuery = true)
	List<QtdMaterialCidadeEstado> getQuantidadeUfPorCmdo(String cmdo);
	
	@Query("SELECT DISTINCT m.cmdoOds, COUNT(DISTINCT m.sn) "
	        + "FROM MaterialOM m "
	        + "GROUP BY m.cmdoOds "
	        + "ORDER BY COUNT(m.sn) DESC")
	List<Object[]> getQuantidadeMaterialCmdo();

	@Query("SELECT "
	       + "(CASE "
	       + "   WHEN m.bda = 'Vinculação direta ao CMDO' THEN 'Vinculação direta' "
	       + "   ELSE m.bda "
	       + "END), "
	       + "COUNT(DISTINCT m.sn) "
	       + "FROM MaterialOM m "
	       + "GROUP BY "
	       + "(CASE "
	       + "   WHEN m.bda = 'Vinculação direta ao CMDO' THEN 'Vinculação direta' "
	       + "   ELSE m.bda "
	       + "END)")
	List<Object[]> getQuantidadeMaterialBda();
	
	@Query(value = "SELECT "
		       + "(CASE "
		       + "   WHEN m.bda = 'Vinculação direta ao CMDO' THEN 'Vinculação direta' "
		       + "   ELSE m.bda "
		       + "END) AS 'Bda' , "
		       + "COUNT(DISTINCT m.sn) AS 'Quantidade' "
		       + "FROM sg7.view_material_georef m "
		       + "WHERE m.CMDO_ODS = :cmdo "
		       + "GROUP BY Bda", nativeQuery = true)
	List<QtdMaterialBDA> getQuantidadeMaterialBdaPorCmdo(String cmdo);
	
	@Query("SELECT m.disponibilidade, COUNT(DISTINCT m.sn) "
	        + "FROM MaterialOM m "
	        + "GROUP BY m.disponibilidade")
	List<Object[]> getQuantidadeMaterialDisponibilidade();

	@Query("SELECT m.rm, COUNT(DISTINCT m.sn) "
	        + "FROM MaterialOM m "
	        + "GROUP BY m.rm")
	List<Object[]> getQuantidadeMaterialRm();
	
	@Query(value = "SELECT RM, COUNT(DISTINCT SN) AS 'Quantidade' "
			+ "FROM sg7.view_material_georef "
			+ "WHERE CMDO_ODS = :cmdo "
			+ "GROUP BY RM", nativeQuery = true)
	List<QtdMaterialRM> getQuantidadeMaterialRmPorCmdo(String cmdo);
	
	@Query("SELECT m.estado, COUNT(DISTINCT m.sn) "
	        + "FROM MaterialOM m "
	        + "WHERE m.estado IS NOT NULL AND m.estado <> '' "
	        + "GROUP BY m.estado "
	        + "ORDER BY COUNT(m) DESC")
	List<Object[]> getQuantidadeMaterialCidadeEstado();
	
	@Query("SELECT m.bda, COUNT(DISTINCT m.sn) "
			+ "FROM MaterialOM m "
			+ "WHERE m.disponibilidade = 'Indisponível' "
			+ "GROUP BY m.bda "
			+ "ORDER BY COUNT(m.disponibilidade) DESC")
	List<Object[]> getQuantidadeIndisponivelPorBDA();
	
	@Query(value = "SELECT m.bda AS 'Bda', COUNT(DISTINCT m.sn) AS 'Quantidade' "
			+ "FROM sg7.view_material_georef m "
			+ "WHERE m.disponibilidade = 'Indisponível' "
			+ "AND m.cmdo_ods = :cmdo "
			+ "GROUP BY m.bda "
			+ "ORDER BY COUNT(m.disponibilidade) DESC", nativeQuery = true)
	List<QtdMaterialBDA> getQuantidadeIndisponivelPorBDAPorCmdo(String cmdo);
	
	@Query(nativeQuery = true, value = "SELECT "
			+ "    CASE "
			+ "        WHEN EQUIPAMENTO LIKE '%CONJUNTO RÁDIO%' THEN 'CONJUNTO RÁDIO' "
			+ "        WHEN EQUIPAMENTO LIKE '%CONJUNTO RADIO%' THEN 'CONJUNTO RÁDIO' "
			+ "        WHEN EQUIPAMENTO = 'BATERIA PARA RÁDIO' THEN 'BATERIA' "
			+ "        WHEN EQUIPAMENTO = 'BATERIA PARA RECEPTOR' THEN 'BATERIA' "
			+ "        WHEN EQUIPAMENTO = 'BATERIA PARA DVR' THEN 'BATERIA' "
			+ "        WHEN EQUIPAMENTO LIKE '%RECEPTOR%' THEN 'RECEPTOR' "
			+ "        WHEN EQUIPAMENTO LIKE '%TELEFONE%' THEN 'TELEFONE' "
			+ "        WHEN EQUIPAMENTO LIKE '%ANTENA%' THEN 'ANTENA' "
			+ "        WHEN EQUIPAMENTO LIKE '%FONE DE OUVIDO%' THEN 'FONE DE OUVIDO' "
			+ "        WHEN EQUIPAMENTO LIKE '%ESTAÇÃO DE TRABALHO%' THEN 'ESTAÇÃO DE TRABALHO' "
			+ "        WHEN EQUIPAMENTO = 'CARREGADOR DE BATERIA' THEN 'CARREGADOR DE BATERIA' "
			+ "        WHEN EQUIPAMENTO = 'CARREGADOR DE BATERIA PARA RÁDIO' THEN 'CARREGADOR DE BATERIA' "
			+ "        WHEN EQUIPAMENTO = 'Carregador de Bateria de Falcon III com 2 Baias' THEN 'CARREGADOR DE BATERIA' "
			+ "        ELSE 'OUTROS' "
			+ "    END AS Categoria, "
			+ "    COUNT(DISTINCT SN) AS Quantidade "
			+ "FROM sg7.view_material_georef "
			+ "WHERE DISPONIBILIDADE = 'Indisponível' "
			+ "GROUP BY Categoria "
			+ "ORDER BY Quantidade DESC")
	List<CategoraMaterialIndisponivel> getCategoriaMateriaisIndisponiveis();
	
	@Query(nativeQuery = true, value = "SELECT "
			+ "    CASE "
			+ "        WHEN EQUIPAMENTO LIKE '%CONJUNTO RÁDIO%' THEN 'CONJUNTO RÁDIO' "
			+ "        WHEN EQUIPAMENTO LIKE '%CONJUNTO RADIO%' THEN 'CONJUNTO RÁDIO' "
			+ "        WHEN EQUIPAMENTO = 'BATERIA PARA RÁDIO' THEN 'BATERIA' "
			+ "        WHEN EQUIPAMENTO = 'BATERIA PARA RECEPTOR' THEN 'BATERIA' "
			+ "        WHEN EQUIPAMENTO = 'BATERIA PARA DVR' THEN 'BATERIA' "
			+ "        WHEN EQUIPAMENTO LIKE '%RECEPTOR%' THEN 'RECEPTOR' "
			+ "        WHEN EQUIPAMENTO LIKE '%TELEFONE%' THEN 'TELEFONE' "
			+ "        WHEN EQUIPAMENTO LIKE '%ANTENA%' THEN 'ANTENA' "
			+ "        WHEN EQUIPAMENTO LIKE '%FONE DE OUVIDO%' THEN 'FONE DE OUVIDO' "
			+ "        WHEN EQUIPAMENTO LIKE '%ESTAÇÃO DE TRABALHO%' THEN 'ESTAÇÃO DE TRABALHO' "
			+ "        WHEN EQUIPAMENTO = 'CARREGADOR DE BATERIA' THEN 'CARREGADOR DE BATERIA' "
			+ "        WHEN EQUIPAMENTO = 'CARREGADOR DE BATERIA PARA RÁDIO' THEN 'CARREGADOR DE BATERIA' "
			+ "        WHEN EQUIPAMENTO = 'Carregador de Bateria de Falcon III com 2 Baias' THEN 'CARREGADOR DE BATERIA' "
			+ "        ELSE 'OUTROS' "
			+ "    END AS Categoria, "
			+ "    COUNT(DISTINCT SN) AS Quantidade "
			+ "FROM sg7.view_material_georef "
			+ "WHERE DISPONIBILIDADE = 'Indisponível' "
			+ "AND CMDO_ODS = :cmdo "
			+ "GROUP BY Categoria "
			+ "ORDER BY Quantidade DESC")
	List<CategoraMaterialIndisponivel> getCategoriaMateriaisIndisponiveisPorCmdo(String cmdo);
	
	@Query(nativeQuery = true, value = "SELECT DISTINCT(LATITUDE), "
			+ "EQUIPAMENTO, "
			+ "LONGITUDE, "
			+ "OM, "
			+ "BDA, "
			+ "RM, "
			+ "CMDO_ODS, "
			+ "CIDADE, "
			+ "ESTADO "
			+ "FROM sg7.view_material_georef")
	List<GeorefenciamentoUnidades> getGeorefUnidades();
	
	@Query(nativeQuery = true, value = "SELECT DISTINCT(LATITUDE), "
			+ "EQUIPAMENTO, "
			+ "LONGITUDE, "
			+ "OM, "
			+ "BDA, "
			+ "RM, "
			+ "CMDO_ODS, "
			+ "CIDADE, "
			+ "ESTADO "
			+ "FROM sg7.view_material_georef "
			+ "WHERE CMDO_ODS = :cmdo")
	List<GeorefenciamentoUnidades> getGeorefUnidadesPorCmdo(String cmdo);
	
	@Query(nativeQuery = true, value = "SELECT DISTINCT(CMDO_ODS) AS CMDOODS, "
			+ "	LONGITUDE, "
			+ "	LATITUDE, "
			+ "    COUNT(DISTINCT SN) AS 'QUANTIDADE'"
			+ "FROM sg7.view_material_georef "
			+ "WHERE CMDO_ODS IN ('CMS', 'CMSE', 'CMP', 'CMO', 'CMN', 'CMNE', 'CML', 'CMA') "
			+ "GROUP BY CMDO_ODS "
			+ "ORDER BY QUANTIDADE")
	List<GeoreferenciamentoCmdo> getGeorefCmdo();
	
	@Query(nativeQuery = true, value = "SELECT DISTINCT(CMDO_ODS) AS CMDOODS, "
			+ "	LONGITUDE, "
			+ "	LATITUDE, "
			+ "    COUNT(DISTINCT SN) AS 'QUANTIDADE'"
			+ "FROM sg7.view_material_georef "
			+ "WHERE CMDO_ODS = :cmdo "
			+ "GROUP BY CMDO_ODS "
			+ "ORDER BY QUANTIDADE")
	List<GeoreferenciamentoCmdo> getQtdGeorefPorCmdo(String cmdo);
	
	@Query("SELECT m.subsistema, COUNT(DISTINCT m.sn) "
			+ "FROM MaterialOM m "
			+ "WHERE m.subsistema IN ('CTC', 'SAT', 'TAT') "
			+ "GROUP BY m.subsistema")
	List<Object[]> getQuantidadeMaterialSubsistema();
	
	@Query("SELECT m.subsistema, COUNT(DISTINCT m.sn) "
			+ "FROM MaterialOM m "
			+ "WHERE m.subsistema IN ('CTC', 'SAT', 'TAT') "
			+ "AND m.cmdoOds = :cmdo "
			+ "GROUP BY m.subsistema")
	List<Object[]> getQuantidadeMaterialSubsistemaPorCmdo(String cmdo);
	
	@Query(value = "SELECT "
			+ "    SUM(PORTATIL_E + VEICULAR_E + GTR8000_E + PTP_E + MOTOBRIDGE_E + DVRS_E + "
			+ "        SITE_FIXO_E + SITE_TRANSPORTAVEL_E + HF_V_E + "
			+ "        HF_MP_E + HF_BASE_E + VHF_HH_E + VHF_V_E + MULTIBANDA_HH_E + "
			+ "        MULTIBANDA_MP_E + MULTIBANDA_V_E + UHF_HH + UHF_V_E + W_HCLOS_E + "
			+ "        CC2_E + TPP_1400_E + INFORMATICA_E + "
			+ "        NO_DE_ACESSO_E + INTERCOM_SOTAS_E + TERMINAL_SATELITAL_E) "
			+ "        AS Existente,"
			+ " "
			+ "    SUM(PORTARIL_P + VEICULAR_P + GTR8000_P + PTP_P + MOTOBRIDGE_P + DVRS_P + "
			+ "        SITE_FIXO_P + SITE_TRANSPORTAVEL_P + HF_V_P + HF_MP_P + "
			+ "        HF_Fixo_P + VHF_HH_P + VHF_V_P + MULTIBANDA_HH_P + "
			+ "        MULTIBANDA_MP_P + MULTIBANDA_V_P + UHF_HH_P + UHF_V_P + "
			+ "        W_HCLOS_P + CC2_P + INFORMATICA_P + NO_DE_ACESSO_P + "
			+ "        INTERCOM_SOTAS_P + TERMINAL_SATELITAL_P) "
			+ "        AS Previsto, "
			+ "    'EQUIPAMENTO' AS TIPO "
			+ "FROM sg7.consolidado_tipoeqp_view ", nativeQuery = true)
	List<QtdMaterialTipoEqp> getQuantidadeMaterialExistentePrevisto();
	
	@Query(value = "SELECT "
			+ "    SUM(PORTATIL_E + VEICULAR_E + GTR8000_E + PTP_E + MOTOBRIDGE_E + DVRS_E + "
			+ "        SITE_FIXO_E + SITE_TRANSPORTAVEL_E + HF_V_E + "
			+ "        HF_MP_E + HF_BASE_E + VHF_HH_E + VHF_V_E + MULTIBANDA_HH_E + "
			+ "        MULTIBANDA_MP_E + MULTIBANDA_V_E + UHF_HH + UHF_V_E + W_HCLOS_E + "
			+ "        CC2_E + TPP_1400_E + INFORMATICA_E + "
			+ "        NO_DE_ACESSO_E + INTERCOM_SOTAS_E + TERMINAL_SATELITAL_E) "
			+ "        AS Existente,"
			+ " "
			+ "    SUM(PORTARIL_P + VEICULAR_P + GTR8000_P + PTP_P + MOTOBRIDGE_P + DVRS_P + "
			+ "        SITE_FIXO_P + SITE_TRANSPORTAVEL_P + HF_V_P + HF_MP_P + "
			+ "        HF_Fixo_P + VHF_HH_P + VHF_V_P + MULTIBANDA_HH_P + "
			+ "        MULTIBANDA_MP_P + MULTIBANDA_V_P + UHF_HH_P + UHF_V_P + "
			+ "        W_HCLOS_P + CC2_P + INFORMATICA_P + NO_DE_ACESSO_P + "
			+ "        INTERCOM_SOTAS_P + TERMINAL_SATELITAL_P) "
			+ "        AS Previsto, "
			+ "    'EQUIPAMENTO' AS TIPO "
			+ "FROM sg7.consolidado_tipoeqp_view "
			+ "WHERE Cmdo_Mil_A = :cmdo", nativeQuery = true)
	List<QtdMaterialTipoEqp> getQuantidadeMaterialExistentePrevistoPorCmdo(String cmdo);
	
	@Query(nativeQuery = true, value = "SELECT SUM(VALOR) AS TOTAL, ANO, CLASSIFICACAO "
			+ "FROM sg7.diarias_passagens "
			+ "GROUP BY ANO, CLASSIFICACAO")
	List<ValorTotalClassificacaoDiariasPassagens> getValorTotalClassificacaoDiariasPassagens();
	
	@Query(nativeQuery = true, value = "SELECT SUM(VALOR) AS TOTAL, ANO, COD_AO AS 'CODAO' "
			+ "FROM sg7.diarias_passagens "
			+ "WHERE COD_AO IN ('147F', '14T5', '20XE', '21A0', '8965') "
			+ "GROUP BY ANO, COD_AO "
			+ "ORDER BY ANO DESC")
	List<ValorTotalCodAODiariasPassagens> getValorTotalCodAoDiariasPassagens();
}