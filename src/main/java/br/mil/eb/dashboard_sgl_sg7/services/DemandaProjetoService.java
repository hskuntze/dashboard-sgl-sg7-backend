package br.mil.eb.dashboard_sgl_sg7.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mil.eb.dashboard_sgl_sg7.dto.DemandaProjetoDTO;
import br.mil.eb.dashboard_sgl_sg7.repositories.sg7.DemandaProjetoRepository;

@Service
public class DemandaProjetoService {

	@Autowired
	private DemandaProjetoRepository repository;
	
	@Transactional(readOnly = true)
	public List<DemandaProjetoDTO> getAll() {
		return repository.findAll().stream().map(x -> new DemandaProjetoDTO(x)).collect(Collectors.toList());
	}
}
