package br.mil.eb.dashboard_sgl_sg7.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mil.eb.dashboard_sgl_sg7.repositories.safe.ContratoRepository;
import br.mil.eb.dashboard_sgl_sg7.repositories.safe.EtapaRepository;

@Service
public class SafeService {

	@Autowired
	private ContratoRepository contratoRepository;

	@Autowired
	private EtapaRepository etapaRepository;

	@Transactional(readOnly = true)
	public Integer getTotalContratos() {
		return contratoRepository.getTotalContratos();
	}

	@Transactional(readOnly = true)
	public Integer getTotalEtapas() {
		return etapaRepository.getTotalEtapas();
	}
}
