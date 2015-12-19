package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el dao galaxia
 * @author enhanced_universe
 *
 */
public interface GalaxiaDAO {
	
	/**
	 * Entrega la lista de galaxias en la base de datos
	 * @return lista galaxias
	 * @throws MyException Ocurre un error con la conexión.
	 */
	public List<Galaxia> consultar() throws MyException;
	
	/**
	 * Consulta los datos de una galaxia dado su nombre.
	 * @param nombre nombre de la galaxia a consultar
	 * @return una instacia de los datos de la galaxia consultada, si no
	 * existe una galaxia con el nombre dado retorna un null.
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Galaxia consultaUnica(String nombre) throws MyException;
	
	/**
	 * Guarda los datos de galaxia dada.
	 * @param galaxia galaxia a guardar
	 * @return true si la galaxia se guardo con exito, false
	 * si la galaxia no guardo correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean guardar(Galaxia galaxia) throws MyException;
	
	/**
	 * Actualiza los datos de galaxia dada.
	 * @param galaxia galaxia a actualizar
	 * @return true si la galaxia se actualiza con exito, false
	 * si la galaxia no actualiza correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean actualizar(Galaxia galaxia) throws MyException;
	
	/**
	 * Elimina los datos de galaxia dada.
	 * @param galaxia galaxia a eliminar
	 * @return true si la galaxia se elimino con exito, false
	 * si la galaxia no elimino correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean eliminar(Galaxia galaxia) throws MyException;
}
