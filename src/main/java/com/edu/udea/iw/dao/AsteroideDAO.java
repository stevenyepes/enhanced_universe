package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Asteroide;
import com.edu.udea.iw.exception.MyException;

public interface AsteroideDAO {

	public List<Asteroide> consultar() throws MyException;
	public Asteroide consultaUnica(String nombre) throws MyException;
	public Boolean guardar(Asteroide asteroide) throws MyException;
	public Boolean actualizar(Asteroide asteroide) throws MyException;
	public Boolean eliminar(Asteroide asteroide) throws MyException;
	
}
