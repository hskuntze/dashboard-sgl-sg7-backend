package br.mil.eb.dashboard_sgl_sg7.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.eb.dashboard_sgl_sg7.dto.RestanteValorAnoDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.TipoAcaoValorDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.UnidadeOrcamentariaDTO;
import br.mil.eb.dashboard_sgl_sg7.services.ExecucaoOrcamentariaService;

@RestController
@RequestMapping(value = "/execucao")
public class ExecucaoOrcamentariaController {

	@Autowired
	private ExecucaoOrcamentariaService execucaoOrcamentariaService;
	
	@GetMapping(value = "/diarias")
	public ResponseEntity<List<UnidadeOrcamentariaDTO>> getDiariasPorUg() {
		return ResponseEntity.ok().body(execucaoOrcamentariaService.getDiariasPorUg());
	}
	
	@GetMapping(value = "/passagens")
	public ResponseEntity<List<UnidadeOrcamentariaDTO>> getPassagensPorUg() {
		return ResponseEntity.ok().body(execucaoOrcamentariaService.getPassagensPorUg());
	}
	
	@GetMapping(value = "/ug")
	public ResponseEntity<List<UnidadeOrcamentariaDTO>> getExecucaoPorUg() {
		return ResponseEntity.ok().body(execucaoOrcamentariaService.getExecucaoPorUg());
	}
	
	@GetMapping(value = "/elemento")
	public ResponseEntity<List<UnidadeOrcamentariaDTO>> getExecucaoPorElemento() {
		return ResponseEntity.ok().body(execucaoOrcamentariaService.getExecucaoPorElemento());
	}
	
	@GetMapping(value = "/2024")
	public ResponseEntity<List<UnidadeOrcamentariaDTO>> getExecucaoOrcamentaria2024() {
		return ResponseEntity.ok().body(execucaoOrcamentariaService.getExecucaoOrcamentaria2024());
	}
	
	@GetMapping(value = "/2025")
	public ResponseEntity<List<UnidadeOrcamentariaDTO>> getExecucaoOrcamentaria2025() {
		return ResponseEntity.ok().body(execucaoOrcamentariaService.getExecucaoOrcamentaria2025());
	}
	
	@GetMapping(value = "/2024/tipoacao")
	public ResponseEntity<List<UnidadeOrcamentariaDTO>> getExecucaoOrcamentaria2024TipoAcao() {
		return ResponseEntity.ok().body(execucaoOrcamentariaService.getExecucaoOrcamentaria2024TipoAcao());
	}
	
	@GetMapping(value = "/2025/tipoacao")
	public ResponseEntity<List<UnidadeOrcamentariaDTO>> getExecucaoOrcamentaria2025TipoAcao() {
		return ResponseEntity.ok().body(execucaoOrcamentariaService.getExecucaoOrcamentaria2025TipoAcao());
	}
	
	@GetMapping(value = "/restante")
	public ResponseEntity<List<RestanteValorAnoDTO>> getValorRestantePorAno() {
		return ResponseEntity.ok().body(execucaoOrcamentariaService.getValorRestantePorAno());
	}
	
	@GetMapping(value = "/tipo")
	public ResponseEntity<List<TipoAcaoValorDTO>> getValorTipoAcao() {
		return ResponseEntity.ok().body(execucaoOrcamentariaService.getTipoAcaoValor());
	}
}
