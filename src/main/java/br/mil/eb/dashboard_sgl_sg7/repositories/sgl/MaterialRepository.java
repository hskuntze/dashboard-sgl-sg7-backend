package br.mil.eb.dashboard_sgl_sg7.repositories.sgl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.mil.eb.dashboard_sgl_sg7.dto.MaterialChamadoSad2DTO;
import br.mil.eb.dashboard_sgl_sg7.entities.sgl.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
	@Query("SELECT new br.mil.eb.dashboard_sgl_sg7.dto.MaterialChamadoSad2DTO(m, p.subsistema, p.numeroserie) "
			+ "FROM br.mil.eb.dashboard_sgl_sg7.entities.sgl.Material m "
			+ "LEFT JOIN br.mil.eb.dashboard_sgl_sg7.entities.sgl.Patrimonio p ON m.id = p.material "
			+ "LEFT JOIN br.mil.eb.dashboard_sgl_sg7.entities.sgl.OM om ON p.om = om.codigo "
			+ "WHERE om.codigo = :codigo")
	List<MaterialChamadoSad2DTO> findMaterialsByOm(Long codigo);
}