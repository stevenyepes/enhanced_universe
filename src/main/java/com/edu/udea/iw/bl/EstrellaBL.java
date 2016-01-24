package com.edu.udea.iw.bl;

import java.util.List;

import com.edu.udea.iw.dto.Estrella;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el bl estrella
 * @author enhanced_universe
 *
 */
public interface EstrellaBL {
	
	/**
	 * Verifica que la lista de estrellas no sea vacia o nula
	 * @return lista estrellas
	 * @throws MyException No hay estrellas en la base de datos
	 */	
	public List<Estrella> listarEstrellas() throws MyException;
	
	/**
	 *Verifica que se ingrese un nombre valido de la estrella para la consulta
	 * @param estrella nombre de la estrella a consultar
	 * @return una instacia de los datos de la estrella consultada, si no
	 * existe la estrella con el nombre dado retorna un null.
	 * @throws MyException Proporcionar nombre valido de la estrella
	 */
	public Estrella listarEstrella(String estrella) throws MyException;
	
	/**
	 * Verifica los datos de la estrella dada para guardarlos.
	 * @param nombre nombre de la estrella a guardar
	 * @param tipoespectral  tipo espectral de la estrella a guardar
	 * @param temperatura temperatura de estrella a guardar
	 * @param clase clase de estrella a guardar
	 * @param masa masa de estrella a guardar
	 * @param diametro diametro de estrella a guardar
	 * @param galaxia galaxia a la que pertenece la estrella a guardar 
	 * @return true si la estrella se guardo con exito, false
	 * si la estrella no guardo correctamente 
	 * @throws MyException Datos ingresados invalidos.
	 */
	public Boolean guardarEstrella(String nombre, String tipoespectral, Double temperatura, 
			String clase, Double masa, Double diametro, String galaxia) throws MyException;
		
	/**
	 * Verifica los datos de la estrella  dada para actualizarlos.
	 * @param nombre nombre de la estrella a actualizar
	 * @param tipoespectral  tipo espectral de la estrella a actualizar
	 * @param temperatura temperatura de estrella a actualizar
	 * @param clase clase de estrella a actualizar
	 * @param masa masa de estrella a actualizar
	 * @param diametro diametro de estrella a actualizar
	 * @param galaxia galaxia a la que pertenece la estrella a actualizar 
	 * @return true si la estrella se actualiza con exito, false
	 * si la estrella no actualiza correctamente 
	 * @throws MyException Datos ingresados no validos.
	 */
	public Boolean actualizarEstrella(String nombre, String tipoespectral, Double temperatura, 
			String clase, Double masa, Double diametro, String galaxia) throws MyException;
	
	/**
	 * Verifica los datos de la estrella dada para eliminar.
	 * @param estrella nombre de la estrella a eliminar
	 * @return true si la estrella se elimino con exito, false
	 * si la estrella no elimino correctamente 
	 * @throws MyException Datos ingresados no validos.
	 */
	public Boolean eliminarEstrella(String estrella) throws MyException;
	
}
