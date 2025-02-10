package br.mil.eb.dashboard_sgl_sg7.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mil.eb.dashboard_sgl_sg7.dto.PostoDTO;
import br.mil.eb.dashboard_sgl_sg7.entities.sgl.Posto;
import br.mil.eb.dashboard_sgl_sg7.repositories.sgl.PostoRepositorio;

@Service
public class PostoServico {

	@Autowired
	private PostoRepositorio postoRepositorio;

	@Transactional(readOnly = true)
	public List<PostoDTO> buscarTodos() {
		List<Posto> postos = postoRepositorio.findAll();
		Collections.reverse(postos);
		return postos.stream().map(p -> new PostoDTO(p)).collect(Collectors.toList());
	}
}
