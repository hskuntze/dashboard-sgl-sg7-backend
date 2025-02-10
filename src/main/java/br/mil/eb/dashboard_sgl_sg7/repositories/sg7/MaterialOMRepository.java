package br.mil.eb.dashboard_sgl_sg7.repositories.sg7;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.mil.eb.dashboard_sgl_sg7.entities.sg7.MaterialOM;

@Repository
public interface MaterialOMRepository extends JpaRepository<MaterialOM, Long>{

	@Query("SELECT m FROM MaterialOM m WHERE m.disponibilidade = 'Disponível'")
	Page<MaterialOM> findMaterialDisponivel(Pageable pageable);

	@Query("SELECT m FROM MaterialOM m WHERE m.disponibilidade = 'Indisponível'")
	Page<MaterialOM> findMaterialIndisponivel(Pageable pageable);

	@Query("SELECT COUNT(m) AS Quantidade FROM MaterialOM m")
	Integer getQuantidadeTotalMaterial();

	@Query("SELECT m.cmdo, COUNT(m) "
	        + "FROM MaterialOM m "
	        + "GROUP BY m.cmdo "
	        + "ORDER BY COUNT(m) DESC")
	List<Object[]> getQuantidadeMaterialCmdo();

	@Query("SELECT "
	        + "CASE "
	        + "   WHEN m.bda = 'Vinculação direta ao CMDO' THEN 'Vinculação direta' "
	        + "   ELSE m.bda "
	        + "END, "
	        + "COUNT(m) "
	        + "FROM MaterialOM m "
	        + "GROUP BY m.bda")
	List<Object[]> getQuantidadeMaterialBda();

	@Query("SELECT m.disponibilidade, COUNT(m) "
	        + "FROM MaterialOM m "
	        + "GROUP BY m.disponibilidade")
	List<Object[]> getQuantidadeMaterialDisponibilidade();

	@Query("SELECT m.rm, COUNT(m) "
	        + "FROM MaterialOM m "
	        + "GROUP BY m.rm")
	List<Object[]> getQuantidadeMaterialRm();

	@Query("SELECT m.cidadeestado, COUNT(m) "
	        + "FROM MaterialOM m "
	        + "WHERE m.cidadeestado IS NOT NULL AND m.cidadeestado <> '' "
	        + "GROUP BY m.cidadeestado "
	        + "ORDER BY COUNT(m) DESC")
	List<Object[]> getQuantidadeMaterialCidadeEstado();
}