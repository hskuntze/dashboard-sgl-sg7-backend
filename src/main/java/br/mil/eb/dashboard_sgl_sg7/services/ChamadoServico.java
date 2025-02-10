package br.mil.eb.dashboard_sgl_sg7.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mil.eb.dashboard_sgl_sg7.dto.QtdChamadoAnoDTO;
import br.mil.eb.dashboard_sgl_sg7.repositories.sgl.ChamadoRepository;

@Service
public class ChamadoServico {

	@Autowired
	private ChamadoRepository chamadoRepository;

	@Transactional(readOnly = true)
	public Integer getQuantidadeChamados() {
		return chamadoRepository.getQuantidadeChamados().getQuantidade();
	}

	@Transactional(readOnly = true)
	public Integer getQuantidadeChamadosAbertos() {
		return chamadoRepository.getQuantidadeChamadosAbertos().getQuantidade();
	}

	@Transactional(readOnly = true)
	public List<QtdChamadoAnoDTO> getQuantidadeChamadosAno() {
		List<QtdChamadoAnoDTO> qtd = chamadoRepository.getQuantidadeChamadosAno()
				.stream()
				.map(el -> new QtdChamadoAnoDTO(el.getAno(), el.getQuantidade()))
				.collect(Collectors.toList());

		return qtd;
	}
}
