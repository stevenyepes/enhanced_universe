package com.edu.udea.iw.bl;


import java.util.List;


import com.edu.udea.iw.dto.Planeta;
import com.edu.udea.iw.exception.MyException;

public interface PlanetaBL {


	public Planeta buscarPlaneta(String planeta) throws MyException;
	

	public List<Planeta> listarPlanetas() throws MyException;

	public Boolean guardarPlaneta(String nombre, Double masa, Double gravedad, Double diametro, Double temperatura, Double periodoRotacional,
			Double periodoOrbital, Double distanciaTierra, String galaxia) throws MyException;

	public Boolean actualizarPlaneta(String nombre, Double masa, Double gravedad, Double diametro, Double temperatura, Double periodoRotacional,
			Double periodoOrbital, Double distanciaTierra, String galaxia) throws MyException;
	

	public Boolean eliminarPlaneta(String Planeta) throws MyException;
}
