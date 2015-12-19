package com.edu.udea.iw.bl;

import java.util.List;

import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.exception.MyException;

public interface GalaxiaBL {

	public List<Galaxia> listarGalaxias() throws MyException;
	public Galaxia listarGalaxia(String galaxia) throws MyException;
	public Boolean guardarGarlaxia(String nombre, String tipo, Double alto, Double ancho, Double profundidad, Double diametro, Double distanciatierra) throws MyException;
	public Boolean actualizarGalaxia(String nombre, String tipo, Double alto, Double ancho, Double profundidad, Double diametro, Double distanciatierra) throws MyException;
	public Boolean eliminarGalaxia(String galaxia) throws MyException;
	
}
