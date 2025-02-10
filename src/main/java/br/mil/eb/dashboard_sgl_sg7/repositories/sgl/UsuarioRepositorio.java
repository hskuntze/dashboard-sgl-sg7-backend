package br.mil.eb.dashboard_sgl_sg7.repositories.sgl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mil.eb.dashboard_sgl_sg7.entities.sgl.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	Usuario findByEmail(String email);
	Usuario findByIdentidade(String identidade);
	Usuario findByUsername(String username);
}