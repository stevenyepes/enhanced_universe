package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Planeta;
import com.edu.udea.iw.exception.MyException;

public interface PlanetaDAO {

	public List<Planeta> consultar() throws MyException;
	public Planeta consultaUnica(String nombre) throws MyException;
	public Boolean guardar(Planeta planeta) throws MyException;
	public Boolean actualizar(Planeta planeta) throws MyException;
	public Boolean eliminar(Planeta planeta) throws MyException;
}
