package br.mil.eb.dashboard_sgl_sg7.repositories.safe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.mil.eb.dashboard_sgl_sg7.entities.safe.Etapa;

@Repository
public interface EtapaRepository extends JpaRepository<Etapa, Long> {

	@Query(value = "SELECT COUNT(*) FROM safe.etapas", nativeQuery = true)
	Integer getTotalEtapas();
}