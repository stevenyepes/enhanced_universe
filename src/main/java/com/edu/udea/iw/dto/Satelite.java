package com.edu.udea.iw.dto;

import java.io.Serializable;

public class Satelite implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2634727383228921210L;
	
	private Integer id;
	private String nombre;
	private Double masa;
	private Double gravedad;
	private Double diametro;
	private Double temperatura;
	private Double periodorotacional;
	private Double periodoorbital;
	private Planeta planeta;
	
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
	public Planeta getPlaneta() {
		return planeta;
	}
	public void setPlaneta(Planeta planeta) {
		this.planeta = planeta;
	}
	
	

}
