package br.mil.eb.dashboard_sgl_sg7.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.eb.dashboard_sgl_sg7.dto.OperacoesDTO;
import br.mil.eb.dashboard_sgl_sg7.services.OperacoesService;

@RestController
@RequestMapping(value = "/operacoes")
public class OperacoesController {

	@Autowired
	private OperacoesService operacoesService;
	
	@GetMapping
	public ResponseEntity<List<OperacoesDTO>> getAll() {
		return ResponseEntity.ok().body(operacoesService.getAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OperacoesDTO> getById(@PathVariable Long id) {
		return ResponseEntity.ok().body(operacoesService.getById(id));
	}
}
