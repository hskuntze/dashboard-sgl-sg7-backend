package br.mil.eb.dashboard_sgl_sg7.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mil.eb.dashboard_sgl_sg7.dto.ExecucaoFinanceiraDTO;
import br.mil.eb.dashboard_sgl_sg7.repositories.sg7.ExecucaoFinanceiraRepository;

@Service
public class ExecucaoFinanceiraService {

	@Autowired
	private ExecucaoFinanceiraRepository execucaoFinanceiraRepository;
	
	@Transactional(readOnly = true)
	public List<ExecucaoFinanceiraDTO> getAll() {
		return execucaoFinanceiraRepository.findAll().stream().map(x -> new ExecucaoFinanceiraDTO(x)).collect(Collectors.toList());
	}
}
