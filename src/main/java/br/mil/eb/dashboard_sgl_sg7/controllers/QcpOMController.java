package br.mil.eb.dashboard_sgl_sg7.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.mil.eb.dashboard_sgl_sg7.dto.QcpOMCompletoDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QcpOMDTO;
import br.mil.eb.dashboard_sgl_sg7.services.QcpOMService;

@RestController
@RequestMapping(value = "/qcpom")
public class QcpOMController {

	@Autowired
	private QcpOMService qcpOmService;
	
	@GetMapping
	public ResponseEntity<List<QcpOMDTO>> getGeorefQcpOm() {
		return ResponseEntity.ok().body(qcpOmService.getGeorefQcpOM());
	}
	
	@GetMapping(value = "/cmdo")
	public ResponseEntity<Page<QcpOMCompletoDTO>> getAllByCmdo(Pageable pageable, @RequestParam(defaultValue = "") String cmdo) {
		return ResponseEntity.ok().body(qcpOmService.getAllByCmdo(pageable, cmdo));
	}
}
