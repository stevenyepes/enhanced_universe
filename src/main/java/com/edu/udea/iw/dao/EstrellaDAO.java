package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Estrella;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el estrella
 * @author enhanced_universe
 *
 */
public interface EstrellaDAO {
	
	/**
	 * Entrega la lista de estrellas en la base de datos
	 * @return lista estrellas
	 * @throws MyException Ocurre un error con la conexion.
	 */
	public List<Estrella> consultar() throws MyException;
	
	/**
	 * Consulta los datos de una estrella dado su nombre.
	 * @param nombre nombre de la estrella a consultar
	 * @return una instacia de los datos de la estrella consultada, si no
	 * existe una estrella con el nombre dado retorna un null.
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Estrella consultaUnica(String nombre) throws MyException;
	
	/**
	 * Guarda los datos de estrella dada.
	 * @param estrella estrella a guardar
	 * @return true si la estrella se guardo con exito, false
	 * si la galaxia no guardo correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean guardar(Estrella estrella) throws MyException;
	
	/**
	 * Actualiza los datos de estrella dada.
	 * @param estrella estrella a actualizar
	 * @return true si la estrella se actualiza con exito, false
	 * si la estrella no actualiza correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean actualizar(Estrella estrella) throws MyException;
	
	/**
	 * Elimina los datos de estrella dada.
	 * @param estrella estrella a eliminar
	 * @return true si la estrella se elimino con exito, false
	 * si la estrella no elimino correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean eliminar(Estrella estrella) throws MyException;

}
