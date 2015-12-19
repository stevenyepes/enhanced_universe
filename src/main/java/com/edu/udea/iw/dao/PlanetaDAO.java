package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Planeta;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el dao planeta
 * @author enhanced_universe
 *
 */
public interface PlanetaDAO {
	
	
	/**
	 * Entrega la lista de planetas en la base de datos
	 * @return lista planetas
	 * @throws MyException Ocurre un error con la conexión.
	 */
	public List<Planeta> consultar() throws MyException;
	
	/**
	 * Consulta los datos de un planeta dado su nombre.
	 * @param nombre nombre del planeta a consultar
	 * @return una instacia de los datos del planeta consultado, si no
	 * existe un planeta con el nombre dado retorna un null.
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Planeta consultaUnica(String nombre) throws MyException;
	
	/**
	 * Guarda los datos del planeta dado.
	 * @param planeta planeta a guardar
	 * @return true si el planeta se guardo con exito, false
	 * si el planeta no guardo correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean guardar(Planeta planeta) throws MyException;
	
	/**
	 * Actualiza los datos del planeta dado.
	 * @param planeta planeta a actualizar
	 * @return true si el planeta se actualiza con exito, false
	 * si el planeta no actualiza correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean actualizar(Planeta planeta) throws MyException;
	
	/**
	 * Elimina los datos del planeta dado.
	 * @param planeta planeta a eliminar
	 * @return true si el planeta se elimino con exito, false
	 * si el planeta no elimino correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean eliminar(Planeta planeta) throws MyException;
}
