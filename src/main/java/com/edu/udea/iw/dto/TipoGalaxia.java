package com.edu.udea.iw.dto;

import java.io.Serializable;

public class TipoGalaxia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4597876411356995027L;
	private Integer id;
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
