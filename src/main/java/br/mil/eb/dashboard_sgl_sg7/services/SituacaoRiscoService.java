package br.mil.eb.dashboard_sgl_sg7.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mil.eb.dashboard_sgl_sg7.dto.SituacaoRiscoDTO;
import br.mil.eb.dashboard_sgl_sg7.repositories.sg7.SituacaoRiscoRepository;

@Service
public class SituacaoRiscoService {

	@Autowired
	private SituacaoRiscoRepository situacaoRiscoRepository;
	
	@Transactional(readOnly = true)
	public List<SituacaoRiscoDTO> getAll() {
		return situacaoRiscoRepository.findAll().stream().map(x -> new SituacaoRiscoDTO(x)).collect(Collectors.toList());
	}
}
