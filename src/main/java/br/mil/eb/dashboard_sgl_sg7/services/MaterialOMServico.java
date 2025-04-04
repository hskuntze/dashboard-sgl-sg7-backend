package br.mil.eb.dashboard_sgl_sg7.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mil.eb.dashboard_sgl_sg7.dto.CategoriaMaterialIndisponivelDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.GeoreferenciamentoCmdoDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.GeoreferenciamentoUnidadeDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.MaterialIndisponivelDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QtdIndisponivelPorBdaDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QtdMaterialBdaDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QtdMaterialCidadeEstadoDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QtdMaterialCmdoDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QtdMaterialDisponibilidadeCmdoDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QtdMaterialDisponibilidadeDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QtdMaterialRmDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QtdMaterialSubsistemaDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QtdMaterialTipoEqpDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.ValorTotalClassificacaoDiariasPassagensDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.ValorTotalCodAoDiariasPassagensDTO;
import br.mil.eb.dashboard_sgl_sg7.entities.sg7.Coordenadas;
import br.mil.eb.dashboard_sgl_sg7.entities.sg7.MaterialOM;
import br.mil.eb.dashboard_sgl_sg7.repositories.sg7.MaterialOMRepository;
import br.mil.eb.dashboard_sgl_sg7.services.exceptions.RecursoNaoEncontradoException;

@Service
public class MaterialOMServico {

	@Autowired
	private MaterialOMRepository materialOmRepository;

	private static final Map<String, Coordenadas> CMDO_COORDENADAS = Map.of("CMS", new Coordenadas("-51.2", "-30.1"),
			"CMSE", new Coordenadas("-46.6", "-23.5"), "CMP", new Coordenadas("-47.8", "-15.7"), "CMO",
			new Coordenadas("-54.6", "-20.4"), "CMN", new Coordenadas("-48.4", "-1.4"), "CMNE",
			new Coordenadas("-34.9", "-8"), "CML", new Coordenadas("-43.4", "-22.8"), "CMA",
			new Coordenadas("-60", "-3.1"));

	@Transactional(readOnly = true)
	public MaterialOM getBySn(String sn) {
		return materialOmRepository.getMaterialBySn(sn).orElseThrow(
				() -> new RecursoNaoEncontradoException("Não foi possível localizar um material com ID " + sn));
	}

	@Transactional(readOnly = true)
	public List<MaterialOM> getAll() {
		return materialOmRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Page<MaterialOM> findAllMaterial(Pageable pageable) {
		return materialOmRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	public Page<MaterialOM> findAllMaterialPaged(Pageable pageable, String nomeeqp, String pn, String sn, String cmdo) {
		return materialOmRepository.findAllMaterial(pageable, nomeeqp, pn, sn, cmdo);
	}

	@Transactional(readOnly = true)
	public Page<MaterialOM> findMaterialDisponivel(Pageable pageable, String nomeeqp, String pn, String sn) {
		return materialOmRepository.findMaterialDisponivel(pageable, nomeeqp, pn, sn);
	}

	@Transactional(readOnly = true)
	public Page<MaterialOM> findMaterialIndisponivel(Pageable pageable, String nomeeqp, String pn, String sn) {
		return materialOmRepository.findMaterialIndisponivel(pageable, nomeeqp, pn, sn);
	}

	@Transactional(readOnly = true)
	public Integer getQuantidadeTotalMaterial() {
		return materialOmRepository.getQuantidadeTotalMaterial();
	}

	@Transactional(readOnly = true)
	public Integer getQuantidadeTotalMaterialPorUf(String uf) {
		Integer qtd = materialOmRepository.getQuantidadeTotalMaterialPorUf(uf);
		return qtd;
	}

	@Transactional(readOnly = true)
	public List<QtdMaterialSubsistemaDTO> getQuantidadeMaterialSubsistema() {
		List<Object[]> result = materialOmRepository.getQuantidadeMaterialSubsistema();
		List<QtdMaterialSubsistemaDTO> qtd = result.stream()
				.map(row -> new QtdMaterialSubsistemaDTO((String) row[0], ((Long) row[1]).intValue()))
				.collect(Collectors.toList());

		return qtd;
	}

	@Transactional(readOnly = true)
	public List<QtdMaterialSubsistemaDTO> getQuantidadeMaterialSubsistemaPorCmdo(String cmdo) {
		List<Object[]> result = materialOmRepository.getQuantidadeMaterialSubsistemaPorCmdo(cmdo);
		List<QtdMaterialSubsistemaDTO> qtd = result.stream()
				.map(row -> new QtdMaterialSubsistemaDTO((String) row[0], ((Long) row[1]).intValue()))
				.collect(Collectors.toList());

		return qtd;
	}

	@Transactional(readOnly = true)
	public List<QtdMaterialSubsistemaDTO> getQuantidadeMaterialSubsistemaPorBda(String cmdo, String bda) {
		List<Object[]> result = materialOmRepository.getQuantidadeMaterialSubsistemaPorBda(cmdo, bda);
		List<QtdMaterialSubsistemaDTO> qtd = result.stream()
				.map(row -> new QtdMaterialSubsistemaDTO((String) row[0], ((Long) row[1]).intValue()))
				.collect(Collectors.toList());

		return qtd;
	}

	@Transactional(readOnly = true)
	public List<QtdMaterialCmdoDTO> getQuantidadeMaterialCmdo() {
		List<Object[]> result = materialOmRepository.getQuantidadeMaterialCmdo();
		List<QtdMaterialCmdoDTO> qtd = result.stream()
				.map(row -> new QtdMaterialCmdoDTO((String) row[0], ((Long) row[1]).intValue()))
				.collect(Collectors.toList());

		return qtd;
	}

	@Transactional(readOnly = true)
	public List<QtdMaterialBdaDTO> getQuantidadeMaterialBda() {
		List<Object[]> result = materialOmRepository.getQuantidadeMaterialBda();
		List<QtdMaterialBdaDTO> qtd = result.stream()
				.map(row -> new QtdMaterialBdaDTO((String) row[0], ((Long) row[1]).intValue()))
				.collect(Collectors.toList());

		return qtd;
	}

	@Transactional(readOnly = true)
	public List<QtdMaterialDisponibilidadeDTO> getQuantidadeMaterialDisponibilidade() {
		List<Object[]> result = materialOmRepository.getQuantidadeMaterialDisponibilidade();
		List<QtdMaterialDisponibilidadeDTO> qtd = result.stream()
				.map(row -> new QtdMaterialDisponibilidadeDTO((String) row[0], ((Long) row[1]).intValue()))
				.collect(Collectors.toList());

		return qtd;
	}

	@Transactional(readOnly = true)
	public List<QtdMaterialRmDTO> getQuantidadeMaterialRm() {
		List<Object[]> result = materialOmRepository.getQuantidadeMaterialRm();
		List<QtdMaterialRmDTO> qtd = result.stream()
				.map(row -> new QtdMaterialRmDTO((String) row[0], ((Long) row[1]).intValue()))
				.collect(Collectors.toList());

		return qtd;
	}

	@Transactional(readOnly = true)
	public List<QtdMaterialCidadeEstadoDTO> getQuantidadeMaterialCidadeEstado() {
		List<Object[]> result = materialOmRepository.getQuantidadeMaterialCidadeEstado();

		// Mapa para armazenar a contagem por UF
		Map<String, Integer> ufMap = new HashMap<>();

		result.forEach(row -> {
			String cidadeEstado = (String) row[0];
			Long quantidade = (Long) row[1];

			// Se a UF já estiver no mapa, soma a quantidade
			ufMap.put(cidadeEstado, ufMap.getOrDefault(cidadeEstado, 0) + quantidade.intValue());
		});

		// Converte o mapa para uma lista de DTOs
		return ufMap.entrySet().stream().map(entry -> new QtdMaterialCidadeEstadoDTO(entry.getKey(), entry.getValue()))
				.sorted((dto1, dto2) -> Integer.compare(dto2.getQuantidade(), dto1.getQuantidade())) // Ordenação
																										// decrescente
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<QtdIndisponivelPorBdaDTO> getIndisponivelPorBda() {
		List<Object[]> result = materialOmRepository.getQuantidadeIndisponivelPorBDA();
		List<QtdIndisponivelPorBdaDTO> qtd = result.stream()
				.map(row -> new QtdIndisponivelPorBdaDTO((String) row[0], ((Long) row[1]).intValue()))
				.collect(Collectors.toList());

		return qtd;
	}

	@Transactional(readOnly = true)
	public List<CategoriaMaterialIndisponivelDTO> getCategoriaMateriaisIndisponiveis() {
		return materialOmRepository.getCategoriaMateriaisIndisponiveis().stream()
				.map(el -> new CategoriaMaterialIndisponivelDTO(el.getCategoria(), el.getQuantidade()))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<QtdMaterialCidadeEstadoDTO> getQuantidadeUfPorCmdo(String cmdo) {
		return materialOmRepository.getQuantidadeUfPorCmdo(cmdo).stream()
				.map(el -> new QtdMaterialCidadeEstadoDTO(el.getCidadeestado(), el.getQuantidade()))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<QtdMaterialRmDTO> getQuantidadeRmPorCmdo(String cmdo) {
		return materialOmRepository.getQuantidadeMaterialRmPorCmdo(cmdo).stream()
				.map(el -> new QtdMaterialRmDTO(el.getRm(), el.getQuantidade())).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<QtdMaterialBdaDTO> getQuantidadeBdaPorCmdo(String cmdo) {
		return materialOmRepository.getQuantidadeMaterialBdaPorCmdo(cmdo).stream()
				.map(el -> new QtdMaterialBdaDTO(el.getBda(), el.getQuantidade())).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<QtdIndisponivelPorBdaDTO> getIndisponivelPorBdaPorCmdo(String cmdo) {
		return materialOmRepository.getQuantidadeIndisponivelPorBDAPorCmdo(cmdo).stream()
				.map(row -> new QtdIndisponivelPorBdaDTO(row.getBda(), row.getQuantidade()))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<CategoriaMaterialIndisponivelDTO> getCategoriaMateriaisIndisponiveisPorCmdo(String cmdo) {
		return materialOmRepository.getCategoriaMateriaisIndisponiveisPorCmdo(cmdo).stream()
				.map(el -> new CategoriaMaterialIndisponivelDTO(el.getCategoria(), el.getQuantidade()))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<CategoriaMaterialIndisponivelDTO> getCategoriaMateriaisIndisponiveisPorBda(String cmdo, String bda) {
		return materialOmRepository.getCategoriaMateriaisIndisponiveisPorBda(cmdo, bda).stream()
				.map(el -> new CategoriaMaterialIndisponivelDTO(el.getCategoria(), el.getQuantidade()))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<GeoreferenciamentoUnidadeDTO> getGeorefUnidades() {
		return materialOmRepository.getGeorefUnidades().stream()
				.map(el -> new GeoreferenciamentoUnidadeDTO(el.getEquipamento(), el.getOm(), el.getBda(), el.getRm(),
						el.getCmdoOds(), el.getCidade(), el.getEstado(), el.getLatitude(), el.getLongitude()))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<GeoreferenciamentoUnidadeDTO> getGeorefUnidadesPorCmdo(String cmdo) {
		return materialOmRepository.getGeorefUnidadesPorCmdo(cmdo).stream()
				.map(el -> new GeoreferenciamentoUnidadeDTO(el.getEquipamento(), el.getOm(), el.getBda(), el.getRm(),
						el.getCmdoOds(), el.getCidade(), el.getEstado(), el.getLatitude(), el.getLongitude()))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<GeoreferenciamentoCmdoDTO> getGeorefCmdo() {
		return materialOmRepository.getGeorefCmdo().stream().map(el -> {
			Coordenadas coordenadasFixas = CMDO_COORDENADAS.getOrDefault(el.getCmdoOds(),
					new Coordenadas(el.getLongitude(), el.getLatitude())); // Caso não tenha, usa a do banco

			return new GeoreferenciamentoCmdoDTO(el.getCmdoOds(), coordenadasFixas.getLongitude(),
					coordenadasFixas.getLatitude(), el.getQuantidade());
		}).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<GeoreferenciamentoCmdoDTO> getQtdGeorefPorCmdo(String cmdo) {
		return materialOmRepository.getQtdGeorefPorCmdo(cmdo).stream().map(el -> {
			Coordenadas coordenadasFixas = CMDO_COORDENADAS.getOrDefault(el.getCmdoOds(),
					new Coordenadas(el.getLongitude(), el.getLatitude())); // Caso não tenha, usa a do banco

			return new GeoreferenciamentoCmdoDTO(el.getCmdoOds(), coordenadasFixas.getLongitude(),
					coordenadasFixas.getLatitude(), el.getQuantidade());
		}).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<QtdMaterialTipoEqpDTO> getQtdMaterialExistentePrevisto() {
		return materialOmRepository.getQuantidadeMaterialExistentePrevisto().stream()
				.map(x -> new QtdMaterialTipoEqpDTO(x.getTipo(), x.getExistente(), x.getPrevisto()))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<QtdMaterialTipoEqpDTO> getQtdMaterialExistentePrevistoPorCmdo(String cmdo) {
		return materialOmRepository.getQuantidadeMaterialExistentePrevistoPorCmdo(cmdo).stream()
				.map(x -> new QtdMaterialTipoEqpDTO(x.getTipo(), x.getExistente(), x.getPrevisto()))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<QtdMaterialTipoEqpDTO> getQtdMaterialExistentePrevistoPorBda(String cmdo, String bda) {
		return materialOmRepository.getQuantidadeMaterialExistentePrevistoPorBda(cmdo, bda).stream()
				.map(x -> new QtdMaterialTipoEqpDTO(x.getTipo(), x.getExistente(), x.getPrevisto()))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<ValorTotalClassificacaoDiariasPassagensDTO> getValorTotalClassificacaoDiariasPassagens() {
		return materialOmRepository.getValorTotalClassificacaoDiariasPassagens().stream().map(
				x -> new ValorTotalClassificacaoDiariasPassagensDTO(x.getAno(), x.getClassificacao(), x.getTotal()))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<ValorTotalCodAoDiariasPassagensDTO> getValorTotalCodAoDiariasPassagens() {
		return materialOmRepository.getValorTotalCodAoDiariasPassagens().stream()
				.map(x -> new ValorTotalCodAoDiariasPassagensDTO(x.getAno(), x.getCodAo(), x.getTotal()))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<QtdMaterialDisponibilidadeCmdoDTO> getMaterialDisponibilidadePorCmdo() {
		return materialOmRepository.getMaterialDisponibilidadePorCmdo().stream()
				.map(x -> new QtdMaterialDisponibilidadeCmdoDTO(x.getCmdo(), x.getDisponiveis(), x.getIndisponiveis()))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<QtdMaterialDisponibilidadeCmdoDTO> getMaterialDisponibilidadePorCmdo(String cmdo) {
		return materialOmRepository.getMaterialDisponibilidadePorCmdo(cmdo).stream()
				.map(x -> new QtdMaterialDisponibilidadeCmdoDTO(x.getCmdo(), x.getDisponiveis(), x.getIndisponiveis()))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<QtdMaterialDisponibilidadeCmdoDTO> getMaterialDisponibilidadePorBda(String cmdo, String bda) {
		return materialOmRepository.getMaterialDisponibilidadePorBda(cmdo, bda).stream()
				.map(x -> new QtdMaterialDisponibilidadeCmdoDTO(x.getCmdo(), x.getDisponiveis(), x.getIndisponiveis()))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public Page<MaterialIndisponivelDTO> getMaterialIndisponivel(Pageable pageable, String eqp, String bda) {
		return materialOmRepository.getMateriaisIndisponiveisPorBda(pageable, eqp, bda)
				.map(x -> new MaterialIndisponivelDTO(x.getCmdo(), x.getRm(), x.getDe(), x.getBda(), x.getOm(),
						x.getIdsigelog(), x.getEquipamento(), x.getModelo(), x.getFabricante(), x.getPn(), x.getSn(),
						x.getMotivoindisp(), x.getSubsistema(), x.getGrupo(), x.getTipoeqp()));
	}
}