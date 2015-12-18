package com.edu.udea.iw.dto;

import java.io.Serializable;

/**
 * Clase con el patron DTO para transportar los datos de los cometas
 * @author enhanced_universe
 *
 */
public class Cometa implements Serializable {

	/**
	 * Serial recomendado por java para una clase que implementa la Interface Serializable 
	 */
	private static final long serialVersionUID = 5818229292591093223L;
	
	/**
	 * Id del cometa
	 */
	private Integer id;
	/**
	 * Nombre completo del cometa 
	 */
	private String nombre;
	/**
	 * Diametro del cometa en kilometros 
	 */
	private Double diametro;
	/**
	 * Tiempo que tarda la orbita del cometa 
	 */
	private Double periodoorbital;
	/**
	 * Ultimo año en el cual estubo cerca el cometa
	 */
	private Integer ultimoperihelio;
	/**
	 * Galaxia en la cual se mueve el cometa
	 */
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
