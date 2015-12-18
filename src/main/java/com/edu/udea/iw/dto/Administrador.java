package com.edu.udea.iw.dto;

import java.io.Serializable;

/**
 * Clase con el patron DTO para transportar los datos del administrador
 * @author enhanced_universe
 *
 */
public class Administrador implements Serializable{

	/**
	 * Serial recomendado por java para una clase que implementa la Interface Serializable
	 */
	private static final long serialVersionUID = 4523998353701882262L;
	
	/**
	 * Usuario con el cual se identifica el administrador
	 */
	private String usuario;
	/**
	 * Correo electronico del administrador
	 */
	private String email;
	/**
	 * Nombre del administrador
	 */
	private String nombre;
	/**
	 * Apellidos del administrador
	 */
	private String apellido;
	/**
	 * Contraseña de autenticacion del administrador
	 */
	private String contrasena;
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
