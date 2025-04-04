package br.mil.eb.dashboard_sgl_sg7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.eb.dashboard_sgl_sg7.services.SafeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "/safe")
@SecurityRequirement(name = "dashboard-sgl-sg7-doc-scheme")
public class SafeController {

	@Autowired
	private SafeService safeService;

	@GetMapping(value = "/contratos")
	public ResponseEntity<Integer> getTotalContratos(){
		return ResponseEntity.ok().body(safeService.getTotalContratos());
	}

	@GetMapping(value = "/etapas")
	public ResponseEntity<Integer> getTotalEtapas(){
		return ResponseEntity.ok().body(safeService.getTotalEtapas());
	}
}
