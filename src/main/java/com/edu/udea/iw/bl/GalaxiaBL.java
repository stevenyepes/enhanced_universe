package com.edu.udea.iw.bl;

import java.util.List;

import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el bl galaxia
 * @author enhanced_universe
 *
 */
public interface GalaxiaBL {

	/**
	 * Verifica que la lista de galaxias no sea vacia o nula
	 * @return lista galaxias
	 * @throws MyException No hay galaxias en la base de datos
	 */	
	public List<Galaxia> listarGalaxias() throws MyException;
	
	/**
	 *Verifica que se ingrese un nombre valido de la galaxia para la consulta
	 * @param galaxia nombre de la galaxia a consultar
	 * @return una instacia de los datos de la galaxia consultada, si no
	 * existe la galaxia con el nombre dado retorna un null.
	 * @throws MyException Proporcionar nombre valido de la galaxia
	 */
	public Galaxia listarGalaxia(String galaxia) throws MyException;
	
	/**
	 * Verifica los datos de la galaxia dada para guardarlos.
	 * @param nombre nombre de la galaxia a guardar
	 * @param tipo  tipo galaxia a guardar
	 * @param alto diametro de galaxia a guardar
	 * @param ancho ancho de galaxia a guardar
	 * @param profundidad profundidad de galaxia a guardar
	 * @param diametro galaxia a guardar
	 * @param distanciatierra distancia ala tierra de la galaxia a guardar 
	 * @return true si la galaxia se guardo con exito, false
	 * si la galaxia no guardo correctamente 
	 * @throws MyException Datos ingresados invalidos.
	 */
	public Boolean guardarGalaxia(String nombre, String tipo, Double alto, Double ancho, Double profundidad, Double diametro, Double distanciatierra) throws MyException;
		
	/**
	 * Verifica los datos de la galaxia  dada para actualizarlos.
	 * @param nombre nombre de la galaxia a actualizar
	 * @param tipo  tipo galaxia a actualizar
	 * @param alto diametro de galaxia a actualizar
	 * @param ancho ancho de galaxia a actualizar
	 * @param profundidad profundidad de galaxia a actualizar
	 * @param diametro galaxia a actualizar
	 * @param distanciatierra distancia ala tierra de la galaxia a actualizar 
	 * @return true si la galaxia se actualiza con exito, false
	 * si la galaxia no actualiza correctamente 
	 * @throws MyException Datos ingresados no validos.
	 */
	public Boolean actualizarGalaxia(String nombre, String tipo, Double alto, Double ancho, Double profundidad, Double diametro, Double distanciatierra) throws MyException;
	
	/**
	 * Verifica los datos de la galaxia dada para eliminar.
	 * @param galaxia nombre de la galaxia a eliminar
	 * @return true si la galaxia se elimino con exito, false
	 * si la galaxia no elimino correctamente 
	 * @throws MyException Datos ingresados no validos.
	 */
	public Boolean eliminarGalaxia(String galaxia) throws MyException;
	
}
