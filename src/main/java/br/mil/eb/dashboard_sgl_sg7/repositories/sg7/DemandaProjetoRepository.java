package br.mil.eb.dashboard_sgl_sg7.repositories.sg7;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.eb.dashboard_sgl_sg7.entities.sg7.DemandaProjeto;

@Repository
public interface DemandaProjetoRepository extends JpaRepository<DemandaProjeto, Long> {
}