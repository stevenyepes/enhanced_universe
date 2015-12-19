package com.edu.udea.iw.bl;

import java.util.List;

import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.dto.TipoGalaxia;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el bl tipo galaxia
 * @author enhanced_universe
 *
 */
public interface TipoGalaxiaBL {
	
	/**
	 * Verifica que la lista de tipos de galaxias no sea vacia o nula
	 * @return lista tiposgalaxia
	 * @throws MyException No hay tipos de galaxias en la base de datos
	 */	
	public List<TipoGalaxia> listarTiposGalaxias() throws MyException;
	
	/**
	 *Verifica que se ingrese un nombre valido del tipo galaxia para la consulta
	 * @param tipoGalaxia nombre del tipo de galaxia a consultar
	 * @return una instacia de los datos del tipo de galaxia consultada, si no
	 * existe el tipo de galaxia con el nombre dado retorna un null.
	 * @throws MyException Proporcionar nombre valido de la galaxia
	 */
	public TipoGalaxia listarTipoGalaxia(String tipoGalaxia) throws MyException;
	
	/**
	 * Verifica los datos del tipo de galaxia dada para guardarlos.
	 * @param nombre nombre del tipo de galaxia a guardar
	 * @return true si el tipo de galaxia se guardo con exito, false
	 * si el tipo de galaxia no guardo correctamente 
	 * @throws MyException Datos ingresados invalidos.
	 */
	public Boolean guardarTipoGalaxia(String nombre) throws MyException;
	
	/**
	 * Verifica los datos del tipo de galaxia dada para eliminar.
	 * @param tipoGalaxia nombre de la galaxia a eliminar
	 * @return true si el tipo de galaxia se elimino con exito, false
	 * si el tipo de galaxia no elimino correctamente 
	 * @throws MyException Datos ingresados no validos.
	 */
	public Boolean eliminarTipoGalaxia(String tipoGalaxia) throws MyException;
}
