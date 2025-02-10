package br.mil.eb.dashboard_sgl_sg7.dto;

import br.mil.eb.dashboard_sgl_sg7.entities.sgl.Material;

public class MaterialChamadoSad2DTO {

	private Material material;
	private String subsistema;
	private String numeroserie;

	public MaterialChamadoSad2DTO() {
	}

	public MaterialChamadoSad2DTO(Material material, String subsistema, String numeroserie) {
		this.material = material;
		this.subsistema = subsistema;
		this.numeroserie = numeroserie;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public String getSubsistema() {
		return subsistema;
	}

	public void setSubsistema(String subsistema) {
		this.subsistema = subsistema;
	}

	public String getNumeroserie() {
		return numeroserie;
	}

	public void setNumeroserie(String numeroserie) {
		this.numeroserie = numeroserie;
	}
}