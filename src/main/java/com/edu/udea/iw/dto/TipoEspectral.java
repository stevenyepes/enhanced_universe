package com.edu.udea.iw.dto;

import java.io.Serializable;

public class TipoEspectral implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8120318055364358669L;
	
	private String clasificacion;
	private String color;
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
