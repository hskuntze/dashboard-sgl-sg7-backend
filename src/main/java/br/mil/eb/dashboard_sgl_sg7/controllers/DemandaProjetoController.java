package br.mil.eb.dashboard_sgl_sg7.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.eb.dashboard_sgl_sg7.dto.DemandaProjetoDTO;
import br.mil.eb.dashboard_sgl_sg7.services.DemandaProjetoService;

@RestController
@RequestMapping(value = "/demandaprojeto")
public class DemandaProjetoController {

	@Autowired
	private DemandaProjetoService demandaProjetoService;
	
	@GetMapping
	public ResponseEntity<List<DemandaProjetoDTO>> getAll() {
		return ResponseEntity.ok().body(demandaProjetoService.getAll());
	}
}
