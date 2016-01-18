package com.edu.udea.iw.bl;

import java.util.List;


import com.edu.udea.iw.dto.Satelite;
import com.edu.udea.iw.exception.MyException;

public interface SateliteBL {

	public Satelite buscarSatelite(String satelite) throws MyException;
	

	public List<Satelite> listarSalites() throws MyException;

	public Boolean guardarsatelite(String nombre, Double masa, Double gravedad, Double diametro, Double temperatura, Double periodoRotacional,
			Double periodoOrbital, String planeta) throws MyException;

	public Boolean actualizarSatelite(String nombre, Double masa, Double gravedad, Double diametro, Double temperatura, Double periodoRotacional,
			Double periodoOrbital, String planeta) throws MyException;
	

	public Boolean eliminarSatelite(String satelite) throws MyException;
}
