package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Estrella;
import com.edu.udea.iw.exception.MyException;

public interface EstrellaDAO {
	
	public List<Estrella> consultar() throws MyException;
	public Estrella consultaUnica(String nombre) throws MyException;
	public Boolean guardar(Estrella estrella) throws MyException;
	public Boolean actualizar(Estrella estrella) throws MyException;
	public Boolean eliminar(Estrella estrella) throws MyException;

}
