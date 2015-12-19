package com.edu.udea.iw.dto;

import java.io.Serializable;


/**
 * Clase con el patron DTO para transportar los datos del satelite
 * @author enhanced_universe
 *
 */
public class Satelite implements Serializable{

	/**
	 * Serial recomendado por java para una clase que implementa la Interface Serializable 
	 */
	private static final long serialVersionUID = 2634727383228921210L;
	
	/**
	 * Id del satelite
	 */
	private Integer id;
	/**
	 * Nombre completo del satelite
	 */
	private String nombre;
	/**
	 * Masa del satelite
	 */
	private Double masa;
	/**
	 * Gravedad del satelite en metros sobre segundos
	 */
	private Double gravedad;
	/**
	 * Diametro del satelite en kilometros
	 */
	private Double diametro;
	/**
	 * Temperatura del satelite en grados celsius
	 */
	private Double temperatura;
	/**
	 * Tiempo del satelite en dar una vuelta sobre si mismo
	 */
	private Double periodorotacional;
	/**
	 * Tiempo del satelite en dar una vuelta alrededor del astro que orbita 
	 */
	private Double periodoorbital;
	/**
	 * Planeta al cual el satelite rodea
	 */
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
