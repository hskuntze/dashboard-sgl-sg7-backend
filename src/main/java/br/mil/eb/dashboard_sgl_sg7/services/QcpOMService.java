package br.mil.eb.dashboard_sgl_sg7.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mil.eb.dashboard_sgl_sg7.dto.QcpOMCompletoDTO;
import br.mil.eb.dashboard_sgl_sg7.dto.QcpOMDTO;
import br.mil.eb.dashboard_sgl_sg7.entities.sg7.Coordenadas;
import br.mil.eb.dashboard_sgl_sg7.repositories.sg7.QcpOMRepository;

@Service
public class QcpOMService {

	@Autowired
	private QcpOMRepository qcpOmRepository;

	private static final Map<String, Coordenadas> CMDO_COORDENADAS = Map.of("CMS", new Coordenadas("-51.2", "-30.1"),
			"CMSE", new Coordenadas("-46.6", "-23.5"), "CMP", new Coordenadas("-47.8", "-15.7"), "CMO",
			new Coordenadas("-54.6", "-20.4"), "CMN", new Coordenadas("-48.4", "-1.4"), "CMNE",
			new Coordenadas("-34.9", "-8"), "CML", new Coordenadas("-43.4", "-22.8"), "CMA",
			new Coordenadas("-60", "-3.1"));

	@Transactional(readOnly = true)
	public List<QcpOMDTO> getGeorefQcpOM() {
		return qcpOmRepository.getGeorefQcpOM().stream().map(el -> {
			Coordenadas coordenadasFixas = CMDO_COORDENADAS.getOrDefault(el.getCmdo(),
					new Coordenadas(el.getLongitude(), el.getLatitude()));

			return new QcpOMDTO(el.getCmdo(), coordenadasFixas.getLatitude(), coordenadasFixas.getLongitude(),
					el.getPrevisto(), el.getEfetivo());
		}).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public Page<QcpOMCompletoDTO> getAllByCmdo(Pageable pageable, String cmdo) {
		return qcpOmRepository.getAllByCmdo(pageable, cmdo).map(el -> new QcpOMCompletoDTO(el));
	}
}
