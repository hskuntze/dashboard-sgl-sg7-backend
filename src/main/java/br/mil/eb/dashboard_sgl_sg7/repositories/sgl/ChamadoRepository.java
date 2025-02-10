package br.mil.eb.dashboard_sgl_sg7.repositories.sgl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.mil.eb.dashboard_sgl_sg7.entities.sgl.Chamado;
import br.mil.eb.dashboard_sgl_sg7.projections.QtdChamados;
import br.mil.eb.dashboard_sgl_sg7.projections.QtdChamadosAno;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long>{

	@Query(nativeQuery = true, value = "SELECT COUNT(*) as 'Quantidade' "
			+ "FROM sgl_dump_2.ticket")
	QtdChamados getQuantidadeChamados();

	@Query(nativeQuery = true, value = "SELECT COUNT(*) as 'Quantidade' "
			+ "FROM sgl_dump_2.ticket "
			+ "WHERE TICKET_STATUS <> 'CLOSED' "
			+ "AND TICKET_STATUS <> 'FAILURE_NOT_FOUND' "
			+ "AND TICKET_STATUS <> 'CANCELED'")
	QtdChamados getQuantidadeChamadosAbertos();

	@Query(nativeQuery = true, value = "SELECT "
			+ "YEAR(CREATION_DATE) AS Ano,  "
			+ "COUNT(*) AS Quantidade "
			+ "FROM sgl_dump_2.ticket "
			+ "GROUP BY Ano "
			+ "ORDER BY Ano ASC")
	List<QtdChamadosAno> getQuantidadeChamadosAno();
}