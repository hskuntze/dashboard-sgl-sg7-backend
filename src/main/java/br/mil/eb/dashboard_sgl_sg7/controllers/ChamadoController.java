package br.mil.eb.dashboard_sgl_sg7.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.eb.dashboard_sgl_sg7.dto.QtdChamadoAnoDTO;
import br.mil.eb.dashboard_sgl_sg7.services.ChamadoServico;

@RestController
@RequestMapping(value = "/chamados")
public class ChamadoController {

	@Autowired
	private ChamadoServico chamadoService;

	@GetMapping
	public ResponseEntity<Integer> getQuantidadeChamados() {
		return ResponseEntity.ok().body(chamadoService.getQuantidadeChamados());
	}

	@GetMapping(value = "/abertos")
	public ResponseEntity<Integer> getQuantidadeChamadosAbertos() {
		return ResponseEntity.ok().body(chamadoService.getQuantidadeChamadosAbertos());
	}

	@GetMapping(value = "/ano")
	public ResponseEntity<List<QtdChamadoAnoDTO>> getQuantidadeChamadosAno() {
		return ResponseEntity.ok().body(chamadoService.getQuantidadeChamadosAno());
	}
}