package br.mil.eb.dashboard_sgl_sg7.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.mil.eb.dashboard_sgl_sg7.dto.OMDTO;
import br.mil.eb.dashboard_sgl_sg7.services.OMServico;

@RestController
@RequestMapping(value = "/oms")
public class OMController {

	@Autowired
	private OMServico omServico;
	
	@GetMapping
	public ResponseEntity<List<OMDTO>> buscarTodos() {
		return ResponseEntity.ok().body(omServico.buscarTodos());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OMDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok().body(omServico.buscarPorId(id));
	}
	
	@GetMapping(value = "/bdas")
	public ResponseEntity<List<String>> buscarBDAsDistintos() {
		return ResponseEntity.ok().body(omServico.buscarBDAsDistintos());
	}
	
	@PostMapping(value = "/registrar")
	public ResponseEntity<OMDTO> registrar(@RequestBody OMDTO dto) {
		OMDTO entity = omServico.registrar(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getCodigo())
				.toUri();
		
		return ResponseEntity.created(uri).body(entity);
	}
	
	/**
	 * --------- PUT ---------
	 */

	@PutMapping(value = "/atualizar/{codigo}")
	public ResponseEntity<OMDTO> registrar(@PathVariable Long codigo, @RequestBody OMDTO dto) {
		OMDTO entity = omServico.atualizar(codigo, dto);
		return ResponseEntity.ok().body(entity);
	}
	
	/**
	 * --------- DELETE ---------
	 */
	
	@DeleteMapping(value = "/deletar/{codigo}")
	public ResponseEntity<Void> deletar(@PathVariable Long codigo) {
		omServico.deletar(codigo);
		return ResponseEntity.noContent().build();
	}
}
