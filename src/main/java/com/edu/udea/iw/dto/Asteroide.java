package com.edu.udea.iw.dto;

import java.io.Serializable;


/**
 * Clase con el patron DTO para transportar los datos de los asteroides
 * @author enhanced_universe
 *
 */
public class Asteroide implements Serializable{

	/**
	 * Serial recomendado por java para una clase que implementa la Interface Serializable
	 */
	private static final long serialVersionUID = -1316226061811270992L;
	
	/**
	 * Id del asteroide
	 */
	private Integer id;
	/**
	 * Nombre completo del asteroide
	 */
	private String nombre;
	/**
	 * Diametro del asteroide en kilometros
	 */
	private Double diametro;
	/**
	 * Booleano que es verdadero si el asteroide supone un peligro para la Tierra
	 */
	private Boolean peligroso;
	/**
	 * Galaxia en la cual se mueve el asteroide
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
