package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.TipoEspectral;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el dao tipo espectral
 * @author enhanced_universe
 *
 */
public interface TipoEspectralDAO {
	
	/**
	 * Entrega la lista de tipo espectral en la base de datos
	 * @return lista tiposespectrales
	 * @throws MyException Ocurre un error con la conexion.
	 */
	public List<TipoEspectral> consultar() throws MyException;
	
	/**
	 * Guarda los datos de tipo espectral dado.
	 * @param tipoEspectral tipoEspectral a guardar
	 * @return true si el tipoEspectral se guardo con exito, false
	 * si el tipoEspectral no guardo correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean guardar(TipoEspectral tipoEspectral) throws MyException;
	
	/**
	 * Elimina los datos del tipo espectral dado.
	 * @param tipoEspectral tipo espectral a eliminar
	 * @return true si el tipoEspectral se elimino con exito, false
	 * si el tipoEspectral no elimino correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean eliminar(TipoEspectral tipoEspectral) throws MyException;
}
