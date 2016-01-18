package com.edu.udea.iw.bl;

import java.util.List;

import com.edu.udea.iw.dto.Estrella;
import com.edu.udea.iw.exception.MyException;

public interface EstrellaBL {

public List<Estrella> listarEstrellas() throws MyException;
	
	
	public Estrella listarEstrella(String estrella) throws MyException;
	
	
	public Boolean guardarEstrella(String nombre, String tipoespectral, Double temperatura, 
			String clase, Double masa, Double diametro, String galaxia) throws MyException;
		
	
	public Boolean actualizarEstrella(String nombre, String tipoespectral, Double temperatura, 
			String clase, Double masa, Double diametro, String galaxia) throws MyException;
	

	public Boolean eliminarEstrella(String estrella) throws MyException;
	
}
