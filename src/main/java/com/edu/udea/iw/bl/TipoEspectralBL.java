package com.edu.udea.iw.bl;

import java.util.List;

import com.edu.udea.iw.dto.TipoEspectral;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el bl tipo espectral
 * @author enhanced_universe
 *
 */
public interface TipoEspectralBL {
	
	/**
	 * Verifica que la lista de tipo espectral no sea vacia o nula
	 * @return lista tiposEspectrales
	 * @throws MyException No hay tipos espectrales en la base de datos
	 */	
	public List<TipoEspectral> listarTipoEspectrals() throws MyException;
	
	/**
	 * Verifica los datos del tipo espectral dado para guardarlos.
	 * @param clasificacion clasificacion del tipo espectral a guardar
	 * @param color  color tipo espectral a guardar
	 * @param temperatura temperatura tipo espectral a guardar
	 * @param diametro diametro planeta a guardar	 
	 * @return true si el tipo espectral se guardo con exito, false
	 * si el tipo espectral no guardo correctamente 
	 * @throws MyException Datos ingresados invalidos.
	 */
	public Boolean guardarTipoEspectral(String clasificacion, String color, Double temperatura) throws MyException;
	
	/**
	 * Verifica los datos del tipo espectral dado para eliminar.
	 * @param clasificacion clasificacion del tipo espectral a eliminar
	 * @return true si el tipo espectral se elimino con exito, false
	 * si el tipo espectral no elimino correctamente 
	 * @throws MyException Datos ingresados no validos.
	 */
	public Boolean eliminarTipoEspectral(String clasificacion) throws MyException;
	
}
