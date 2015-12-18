package com.edu.udea.iw.dto;

import java.io.Serializable;


/**
 * Clase con el patron DTO para transportar los datos de la estrella
 * @author enhanced_universe
 *
 */
public class Estrella implements Serializable{

	/**
	 * Serial recomendado por java para una clase que implementa la Interface Serializable 
	 */
	private static final long serialVersionUID = -4699554243740151135L;
	
	/**
	 * Id de la estrella
	 */
	private Integer id;
	/**
	 * Nombre completo de la estrella
	 */
	private String nombre;
<<<<<<< HEAD
	/**
	 * Tipo espectral de la estrella segun su color
	 */
	private String tipoespectral;
	/**
	 * Temperatura de la estrella en grados celsius
	 */
=======
	private TipoEspectral tipoespectral;
>>>>>>> 46c176cbf35e1160a425b1c6947c8c2ada7c1f95
	private Double temperatura;
	/**
	 * Clase de la estrella
	 */
	private String clase;
	/**
	 * Masa de la estrella
	 */
	private Double masa;
	/**
	 * Diametro de la estrella en kilometros
	 */
	private Double diametro;
	/**
	 * Galaxia en la que se encuentra la estrella
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
	public TipoEspectral getTipoespectral() {
		return tipoespectral;
	}
	public void setTipoespectral(TipoEspectral tipoespectral) {
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
