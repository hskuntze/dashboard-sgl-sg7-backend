package br.mil.eb.dashboard_sgl_sg7.dto;

import java.io.Serializable;

import br.mil.eb.dashboard_sgl_sg7.entities.sgl.Posto;

public class PostoDTO implements Serializable {
	private static final long serialVersionUID = 4214692621779130819L;

	private Long id;
	private String titulo;

	public PostoDTO() {
	}

	public PostoDTO(Posto p) {
		this.id = p.getId();
		this.titulo = p.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
