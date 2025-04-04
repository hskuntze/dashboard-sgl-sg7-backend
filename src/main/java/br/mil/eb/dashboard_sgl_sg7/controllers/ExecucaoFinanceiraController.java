package br.mil.eb.dashboard_sgl_sg7.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mil.eb.dashboard_sgl_sg7.dto.ExecucaoFinanceiraDTO;
import br.mil.eb.dashboard_sgl_sg7.services.ExecucaoFinanceiraService;

@RestController
@RequestMapping(value = "/execucaofinanceira")
public class ExecucaoFinanceiraController {

	@Autowired
	private ExecucaoFinanceiraService execucaoFinanceiraService;
	
	@GetMapping
	public ResponseEntity<List<ExecucaoFinanceiraDTO>> getAll() {
		return ResponseEntity.ok().body(execucaoFinanceiraService.getAll());
	}
}
