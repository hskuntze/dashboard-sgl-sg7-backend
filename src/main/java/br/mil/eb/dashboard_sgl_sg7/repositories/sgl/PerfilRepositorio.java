package br.mil.eb.dashboard_sgl_sg7.repositories.sgl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.eb.dashboard_sgl_sg7.entities.sgl.Perfil;

@Repository
public interface PerfilRepositorio extends JpaRepository<Perfil, Long>{
}