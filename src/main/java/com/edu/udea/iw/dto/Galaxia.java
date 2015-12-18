package com.edu.udea.iw.dto;

import java.io.Serializable;

public class Galaxia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6457010021439862300L;
	
	private Integer id;
	private String nombre;
	private TipoGalaxia tipogalaxia;
	private Double alto;
	private Double ancho;
	private Double profundidad;
	private Double diametro;
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
