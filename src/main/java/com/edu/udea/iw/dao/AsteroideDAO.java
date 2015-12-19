package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Asteroide;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el dao asteroide
 * @author enhanced_universe
 *
 */
public interface AsteroideDAO {
	
	/**
	 * Entrega la lista de asteroide en la base de datos
	 * @return lista asteroide
	 * @throws MyException Ocurre un error con la conexion.
	 */
	public List<Asteroide> consultar() throws MyException;
	
	/**
	 * Consulta los datos de un asteroide dado su nombre.
	 * @param nombre nombre del asteroide a consultar
	 * @return una instacia de los datos del asteroide consultado, si no
	 * existe un asteroide con el nombre dado retorna un null.
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Asteroide consultaUnica(String nombre) throws MyException;
	
	/**
	 * Guarda los datos del asteroide dado.
	 * @param asteroide asteroide a guardar
	 * @return true si el asteroide se guardo con exito, false
	 * si el asteroide no guardo correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean guardar(Asteroide asteroide) throws MyException;
	
	/**
	 * Actualiza los datos del asteroide dado.
	 * @param asteroide asteroide a actualizar
	 * @return true si el asteroide se actualiza con exito, false
	 * si el asteroide no actualiza correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean actualizar(Asteroide asteroide) throws MyException;
	
	/**
	 * Elimina los datos del asteroide dado.
	 * @param asteroide asteroide a eliminar
	 * @return true si el asteroide se elimino con exito, false
	 * si el asteroide no elimino correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean eliminar(Asteroide asteroide) throws MyException;
	
}
