package br.mil.eb.dashboard_sgl_sg7.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.mil.eb.dashboard_sgl_sg7.dto.MaterialChamadoSad2DTO;
import br.mil.eb.dashboard_sgl_sg7.dto.MaterialDTO;
import br.mil.eb.dashboard_sgl_sg7.entities.sgl.Material;
import br.mil.eb.dashboard_sgl_sg7.repositories.sgl.MaterialRepository;
import br.mil.eb.dashboard_sgl_sg7.services.exceptions.RecursoNaoEncontradoException;

@Service
public class MaterialServico {

	@Autowired
	private MaterialRepository materialRepositorio;

	@Transactional(readOnly = true)
	public List<MaterialDTO> getAll() {
		List<Material> materiais = materialRepositorio.findAll();
		return materiais.stream().map(m -> new MaterialDTO(m)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public MaterialDTO getById(Long id) {
		Material m = materialRepositorio.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Material com ID " + id + " não foi encontrado"));
		return new MaterialDTO(m);
	}

	@Transactional(readOnly = true)
	public Material getEntityById(Long id) {
		Material m = materialRepositorio.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Material com ID " + id + " não foi encontrado"));
		return m;
	}

	@Transactional(readOnly = true)
	public List<MaterialChamadoSad2DTO> getMaterialsByOm(Long omCodigo) {
		List<MaterialChamadoSad2DTO> materiais = materialRepositorio.findMaterialsByOm(omCodigo);
		return materiais;
	}

	@Transactional
	public MaterialDTO register(MaterialDTO dto) {
		Material m = new Material();
		dtoToEntity(m, dto);
		m = materialRepositorio.save(m);

		return new MaterialDTO(m);
	}

	@Transactional
	public MaterialDTO update(Long id, MaterialDTO dto) {
		Material m = materialRepositorio.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Material com ID " + id + " não foi encontrado"));
		dtoToEntity(m, dto);
		m = materialRepositorio.save(m);

		return new MaterialDTO(m);
	}

	public void delete(Long id) {
		materialRepositorio.deleteById(id);
	}

	private void dtoToEntity(Material m, MaterialDTO dto) {
	    m.setPn(dto.getPn());
	    m.setNomenclatura(dto.getNomenclatura());
	    m.setCodigoembraer(dto.getCodigoembraer());
	    m.setCodigoestocagem(dto.getCodigoestocagem());
	    m.setDescricaopningles(dto.getDescricaopningles());
	    m.setDescricaopnportugues(dto.getDescricaopnportugues());
	    m.setFabricante(dto.getFabricante());
	    m.setNsn(dto.getNsn());
	    m.setPeso(dto.getPeso());
	    m.setMtbf(dto.getMtbf());
	    m.setQdtembalagem(dto.getQdtembalagem());
	    m.setTempovidautil(dto.getTempovidautil());
	    m.setTempoestoque(dto.getTempoestoque());
	    m.setMaterialperigoso(dto.getMaterialperigoso());
	    m.setCodicaoestocagem(dto.getCodicaoestocagem());
	    m.setClasse(dto.getClasse());
	    m.setIdsigelog(dto.getIdsigelog());
	    m.setObservacao(dto.getObservacao());
	}

}
