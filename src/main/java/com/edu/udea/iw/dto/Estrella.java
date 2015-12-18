package com.edu.udea.iw.dto;

import java.io.Serializable;

public class Estrella implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4699554243740151135L;

	private Integer id;
	private String nombre;
	private String tipoespectral;
	private Double temperatura;
	private String clase;
	private Double masa;
	private Double diametro;
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
	public String getTipoespectral() {
		return tipoespectral;
	}
	public void setTipoespectral(String tipoespectral) {
		this.tipoespectral = tipoespectral;
	}
	public Double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public Double getMasa() {
		return masa;
	}
	public void setMasa(Double masa) {
		this.masa = masa;
	}
	public Double getDiametro() {
		return diametro;
	}
	public void setDiametro(Double diametro) {
		this.diametro = diametro;
	}
	public Galaxia getGalaxia() {
		return galaxia;
	}
	public void setGalaxia(Galaxia galaxia) {
		this.galaxia = galaxia;
	}
	
	
	
}
