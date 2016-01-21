package com.edu.udea.iw.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

/**
 * Clase con el patron DTO para transportar los datos de las galaxias
 * @author enhanced_universe
 *
 */

@JsonDeserialize
@XmlRootElement(name="galaxias")
public class Galaxia implements Serializable {

	
	
	
	/**
	 * Serial recomendado por java para una clase que implementa la Interface Serializable 
	 */
	private static final long serialVersionUID = 6457010021439862300L;
	
	/**
	 * Id de la galaxia 
	 */
	private Integer id;
	/**
	 * Nombre completo de la galaxia 
	 */
	private String nombre;
	/**
	 * El tipo en el cual esta clasificada la galaxia 
	 */
	private TipoGalaxia tipogalaxia;
	/**
	 * Dimension del alto de la galaxia en años luz 
	 */
	private Double alto;
	/**
	 * Dimension del ancho de la galaxia en años luz
	 */
	private Double ancho;
	/**
	 * Dimension de la profundidad de la galaxia en años luz
	 */
	private Double profundidad;
	/**
	 * Diametro  de la galaxia en años luz
	 */
	private Double diametro;
	/**
	 * Distancia de la galaxia en años luz hasta la Tierra
	 */
	private Double distanciatierra;
	
	
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
	public TipoGalaxia getTipogalaxia() {
		return tipogalaxia;
	}
	public void setTipogalaxia(TipoGalaxia tipogalaxia) {
		this.tipogalaxia = tipogalaxia;
	}
	public Double getAlto() {
		return alto;
	}
	public void setAlto(Double alto) {
		this.alto = alto;
	}
	public Double getAncho() {
		return ancho;
	}
	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}
	public Double getProfundidad() {
		return profundidad;
	}
	public void setProfundidad(Double profundidad) {
		this.profundidad = profundidad;
	}
	public Double getDiametro() {
		return diametro;
	}
	public void setDiametro(Double diametro) {
		this.diametro = diametro;
	}
	public Double getDistanciatierra() {
		return distanciatierra;
	}
	public void setDistanciatierra(Double distanciatierra) {
		this.distanciatierra = distanciatierra;
	}
	
}
