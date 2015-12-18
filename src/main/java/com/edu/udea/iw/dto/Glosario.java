package com.edu.udea.iw.dto;

import java.io.Serializable;

/**
 * Clase con el patron DTO para transportar los datos del glosario
 * @author enhanced_universe
 *
 */
public class Glosario implements Serializable{

	/**
	 * Serial recomendado por java para una clase que implementa la Interface Serializable 
	 */
	private static final long serialVersionUID = -8623640273954487550L;
	
	/**
	 * Id del glosario 
	 */
	private Integer id;
	/**
	 * Termino a definir en el glosario 
	 */
	private String termino;
	/**
	 * Definicion del termino en el glosario 
	 */
	private String definicion;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTermino() {
		return termino;
	}
	public void setTermino(String termino) {
		this.termino = termino;
	}
	public String getDefinicion() {
		return definicion;
	}
	public void setDefinicion(String definicion) {
		this.definicion = definicion;
	}
	
	

}
