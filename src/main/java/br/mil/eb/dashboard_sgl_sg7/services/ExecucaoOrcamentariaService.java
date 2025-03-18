package br.mil.eb.dashboard_sgl_sg7.services;

import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mil.eb.dashboard_sgl_sg7.dto.RestanteValorAnoDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.TipoAcaoValorDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.UnidadeOrcamentariaDTO;
import br.mil.eb.dashboard_sgl_sg7.repositories.sg7.ExecucaoOrcamentariaRepository;

@Service
public class ExecucaoOrcamentariaService {

	@Autowired
	private ExecucaoOrcamentariaRepository execucaoOrcamentariaRepository;
	
	@Transactional(readOnly = true)
	public List<RestanteValorAnoDTO> getValorRestantePorAno() {
		return execucaoOrcamentariaRepository.getRestanteValorPorAno()
				.stream()
				.map(el -> new RestanteValorAnoDTO(el.getAno(), el.getValor().setScale(2, RoundingMode.HALF_UP)))
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<UnidadeOrcamentariaDTO> getDiariasPorUg() {
		return execucaoOrcamentariaRepository.getDiariasPorUG()
				.stream()
				.map(el -> new UnidadeOrcamentariaDTO(
						el.getGrupoCodUo(), 
						el.getProvisaoRecebida().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasEmpenhadas().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasLiquidadas().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasPagas().setScale(2, RoundingMode.HALF_UP)))
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<UnidadeOrcamentariaDTO> getPassagensPorUg() {
		return execucaoOrcamentariaRepository.getPassagensPorUG()
				.stream()
				.map(el -> new UnidadeOrcamentariaDTO(
						el.getGrupoCodUo(), 
						el.getProvisaoRecebida().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasEmpenhadas().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasLiquidadas().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasPagas().setScale(2, RoundingMode.HALF_UP)))
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<UnidadeOrcamentariaDTO> getExecucaoPorUg() {
		return execucaoOrcamentariaRepository.getExecucaoPorUG()
				.stream()
				.map(el -> new UnidadeOrcamentariaDTO(
						el.getGrupoCodUo(), 
						el.getProvisaoRecebida().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasEmpenhadas().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasLiquidadas().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasPagas().setScale(2, RoundingMode.HALF_UP)))
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<UnidadeOrcamentariaDTO> getExecucaoPorElemento() {
		return execucaoOrcamentariaRepository.getExecucaoPorElemento()
				.stream()
				.map(el -> new UnidadeOrcamentariaDTO(
						el.getGrupoCodUo(), 
						el.getProvisaoRecebida().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasEmpenhadas().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasLiquidadas().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasPagas().setScale(2, RoundingMode.HALF_UP)))
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<UnidadeOrcamentariaDTO> getExecucaoOrcamentaria2024() {
		return execucaoOrcamentariaRepository.getExecucaoOrcamentaria2024()
				.stream()
				.map(el -> new UnidadeOrcamentariaDTO(
						el.getGrupoCodUo(), 
						el.getProvisaoRecebida().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasEmpenhadas().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasLiquidadas().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasPagas().setScale(2, RoundingMode.HALF_UP)))
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<UnidadeOrcamentariaDTO> getExecucaoOrcamentaria2025() {
		return execucaoOrcamentariaRepository.getExecucaoOrcamentaria2025()
				.stream()
				.map(el -> new UnidadeOrcamentariaDTO(
						el.getGrupoCodUo(), 
						el.getProvisaoRecebida().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasEmpenhadas().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasLiquidadas().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasPagas().setScale(2, RoundingMode.HALF_UP)))
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<UnidadeOrcamentariaDTO> getExecucaoOrcamentaria2024TipoAcao() {
		return execucaoOrcamentariaRepository.getExecucaoOrcamentaria2024TipoAcao()
				.stream()
				.map(el -> new UnidadeOrcamentariaDTO(
						el.getGrupoCodUo(), 
						el.getProvisaoRecebida().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasEmpenhadas().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasLiquidadas().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasPagas().setScale(2, RoundingMode.HALF_UP)))
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<UnidadeOrcamentariaDTO> getExecucaoOrcamentaria2025TipoAcao() {
		return execucaoOrcamentariaRepository.getExecucaoOrcamentaria2025TipoAcao()
				.stream()
				.map(el -> new UnidadeOrcamentariaDTO(
						el.getGrupoCodUo(), 
						el.getProvisaoRecebida().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasEmpenhadas().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasLiquidadas().setScale(2, RoundingMode.HALF_UP), 
						el.getDespesasPagas().setScale(2, RoundingMode.HALF_UP)))
				.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<TipoAcaoValorDTO> getTipoAcaoValor() {
		return execucaoOrcamentariaRepository.getExecucaoTipoDeAcao()
				.stream()
				.map(el -> new TipoAcaoValorDTO(
						el.getTipo(), 
						el.getValor().setScale(2, RoundingMode.HALF_UP)))
				.collect(Collectors.toList());
	}
}
