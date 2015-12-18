package com.edu.udea.iw.dto;

import java.io.Serializable;


/**
 * Clase con el patron DTO para transportar los datos de los planetas
 * @author enhanced_universe
 *
 */
public class Planeta implements Serializable{

	/**
	 * Serial recomendado por java para una clase que implementa la Interface Serializable 
	 */
	private static final long serialVersionUID = -178767740576164371L;
	
	/**
	 * Id del planeta	 
	 */
	private Integer id;
	/**
	 * Nombre completo del planeta	 
	 */
	private String nombre;
	/**
	 * Masa del planeta	 en kilogramos
	 */
	private Double masa;
	/**
	 * Gravedad del planeta en metros sobre segundos al cuadrado	 
	 */
	private Double gravedad;
	/**
	 * Diametro del planeta	 en kilometros
	 */
	private Double diametro;
	/**
	 * Temperatura del planeta en grados celsius  
	 */
	private Double temperatura;
	/**
	 * Tiempo que tarda el planeta en dar una vuelta sobre si mismo	 en horas
	 */
	private Double periodorotacional;
	/**
	 * Tiempo que tarda el planeta en dar una vuelta al rededor de su sol en años	 
	 */
	private Double periodoorbital;
	/**
	 * Distancia a la que se encuentra el planeta de la Tierra en años luz
	 */
	private Double distanciatierra;
	/**
	 * Galaxia en la que se encuentra ubicado el planeta	 
	 */
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
