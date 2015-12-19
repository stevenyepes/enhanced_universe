package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Cometa;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el dao cometa
 * @author enhanced_universe
 *
 */
public interface CometaDAO {

	/**
	 * Entrega la lista de cometas en la base de datos
	 * @return lista cometas
	 * @throws MyException Ocurre un error con la conexion.
	 */
	public List<Cometa> consultar() throws MyException;
	
	/**
	 * Consulta los datos de un cometa dado su nombre.
	 * @param nombre nombre del cometa a consultar
	 * @return una instacia de los datos del cometa consultado, si no
	 * existe un cometa con el nombre dado retorna un null.
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Cometa consultaUnica(String nombre) throws MyException;
	
	/**
	 * Guarda los datos del cometa dado.
	 * @param cometa cometa a guardar
	 * @return true si el cometa se guardo con exito, false
	 * si el cometa no guardo correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean guardar(Cometa cometa) throws MyException;
	
	/**
	 * Actualiza los datos del cometa dado.
	 * @param cometa cometa a actualizar
	 * @return true si el cometa se actualiza con exito, false
	 * si el cometa no actualiza correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean actualizar(Cometa cometa) throws MyException;
	
	/**
	 * Elimina los datos del cometa dado.
	 * @param cometa cometa a eliminar
	 * @return true si el cometa se elimino con exito, false
	 * si el cometa no elimino correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean eliminar(Cometa cometa) throws MyException;
}
