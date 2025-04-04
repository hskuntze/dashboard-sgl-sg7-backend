package br.mil.eb.dashboard_sgl_sg7.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.eb.dashboard_sgl_sg7.dto.SituacaoRiscoDTO;
import br.mil.eb.dashboard_sgl_sg7.services.SituacaoRiscoService;

@RestController
@RequestMapping(value = "/situacaorisco")
public class SituacaoRiscoController {

	@Autowired
	private SituacaoRiscoService situacaoRiscoService;
	
	@GetMapping
	public ResponseEntity<List<SituacaoRiscoDTO>> getAll() {
		return ResponseEntity.ok().body(situacaoRiscoService.getAll());
	}
}
