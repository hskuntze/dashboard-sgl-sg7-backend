package br.mil.eb.dashboard_sgl_sg7.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.eb.dashboard_sgl_sg7.dto.QtdMaterialBdaDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QtdMaterialCidadeEstadoDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QtdMaterialCmdoDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QtdMaterialDisponibilidadeDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QtdMaterialRmDTO;
import br.mil.eb.dashboard_sgl_sg7.entities.sg7.MaterialOM;
import br.mil.eb.dashboard_sgl_sg7.services.MaterialOMServico;

@RestController
@RequestMapping(value = "/materiaisom")
public class MaterialOMController {

	@Autowired
	private MaterialOMServico materialOmServico;

	@GetMapping
	public ResponseEntity<List<MaterialOM>> getAll() {
		return ResponseEntity.ok().body(materialOmServico.getAll());
	}

	@GetMapping(value = "/paginado")
	public ResponseEntity<Page<MaterialOM>> findAllMaterial(Pageable pageable) {
		return ResponseEntity.ok().body(materialOmServico.findAllMaterial(pageable));
	}

	@GetMapping(value = "/paginado/disponivel")
	public ResponseEntity<Page<MaterialOM>> findAllMaterialDisponivel(Pageable pageable) {
		return ResponseEntity.ok().body(materialOmServico.findMaterialDisponivel(pageable));
	}

	@GetMapping(value = "/paginado/indisponivel")
	public ResponseEntity<Page<MaterialOM>> findAllMaterialIndisponivel(Pageable pageable) {
		return ResponseEntity.ok().body(materialOmServico.findMaterialIndisponivel(pageable));
	}

	@GetMapping(value = "/total")
	public ResponseEntity<Integer> getQuantidadeTotalMaterial() {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeTotalMaterial());
	}

	@GetMapping(value = "/qtd/cmdo")
	public ResponseEntity<List<QtdMaterialCmdoDTO>> getQuantidadeMaterialCmdo() {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeMaterialCmdo());
	}

	@GetMapping(value = "/qtd/bda")
	public ResponseEntity<List<QtdMaterialBdaDTO>> getQuantidadeMaterialBda() {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeMaterialBda());
	}

	@GetMapping(value = "/qtd/disponibilidade")
	public ResponseEntity<List<QtdMaterialDisponibilidadeDTO>> getQuantidadeMaterialDisponibilidade() {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeMaterialDisponibilidade());
	}

	@GetMapping(value = "/qtd/rm")
	public ResponseEntity<List<QtdMaterialRmDTO>> getQuantidadeMaterialRm() {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeMaterialRm());
	}

	@GetMapping(value = "/qtd/cidadeestado")
	public ResponseEntity<List<QtdMaterialCidadeEstadoDTO>> getQuantidadeMaterialCidadeEstado() {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeMaterialCidadeEstado());
	}
}
