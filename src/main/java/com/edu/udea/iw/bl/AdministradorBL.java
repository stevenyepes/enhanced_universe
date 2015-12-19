package com.edu.udea.iw.bl;

import java.util.List;

import com.edu.udea.iw.dto.Administrador;
import com.edu.udea.iw.exception.MyException;

public interface AdministradorBL {
	
	public List<Administrador> listarAdministradores () throws MyException;
	public Administrador listarAdministrador (String usuario) throws MyException;
	public Boolean guardarAdministrador (String usuario, String email, String nombre, String apellido, String contrasena) throws MyException;
	public Boolean actualizarAdministrador (String usuario, String email, String nombre, String apellido, String contrasena) throws MyException;
	public Boolean eliminarAdministrador (String usuario) throws MyException;
	public Boolean validarAdministrador (String usuario, String contrasena) throws MyException;
	
}
