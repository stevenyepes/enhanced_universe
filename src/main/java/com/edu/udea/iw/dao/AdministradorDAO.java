package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Administrador;
import com.edu.udea.iw.exception.MyException;

public interface AdministradorDAO {

	public List<Administrador> consultar() throws MyException;
	public Administrador consultaUnica(String usuario) throws MyException;
	public Boolean guardar(Administrador administrador) throws MyException;
	public Boolean actualizar(Administrador administrador) throws MyException;
	public Boolean eliminar(Administrador administrador) throws MyException;
}
