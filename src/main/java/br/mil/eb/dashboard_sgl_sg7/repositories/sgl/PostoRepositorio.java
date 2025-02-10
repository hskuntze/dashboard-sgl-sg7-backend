package br.mil.eb.dashboard_sgl_sg7.repositories.sgl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.eb.dashboard_sgl_sg7.entities.sgl.Posto;

@Repository
public interface PostoRepositorio extends JpaRepository<Posto, Long> {
}
