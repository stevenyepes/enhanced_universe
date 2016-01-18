package com.edu.udea.iw.bl;

import java.util.List;

import com.edu.udea.iw.dto.Cometa;
import com.edu.udea.iw.exception.MyException;

public interface CometaBL {

	
	public List<Cometa> listarCometas() throws MyException;
	
	
	public Cometa listarCometa(String cometa) throws MyException;
	
	
	public Boolean guardarCometa(String nombre, Double diametro, Double periodoorbital, 
			Integer ultimoperihelio, String galaxia) throws MyException;
		
	
	public Boolean actualizarCometa(String nombre, Double diametro, Double periodoorbital, 
			Integer ultimoperihelio, String galaxia) throws MyException;
	

	public Boolean eliminarCometa(String cometa) throws MyException;
	
}
