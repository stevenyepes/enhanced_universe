package com.edu.udea.iw.dto;

import java.io.Serializable;

public class Asteroide implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1316226061811270992L;
	
	private Integer id;
	private String nombre;
	private Double diametro;
	private Boolean peligroso;
	private Galaxia galaxia;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getDiametro() {
		return diametro;
	}
	public void setDiametro(Double diametro) {
		this.diametro = diametro;
	}
	public Boolean getPeligroso() {
		return peligroso;
	}
	public void setPeligroso(Boolean peligroso) {
		this.peligroso = peligroso;
	}
	public Galaxia getGalaxia() {
		return galaxia;
	}
	public void setGalaxia(Galaxia galaxia) {
		this.galaxia = galaxia;
	}
	
	

}
