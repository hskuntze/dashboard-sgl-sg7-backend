package br.mil.eb.dashboard_sgl_sg7.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mil.eb.dashboard_sgl_sg7.dto.OperacoesDTO;
import br.mil.eb.dashboard_sgl_sg7.entities.sg7.Operacoes;
import br.mil.eb.dashboard_sgl_sg7.repositories.sg7.OperacoesRepository;
import br.mil.eb.dashboard_sgl_sg7.services.exceptions.RecursoNaoEncontradoException;

@Service
public class OperacoesService {

	@Autowired
	private OperacoesRepository operacoesRepositorio;
	
	@Transactional(readOnly = true)
	public List<OperacoesDTO> getAll() {
		return operacoesRepositorio.findAll().stream().map(x -> new OperacoesDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public OperacoesDTO getById(Long id) {
		Operacoes op = operacoesRepositorio.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Não foi possível encontrar uma Operação com ID " + id));
		return new OperacoesDTO(op);
	}
}
