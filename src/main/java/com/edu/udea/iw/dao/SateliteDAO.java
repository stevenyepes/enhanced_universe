package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Satelite;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el dao satelite
 * @author enhanced_universe
 *
 */
public interface SateliteDAO {

	/**
	 * Entrega la lista de satelites en la base de datos
	 * @return lista satelites
	 * @throws MyException Ocurre un error con la conexión.
	 */
	public List<Satelite> consultar() throws MyException;
	
	/**
	 * Consulta los datos de un satelite dado su nombre.
	 * @param nombre nombre del satelite a consultar
	 * @return una instacia de los datos del satelite consultado, si no
	 * existe un satelite con el nombre dado retorna un null.
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Satelite consultaUnica(String nombre) throws MyException;
	
	/**
	 * Guarda los datos del satelite dado.
	 * @param satelite satelite a guardar
	 * @return true si el satelite se guardo con exito, false
	 * si el satelite no guardo correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean guardar(Satelite satelite) throws MyException;
	
	/**
	 * Actualiza los datos del satelite dado.
	 * @param satelite satelite a actualizar
	 * @return true si el satelite se actualiza con exito, false
	 * si el satelite no actualiza correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean actualizar(Satelite satelite) throws MyException;
	
	/**
	 * Elimina los datos del satelite dado.
	 * @param satelite satelite a eliminar
	 * @return true si el satelite se elimino con exito, false
	 * si el satelite no elimino correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean eliminar(Satelite satelite) throws MyException;
}
