package br.mil.eb.dashboard_sgl_sg7.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.mil.eb.dashboard_sgl_sg7.dto.CategoriaMaterialIndisponivelDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.GeoreferenciamentoCmdoDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.GeoreferenciamentoUnidadeDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QtdIndisponivelPorBdaDTO;
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
	
	@GetMapping(value = "/{sn}")
	public ResponseEntity<MaterialOM> getById(@PathVariable String sn) {
		return ResponseEntity.ok().body(materialOmServico.getBySn(sn));
	}
	
	@GetMapping(value = "/paginado")
	public ResponseEntity<Page<MaterialOM>> findAllMaterial(Pageable pageable) {
		return ResponseEntity.ok().body(materialOmServico.findAllMaterial(pageable));
	}
	
	@GetMapping(value = "/paginado/filter")
	public ResponseEntity<Page<MaterialOM>> findAllMaterial(Pageable pageable,
			@RequestParam(defaultValue = "") String nomeeqp,
			@RequestParam(defaultValue = "") String pn,
			@RequestParam(defaultValue = "") String sn,
			@RequestParam(defaultValue = "") String cmdo) {
		return ResponseEntity.ok().body(materialOmServico.findAllMaterialPaged(pageable, nomeeqp, pn, sn, cmdo));
	}
	
	@GetMapping(value = "/paginado/disponivel")
	public ResponseEntity<Page<MaterialOM>> findAllMaterialDisponivel(Pageable pageable,
			@RequestParam(defaultValue = "") String nomeeqp,
			@RequestParam(defaultValue = "") String pn,
			@RequestParam(defaultValue = "") String sn) {
		return ResponseEntity.ok().body(materialOmServico.findMaterialDisponivel(pageable, nomeeqp, pn, sn));
	}
	
	@GetMapping(value = "/paginado/indisponivel")
	public ResponseEntity<Page<MaterialOM>> findAllMaterialIndisponivel(Pageable pageable,
			@RequestParam(defaultValue = "") String nomeeqp,
			@RequestParam(defaultValue = "") String pn,
			@RequestParam(defaultValue = "") String sn) {
		return ResponseEntity.ok().body(materialOmServico.findMaterialIndisponivel(pageable, nomeeqp, pn, sn));
	}
	
	@GetMapping(value = "/total")
	public ResponseEntity<Integer> getQuantidadeTotalMaterial() {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeTotalMaterial());
	}
	
	@GetMapping(value = "/total/{uf}")
	public ResponseEntity<Integer> getQuantidadeTotalMaterialUf(@PathVariable String uf) {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeTotalMaterialPorUf(uf));
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
	
	@GetMapping(value = "/qtd/indisponivelbda")
	public ResponseEntity<List<QtdIndisponivelPorBdaDTO>> getIndisponivelPorBda() {
		return ResponseEntity.ok().body(materialOmServico.getIndisponivelPorBda());
	}
	
	@GetMapping(value = "/qtd/ctgmtindisponivel")
	public ResponseEntity<List<CategoriaMaterialIndisponivelDTO>> getCategoriaMaterialIndisponivel() {
		return ResponseEntity.ok().body(materialOmServico.getCategoriaMateriaisIndisponiveis());
	}
	
	@GetMapping(value = "/qtd/ufcmdo/{cmdo}")
	public ResponseEntity<List<QtdMaterialCidadeEstadoDTO>> getQuantidadeUfPorCmdo(@PathVariable String cmdo) {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeUfPorCmdo(cmdo));
	}
	
	@GetMapping(value = "/qtd/rmcmdo/{cmdo}")
	public ResponseEntity<List<QtdMaterialRmDTO>> getQuantidadeRmPorCmdo(@PathVariable String cmdo) {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeRmPorCmdo(cmdo));
	}
	
	@GetMapping(value = "/qtd/bdacmdo/{cmdo}")
	public ResponseEntity<List<QtdMaterialBdaDTO>> getQuantidadeBdaPorCmdo(@PathVariable String cmdo) {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeBdaPorCmdo(cmdo));
	}

	@GetMapping(value = "/qtd/indisponivelbdacmdo/{cmdo}")
	public ResponseEntity<List<QtdIndisponivelPorBdaDTO>> getIndisponivelPorBdaPorCmdo(@PathVariable String cmdo) {
		return ResponseEntity.ok().body(materialOmServico.getIndisponivelPorBdaPorCmdo(cmdo));
	}
	
	@GetMapping(value = "/qtd/ctgmtindisponivelcmdo/{cmdo}")
	public ResponseEntity<List<CategoriaMaterialIndisponivelDTO>> getCategoriaMateriaisIndisponiveisPorCmdo(@PathVariable String cmdo) {
		return ResponseEntity.ok().body(materialOmServico.getCategoriaMateriaisIndisponiveisPorCmdo(cmdo));
	}
	
	@GetMapping(value = "/georef/unidades")
	public ResponseEntity<List<GeoreferenciamentoUnidadeDTO>> getGeorefUnidades() {
		return ResponseEntity.ok().body(materialOmServico.getGeorefUnidades());
	}
	
	@GetMapping(value = "/georef/unidades/{cmdo}")
	public ResponseEntity<List<GeoreferenciamentoUnidadeDTO>> getGeorefUnidadesPorCmdo(@PathVariable String cmdo) {
		return ResponseEntity.ok().body(materialOmServico.getGeorefUnidadesPorCmdo(cmdo));
	}
	
	@GetMapping(value = "/georef/cmdo")
	public ResponseEntity<List<GeoreferenciamentoCmdoDTO>> getGeorefCmdo() {
		return ResponseEntity.ok().body(materialOmServico.getGeorefCmdo());
	}
	
	@GetMapping(value = "/georef/cmdo/{cmdo}")
	public ResponseEntity<List<GeoreferenciamentoCmdoDTO>> getQtdGeorefPorCmdo(@PathVariable String cmdo) {
		return ResponseEntity.ok().body(materialOmServico.getQtdGeorefPorCmdo(cmdo));
	}
}