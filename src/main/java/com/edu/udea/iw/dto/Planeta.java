package com.edu.udea.iw.dto;

import java.io.Serializable;

public class Planeta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -178767740576164371L;

	private Integer id;
	private String nombre;
	private Double masa;
	private Double gravedad;
	private Double diametro;
	private Double temperatura;
	private Double periodorotacional;
	private Double periodoorbital;
	private Double distanciatierra;
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
	public Double getMasa() {
		return masa;
	}
	public void setMasa(Double masa) {
		this.masa = masa;
	}
	public Double getGravedad() {
		return gravedad;
	}
	public void setGravedad(Double gravedad) {
		this.gravedad = gravedad;
	}
	public Double getDiametro() {
		return diametro;
	}
	public void setDiametro(Double diametro) {
		this.diametro = diametro;
	}
	public Double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	public Double getPeriodorotacional() {
		return periodorotacional;
	}
	public void setPeriodorotacional(Double periodorotacional) {
		this.periodorotacional = periodorotacional;
	}
	public Double getPeriodoorbital() {
		return periodoorbital;
	}
	public void setPeriodoorbital(Double periodoorbital) {
		this.periodoorbital = periodoorbital;
	}
	public Double getDistanciatierra() {
		return distanciatierra;
	}
	public void setDistanciatierra(Double distanciatierra) {
		this.distanciatierra = distanciatierra;
	}
	public Galaxia getGalaxia() {
		return galaxia;
	}
	public void setGalaxia(Galaxia galaxia) {
		this.galaxia = galaxia;
	}
	
	
	
	
}
