package com.edu.udea.iw.dto;

import java.io.Serializable;

public class Administrador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4523998353701882262L;

	private String usuario;
	private String email;
	private String nombre;
	private String apellido;
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
