package com.edu.udea.iw.bl;

import java.util.List;

import com.edu.udea.iw.dto.Cometa;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el bl cometa
 * @author enhanced_universe
 *
 */
public interface CometaBL {

	/**
	 * Verifica que la lista de cometas no sea vacia o nula
	 * @return lista cometas
	 * @throws MyException No hay cometas en la base de datos
	 */	
	public List<Cometa> listarCometas() throws MyException;
	
	/**
	 *Verifica que se ingrese un nombre valido del cometa para la consulta
	 * @param cometa nombre del cometa a consultar
	 * @return una instacia de los datos del cometa consultado, si no
	 * existe el cometa con el nombre dado retorna un null.
	 * @throws MyException Proporcionar nombre valido del cometa
	 */
	public Cometa listarCometa(String cometa) throws MyException;
	
	/**
	 * Verifica los datos del cometa dado para guardarlos.
	 * @param nombre nombre del cometa a guardar
	 * @param diametro diametro del cometa a guardar
	 * @param periodoorbital periodo orbital del cometa a guardar
	 * @param ultimoperielo ultimo perielio del cometa a guardar
	 * @param galaxia galaxia a la que pertenece el cometa a guardar	
	 * @return true si el cometa se guardo con exito, false
	 * si el cometa no guardo correctamente 
	 * @throws MyException Datos ingresados invalidos.
	 */
	public Boolean guardarCometa(String nombre, Double diametro, Double periodoorbital, 
			Integer ultimoperihelio, String galaxia) throws MyException;
		
	/**
	 * Verifica los datos del cometa  dado para actualizarlos.
	 * @param nombre nombre del cometa a actualizar
	 * @param diametro diametro del cometa a actualizar
	 * @param periodoorbital periodo orbital del cometa a actualizar
	 * @param ultimoperielo ultimo perielio del cometa a actualizar
	 * @param galaxia galaxia a la que pertenece el cometa a actualizar
	 * @return true si el comenta se actualiza con exito, false
	 * si el cometa no actualiza correctamente 
	 * @throws MyException Datos ingresados no validos.
	 */
	public Boolean actualizarCometa(String nombre, Double diametro, Double periodoorbital, 
			Integer ultimoperihelio, String galaxia) throws MyException;
	
	/**
	 * Verifica los datos del cometa dado para eliminar.
	 * @param cometa nombre del cometa a eliminar
	 * @return true si el cometa se elimino con exito, false
	 * si el cometa no elimino correctamente 
	 * @throws MyException Datos ingresados no validos.
	 */
	public Boolean eliminarCometa(String cometa) throws MyException;
	
}
