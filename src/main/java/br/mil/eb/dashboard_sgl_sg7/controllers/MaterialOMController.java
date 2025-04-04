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
import br.mil.eb.dashboard_sgl_sg7.entities.sg7.MaterialOM;
import br.mil.eb.dashboard_sgl_sg7.services.MaterialOMServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "/materiaisom")
@SecurityRequirement(name = "oauth2")
public class MaterialOMController {

	@Autowired
	private MaterialOMServico materialOmServico;

	@GetMapping
	@Operation(tags = { "/materiaisom" }, description = "Retorna todos os materiais")
	public ResponseEntity<List<MaterialOM>> getAll() {
		return ResponseEntity.ok().body(materialOmServico.getAll());
	}

	@GetMapping(value = "/{sn}")
	@Operation(tags = {
			"/materiaisom" }, description = "Retorna um material baseado no número de série dele.", parameters = {
					@Parameter(name = "sn", description = "Número de série", example = "A09670") })
	public ResponseEntity<MaterialOM> getById(@PathVariable String sn) {
		return ResponseEntity.ok().body(materialOmServico.getBySn(sn));
	}

	@GetMapping(value = "/paginado")
	@Operation(tags = { "/materiaisom" }, description = "Retorna todos os materiais.", parameters = {
			@Parameter(name = "pageable", description = "Interface \"Pageable\" do Spring") })
	public ResponseEntity<Page<MaterialOM>> findAllMaterial(Pageable pageable) {
		return ResponseEntity.ok().body(materialOmServico.findAllMaterial(pageable));
	}

	@GetMapping(value = "/paginado/filter")
	@Operation(tags = { "/materiaisom" }, description = "Retorna todos os materiais com filtro.", parameters = {
			@Parameter(name = "pageable", description = "Interface \"Pageable\" do Spring"),
			@Parameter(name = "nomeeqp", description = "Nome do equipamento"),
			@Parameter(name = "pn", description = "Identificador da parte (Part Number)"),
			@Parameter(name = "sn", description = "Número de série"),
			@Parameter(name = "cmdo", description = "Comando"), })
	public ResponseEntity<Page<MaterialOM>> findAllMaterial(Pageable pageable,
			@RequestParam(defaultValue = "") String nomeeqp, @RequestParam(defaultValue = "") String pn,
			@RequestParam(defaultValue = "") String sn, @RequestParam(defaultValue = "") String cmdo) {
		return ResponseEntity.ok().body(materialOmServico.findAllMaterialPaged(pageable, nomeeqp, pn, sn, cmdo));
	}

	@GetMapping(value = "/paginado/disponivel")
	@Operation(tags = { "/materiaisom" }, description = "Retorna os materiais disponíveis.", parameters = {
			@Parameter(name = "pageable", description = "Interface \"Pageable\" do Spring"),
			@Parameter(name = "nomeeqp", description = "Nome do equipamento"),
			@Parameter(name = "pn", description = "Identificador da parte (Part Number)"),
			@Parameter(name = "sn", description = "Número de série"), })
	public ResponseEntity<Page<MaterialOM>> findAllMaterialDisponivel(Pageable pageable,
			@RequestParam(defaultValue = "") String nomeeqp, @RequestParam(defaultValue = "") String pn,
			@RequestParam(defaultValue = "") String sn) {
		return ResponseEntity.ok().body(materialOmServico.findMaterialDisponivel(pageable, nomeeqp, pn, sn));
	}

	@GetMapping(value = "/paginado/indisponivel")
	@Operation(tags = { "/materiaisom" }, description = "Retorna os materiais indisponíveis.", parameters = {
			@Parameter(name = "pageable", description = "Interface \"Pageable\" do Spring"),
			@Parameter(name = "nomeeqp", description = "Nome do equipamento"),
			@Parameter(name = "pn", description = "Identificador da parte (Part Number)"),
			@Parameter(name = "sn", description = "Número de série"), })
	public ResponseEntity<Page<MaterialOM>> findAllMaterialIndisponivel(Pageable pageable,
			@RequestParam(defaultValue = "") String nomeeqp, @RequestParam(defaultValue = "") String pn,
			@RequestParam(defaultValue = "") String sn) {
		return ResponseEntity.ok().body(materialOmServico.findMaterialIndisponivel(pageable, nomeeqp, pn, sn));
	}

	@GetMapping(value = "/total")
	@Operation(tags = { "/materiaisom" }, description = "Retorna o total de materiais")
	public ResponseEntity<Integer> getQuantidadeTotalMaterial() {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeTotalMaterial());
	}

	@GetMapping(value = "/total/{uf}")
	@Operation(tags = { "/materiaisom" }, parameters = {
			@Parameter(name = "uf", description = "UF") }, description = "Retorna o total de materiais por UF.")
	public ResponseEntity<Integer> getQuantidadeTotalMaterialUf(@PathVariable String uf) {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeTotalMaterialPorUf(uf));
	}

	@GetMapping(value = "/qtd/cmdo")
	@Operation(tags = { "/materiaisom" }, description = "Retorna o total de materiais por comando.")
	public ResponseEntity<List<QtdMaterialCmdoDTO>> getQuantidadeMaterialCmdo() {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeMaterialCmdo());
	}

	@GetMapping(value = "/qtd/bda")
	@Operation(tags = { "/materiaisom" }, description = "Retorna o total de materiais por brigada.")
	public ResponseEntity<List<QtdMaterialBdaDTO>> getQuantidadeMaterialBda() {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeMaterialBda());
	}

	@GetMapping(value = "/qtd/disponibilidade")
	@Operation(tags = {
			"/materiaisom" }, description = "Retorna o total de materiais por disponibilidade (disponível ou indisponível).")
	public ResponseEntity<List<QtdMaterialDisponibilidadeDTO>> getQuantidadeMaterialDisponibilidade() {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeMaterialDisponibilidade());
	}

	@GetMapping(value = "/qtd/rm")
	@Operation(tags = { "/materiaisom" }, description = "Retorna o total de materiais por região militar.")
	public ResponseEntity<List<QtdMaterialRmDTO>> getQuantidadeMaterialRm() {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeMaterialRm());
	}

	@GetMapping(value = "/qtd/cidadeestado")
	@Operation(tags = { "/materiaisom" }, description = "Retorna o total de materiais por estado.")
	public ResponseEntity<List<QtdMaterialCidadeEstadoDTO>> getQuantidadeMaterialCidadeEstado() {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeMaterialCidadeEstado());
	}

	@GetMapping(value = "/qtd/indisponivelbda")
	@Operation(tags = { "/materiaisom" }, description = "Retorna o total de materiais indisponíveis por brigada.")
	public ResponseEntity<List<QtdIndisponivelPorBdaDTO>> getIndisponivelPorBda() {
		return ResponseEntity.ok().body(materialOmServico.getIndisponivelPorBda());
	}

	@GetMapping(value = "/qtd/ctgmtindisponivel")
	@Operation(tags = { "/materiaisom" }, description = "Retorna o total de materiais indisponíveis por categoria.")
	public ResponseEntity<List<CategoriaMaterialIndisponivelDTO>> getCategoriaMaterialIndisponivel() {
		return ResponseEntity.ok().body(materialOmServico.getCategoriaMateriaisIndisponiveis());
	}

	@GetMapping(value = "/qtd/subsistema")
	@Operation(tags = { "/materiaisom" }, description = "Retorna o total de materiais por subsistema.")
	public ResponseEntity<List<QtdMaterialSubsistemaDTO>> getQuantidadeMaterialSubsistema() {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeMaterialSubsistema());
	}

	@GetMapping(value = "/qtd/subsistema/{cmdo}")
	@Operation(tags = {
			"/materiaisom" }, description = "Retorna o total de materiais por subsistema de acordo com o comando.", parameters = {
					@Parameter(name = "cmdo", description = "Comando") })
	public ResponseEntity<List<QtdMaterialSubsistemaDTO>> getQuantidadeMaterialSubsistemaPorCmdo(
			@PathVariable String cmdo) {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeMaterialSubsistemaPorCmdo(cmdo));
	}

	@GetMapping(value = "/qtd/subsistema/bda")
	@Operation(tags = {
			"/materiaisom" }, description = "Retorna o total de materiais por subsistema de acordo com a brigada.", parameters = {
					@Parameter(name = "cmdo", description = "Comando") })
	public ResponseEntity<List<QtdMaterialSubsistemaDTO>> getQuantidadeMaterialSubsistemaPorBda(
			@RequestParam String cmdo, @RequestParam String bda) {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeMaterialSubsistemaPorBda(cmdo, bda));
	}

	@GetMapping(value = "/qtd/ufcmdo/{cmdo}")
	@Operation(tags = {
			"/materiaisom" }, description = "Retorna o total de materiais por uf de acordo com o comando.", parameters = {
					@Parameter(name = "cmdo", description = "Comando") })
	public ResponseEntity<List<QtdMaterialCidadeEstadoDTO>> getQuantidadeUfPorCmdo(@PathVariable String cmdo) {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeUfPorCmdo(cmdo));
	}

	@GetMapping(value = "/qtd/rmcmdo/{cmdo}")
	@Operation(tags = {
			"/materiaisom" }, description = "Retorna o total de materiais por região militar de acordo com o comando.", parameters = {
					@Parameter(name = "cmdo", description = "Comando") })
	public ResponseEntity<List<QtdMaterialRmDTO>> getQuantidadeRmPorCmdo(@PathVariable String cmdo) {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeRmPorCmdo(cmdo));
	}

	@GetMapping(value = "/qtd/bdacmdo/{cmdo}")
	@Operation(tags = {
			"/materiaisom" }, description = "Retorna o total de materiais por brigada de acordo com o comando.", parameters = {
					@Parameter(name = "cmdo", description = "Comando") })
	public ResponseEntity<List<QtdMaterialBdaDTO>> getQuantidadeBdaPorCmdo(@PathVariable String cmdo) {
		return ResponseEntity.ok().body(materialOmServico.getQuantidadeBdaPorCmdo(cmdo));
	}

	@GetMapping(value = "/qtd/indisponivelbdacmdo/{cmdo}")
	@Operation(tags = {
			"/materiaisom" }, description = "Retorna o total de materiais indisponíveis por brigada de acordo com o comando.", parameters = {
					@Parameter(name = "cmdo", description = "Comando") })
	public ResponseEntity<List<QtdIndisponivelPorBdaDTO>> getIndisponivelPorBdaPorCmdo(@PathVariable String cmdo) {
		return ResponseEntity.ok().body(materialOmServico.getIndisponivelPorBdaPorCmdo(cmdo));
	}

	@GetMapping(value = "/qtd/ctgmtindisponivelcmdo/{cmdo}")
	@Operation(tags = {
			"/materiaisom" }, description = "Retorna o total de materiais indisponíveis por categoria de material de acordo com o comando.", parameters = {
					@Parameter(name = "cmdo", description = "Comando") })
	public ResponseEntity<List<CategoriaMaterialIndisponivelDTO>> getCategoriaMateriaisIndisponiveisPorCmdo(
			@PathVariable String cmdo) {
		return ResponseEntity.ok().body(materialOmServico.getCategoriaMateriaisIndisponiveisPorCmdo(cmdo));
	}

	@GetMapping(value = "/qtd/ctgmtindisponivelcmdo/bda")
	@Operation(tags = {
			"/materiaisom" }, description = "Retorna o total de materiais indisponíveis por categoria de material de acordo com a brigada.", parameters = {
					@Parameter(name = "bda", description = "Comando") })
	public ResponseEntity<List<CategoriaMaterialIndisponivelDTO>> getCategoriaMateriaisIndisponiveisPorBda(
			@RequestParam String cmdo, @RequestParam String bda) {
		return ResponseEntity.ok().body(materialOmServico.getCategoriaMateriaisIndisponiveisPorBda(cmdo, bda));
	}

	@GetMapping(value = "/georef/unidades")
	@Operation(tags = { "/materiaisom" }, description = "Retorna os pontos de georeferência dos equipamentos")
	public ResponseEntity<List<GeoreferenciamentoUnidadeDTO>> getGeorefUnidades() {
		return ResponseEntity.ok().body(materialOmServico.getGeorefUnidades());
	}

	@GetMapping(value = "/georef/unidades/{cmdo}")
	@Operation(tags = {
			"/materiaisom" }, description = "Retorna os pontos de georeferência dos equipamentos de acordo com o comando", parameters = {
					@Parameter(name = "cmdo", description = "Comando") })
	public ResponseEntity<List<GeoreferenciamentoUnidadeDTO>> getGeorefUnidadesPorCmdo(@PathVariable String cmdo) {
		return ResponseEntity.ok().body(materialOmServico.getGeorefUnidadesPorCmdo(cmdo));
	}

	@GetMapping(value = "/georef/cmdo")
	@Operation(tags = { "/materiaisom" }, description = "Retorna os pontos de georeferência do comando")
	public ResponseEntity<List<GeoreferenciamentoCmdoDTO>> getGeorefCmdo() {
		return ResponseEntity.ok().body(materialOmServico.getGeorefCmdo());
	}

	@GetMapping(value = "/georef/cmdo/{cmdo}")
	@Operation(tags = {
			"/materiaisom" }, description = "Retorna os pontos de georeferência do comando de acordo com o comando", parameters = {
					@Parameter(name = "cmdo", description = "Comando") })
	public ResponseEntity<List<GeoreferenciamentoCmdoDTO>> getQtdGeorefPorCmdo(@PathVariable String cmdo) {
		return ResponseEntity.ok().body(materialOmServico.getQtdGeorefPorCmdo(cmdo));
	}

	@GetMapping(value = "/qtd/tipoeqp")
	@Operation(tags = { "/materiaisom" }, description = "Retorna a quantidade de materiais existentes e previstos")
	public ResponseEntity<List<QtdMaterialTipoEqpDTO>> getQtdMaterialExistentePrevisto() {
		return ResponseEntity.ok().body(materialOmServico.getQtdMaterialExistentePrevisto());
	}

	@GetMapping(value = "/qtd/tipoeqp/{cmdo}")
	@Operation(tags = {
			"/materiaisom" }, description = "Retorna a quantidade de materiais existentes e previstos de acordo com o comando", parameters = {
					@Parameter(name = "cmdo", description = "Comando") })
	public ResponseEntity<List<QtdMaterialTipoEqpDTO>> getQtdMaterialExistentePrevistoPorCmdo(
			@PathVariable String cmdo) {
		return ResponseEntity.ok().body(materialOmServico.getQtdMaterialExistentePrevistoPorCmdo(cmdo));
	}

	@GetMapping(value = "/qtd/tipoeqp/bda")
	@Operation(tags = {
			"/materiaisom" }, description = "Retorna a quantidade de materiais existentes e previstos de acordo com a brigada", parameters = {
					@Parameter(name = "cmdo", description = "Comando") })
	public ResponseEntity<List<QtdMaterialTipoEqpDTO>> getQtdMaterialExistentePrevistoPorBda(@RequestParam String cmdo,
			@RequestParam String bda) {
		return ResponseEntity.ok().body(materialOmServico.getQtdMaterialExistentePrevistoPorBda(cmdo, bda));
	}

	@GetMapping(value = "/diariaspassagens/classificacao")
	public ResponseEntity<List<ValorTotalClassificacaoDiariasPassagensDTO>> getValorTotalClassificacaoDiariasPassagens() {
		return ResponseEntity.ok().body(materialOmServico.getValorTotalClassificacaoDiariasPassagens());
	}

	@GetMapping(value = "/diariaspassagens/codao")
	public ResponseEntity<List<ValorTotalCodAoDiariasPassagensDTO>> getValorTotalCodAoDiariasPassagens() {
		return ResponseEntity.ok().body(materialOmServico.getValorTotalCodAoDiariasPassagens());
	}

	@GetMapping(value = "/qtd/material/cmdo")
	public ResponseEntity<List<QtdMaterialDisponibilidadeCmdoDTO>> getMaterialDisponibilidadePorCmdo() {
		return ResponseEntity.ok().body(materialOmServico.getMaterialDisponibilidadePorCmdo());
	}

	@GetMapping(value = "/qtd/material/cmdo/{cmdo}")
	public ResponseEntity<List<QtdMaterialDisponibilidadeCmdoDTO>> getMaterialDisponibilidadePorCmdo(
			@PathVariable String cmdo) {
		return ResponseEntity.ok().body(materialOmServico.getMaterialDisponibilidadePorCmdo(cmdo));
	}

	@GetMapping(value = "/qtd/material/cmdo/bda")
	public ResponseEntity<List<QtdMaterialDisponibilidadeCmdoDTO>> getMaterialDisponibilidadePorBda(
			@RequestParam String cmdo, @RequestParam String bda) {
		return ResponseEntity.ok().body(materialOmServico.getMaterialDisponibilidadePorBda(cmdo, bda));
	}

	@GetMapping(value = "/indisp")
	public ResponseEntity<Page<MaterialIndisponivelDTO>> getMateriaisIndisponiveis(
			Pageable pageable,
			@RequestParam(defaultValue = "") String eqp, 
			@RequestParam(defaultValue = "") String bda) {
		return ResponseEntity.ok().body(materialOmServico.getMaterialIndisponivel(pageable, eqp, bda));
	}
}