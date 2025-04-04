package br.mil.eb.dashboard_sgl_sg7.repositories.sg7;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.mil.eb.dashboard_sgl_sg7.entities.sg7.QcpOM;
import br.mil.eb.dashboard_sgl_sg7.entities.sg7.ids.QcpOMId;
import br.mil.eb.dashboard_sgl_sg7.projections.GeoreferenciamentoQcpOM;

public interface QcpOMRepository extends JpaRepository<QcpOM, QcpOMId> {

	@Query(nativeQuery = true, value = "SELECT Cmdo_Mil_A AS CMDO, "
			+ "LAT as LATITUDE, "
			+ "LONGI as LONGITUDE, "
			+ "SUM(QTD_MIL_PREV) as PREVISTO, "
			+ "SUM(QTD_MIL_EFETIVO) as EFETIVO "
			+ "FROM qcp_om_com_exis_prev_view "
			+ "WHERE Cmdo_Mil_A IN ('CMA', 'CMN', 'CMNE', 'CMP', 'CMO', 'CML', 'CMSE', 'CMS') "
			+ "GROUP BY CMDO")
	List<GeoreferenciamentoQcpOM> getGeorefQcpOM();
	
	@Query("SELECT q FROM QcpOM q WHERE cmdoMilA = :cmdo")
	Page<QcpOM> getAllByCmdo(Pageable pageable, String cmdo);
}
