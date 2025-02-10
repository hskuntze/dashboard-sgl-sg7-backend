package br.mil.eb.dashboard_sgl_sg7.repositories.sgl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.mil.eb.dashboard_sgl_sg7.entities.sgl.OM;

@Repository
public interface OMRepositorio extends JpaRepository<OM, Long> {

	@Query(nativeQuery = true, value = "SELECT DISTINCT bda FROM om")
	List<String> buscarBDADistintos();
}
