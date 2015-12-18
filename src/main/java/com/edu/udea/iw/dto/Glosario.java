package com.edu.udea.iw.dto;

import java.io.Serializable;

public class Glosario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8623640273954487550L;
	
	private Integer id;
	private String termino;
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
