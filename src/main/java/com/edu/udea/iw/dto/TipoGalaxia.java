package com.edu.udea.iw.dto;

import java.io.Serializable;

/**
 * Clase con el patron DTO para transportar los datos sobre los tipos de galaxias
 * @author enhanced_universe
 *
 */
public class TipoGalaxia implements Serializable{

	/**
	 * Serial recomendado por java para una clase que implementa la Interface Serializable
	 */
	private static final long serialVersionUID = -4597876411356995027L;
	

	/**
	 * Id del tipo de galaxia
	 */
	private Integer id;
	/**
	 * Nombre del tipo de galaxia
	 */
	private String nombre;
	
	
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
	
}
