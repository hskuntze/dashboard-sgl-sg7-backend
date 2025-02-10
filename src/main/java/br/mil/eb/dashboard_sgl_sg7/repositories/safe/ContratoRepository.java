package br.mil.eb.dashboard_sgl_sg7.repositories.safe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.mil.eb.dashboard_sgl_sg7.entities.safe.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {

	@Query(value = "SELECT COUNT(*) FROM safe.contratos", nativeQuery = true)
	Integer getTotalContratos();
}