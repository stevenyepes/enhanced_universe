package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.TipoGalaxia;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el dao de tipo galaxia
 * @author enhanced_universe
 *
 */
public interface TipoGalaxiaDAO {
	
	
	/**
	 * Entrega la lista de tipos de galaxia en la base de datos
	 * @return lista tipogalaxias
	 * @throws MyException Ocurre un error con la conexion.
	 */
	public List<TipoGalaxia> consultar() throws MyException;	
	
	/**
	 * Guarda los datos de un tipo de galaxia dado.
	 * @param tipogalaxia tipogalaxia a guardar
	 * @return true si el tipogalaxia se guardo con exito, false
	 * si el tipo de galaxia no guardo correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean guardar(TipoGalaxia tipogalaxia) throws MyException;
	
	/**
	 * Elimina los datos de un tipo de galaxia dado.
	 * @param tipogalaxia tipogalaxia a eliminar
	 * @return true si el tipogalaxia se elimina con exito, false
	 * si el tipo de galaxia no elimino correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean eliminar(TipoGalaxia tipoGalaxia) throws MyException;

}
