package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Cometa;
import com.edu.udea.iw.exception.MyException;

public interface CometaDAO {

	public List<Cometa> consultar() throws MyException;
	public Cometa consultaUnica(String nombre) throws MyException;
	public Boolean guardar(Cometa cometa) throws MyException;
	public Boolean actualizar(Cometa cometa) throws MyException;
	public Boolean eliminar(Cometa cometa) throws MyException;
}
