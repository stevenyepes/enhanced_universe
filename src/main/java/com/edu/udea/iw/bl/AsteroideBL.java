package com.edu.udea.iw.bl;

import java.util.List;

import com.edu.udea.iw.dto.Asteroide;
import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.exception.MyException;

public interface AsteroideBL {

	public List<Asteroide> listarAsteroides() throws MyException;
	

	public Asteroide listarAsteroide(String asteroide) throws MyException;
	

	public Boolean guardarAsteroide(String nombre, Double diametro,Boolean peligroso, String galaxia) throws MyException;
		

	public Boolean actualizarAsteroide(String nombre, Double diametro,Boolean peligroso, String galaxia) throws MyException;
	
	
	public Boolean eliminarAsteroide(String asteroide) throws MyException;
}
