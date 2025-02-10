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

import br.mil.eb.dashboard_sgl_sg7.dto.QtdMaterialBdaDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QtdMaterialCidadeEstadoDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QtdMaterialCmdoDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QtdMaterialDisponibilidadeDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QtdMaterialRmDTO;
import br.mil.eb.dashboard_sgl_sg7.entities.sg7.MaterialOM;
import br.mil.eb.dashboard_sgl_sg7.repositories.sg7.MaterialOMRepository;

@Service
public class MaterialOMServico {

	@Autowired
	private MaterialOMRepository materialOmRepository;

	@Transactional(readOnly = true)
	public List<MaterialOM> getAll() {
		return materialOmRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Page<MaterialOM> findAllMaterial(Pageable pageable) {
		return materialOmRepository.findAll(pageable);
	}

	@Transactional(readOnly = true)
	public Page<MaterialOM> findMaterialDisponivel(Pageable pageable) {
		return materialOmRepository.findMaterialDisponivel(pageable);
	}

	@Transactional(readOnly = true)
	public Page<MaterialOM> findMaterialIndisponivel(Pageable pageable) {
		return materialOmRepository.findMaterialIndisponivel(pageable);
	}

	@Transactional(readOnly = true)
	public Integer getQuantidadeTotalMaterial() {
		return materialOmRepository.getQuantidadeTotalMaterial();
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

	        // Aplica a transformação necessária para extrair a UF
	        cidadeEstado = cidadeEstado.trim().toUpperCase();

	        // Extrai a UF após o "-" ou "/" (caso exista)
	        String uf = cidadeEstado.contains("-") ? cidadeEstado.split("-")[1] : cidadeEstado.split("/")[1];

	        // Se a UF já estiver no mapa, soma a quantidade
	        ufMap.put(uf, ufMap.getOrDefault(uf, 0) + quantidade.intValue());
	    });

	    // Converte o mapa para uma lista de DTOs
	    return ufMap.entrySet().stream()
	            .map(entry -> new QtdMaterialCidadeEstadoDTO(entry.getKey(), entry.getValue()))
	            .sorted((dto1, dto2) -> Integer.compare(dto2.getQuantidade(), dto1.getQuantidade())) // Ordenação decrescente
	            .collect(Collectors.toList());
	}

}
