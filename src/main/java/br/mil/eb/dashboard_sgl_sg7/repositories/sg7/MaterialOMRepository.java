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
}