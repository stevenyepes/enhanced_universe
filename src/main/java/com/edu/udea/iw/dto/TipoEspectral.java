package com.edu.udea.iw.dto;

import java.io.Serializable;

/**
 * Clase con el patron DTO para transportar los datos de tipo espectral
 * @author enhanced_universe
 *
 */
public class TipoEspectral implements Serializable{

	/**
	 * Serial recomendado por java para una clase que implementa la Interface Serializable 
	 */
	private static final long serialVersionUID = -8120318055364358669L;
	
	/**
	 * Clasificacion del tipo espectral 
	 */
	private String clasificacion;
	/**
	 * Color que recibe el tipo espectral segun su clasificacion  
	 */
	private String color;
	/**
	 * Temperatura que recibe el tipo espectral segun su clasificacion 
	 */
	private Double temperatura;
	
	
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	
	

}
