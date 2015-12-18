package com.edu.udea.iw.dto;

import java.io.Serializable;

public class Cometa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5818229292591093223L;

	private Integer id;
	private String nombre;
	private Double diametro;
	private Double periodoorbital;
	private Integer ultimoperihelio;
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
	public Double getPeriodoorbital() {
		return periodoorbital;
	}
	public void setPeriodoorbital(Double periodoorbital) {
		this.periodoorbital = periodoorbital;
	}
	public Integer getUltimoperihelio() {
		return ultimoperihelio;
	}
	public void setUltimoperihelio(Integer ultimoperihelio) {
		this.ultimoperihelio = ultimoperihelio;
	}
	public Galaxia getGalaxia() {
		return galaxia;
	}
	public void setGalaxia(Galaxia galaxia) {
		this.galaxia = galaxia;
	}
	
	
}
