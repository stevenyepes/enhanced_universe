package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.exception.MyException;

public interface GalaxiaDAO {

	public List<Galaxia> consultar() throws MyException;
	public Galaxia consultaUnica(String nombre) throws MyException;
	public Boolean guardar(Galaxia galaxia) throws MyException;
	public Boolean actualizar(Galaxia galaxia) throws MyException;
	public Boolean eliminar(Galaxia galaxia) throws MyException;
}
