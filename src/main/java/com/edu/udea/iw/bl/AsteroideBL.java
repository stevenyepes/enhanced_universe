package com.edu.udea.iw.bl;

import java.util.List;

import com.edu.udea.iw.dto.Asteroide;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el bl asteroide
 * @author enhanced_universe
 *
 */
public interface AsteroideBL {
	
	/**
	 * Verifica que la lista de asteroides no sea vacia o nula
	 * @return lista tiposgalaxia
	 * @throws MyException No hay asteorides en la base de datos
	 */	
	public List<Asteroide> listarAsteroides() throws MyException;
	
	/**
	 *Verifica que se ingrese un nombre valido del hasteroide para la consulta
	 * @param asteroide nombre del asteroide a consultar
	 * @return una instacia de los datos del asteroide consultado, si no
	 * existe el asteroide con el nombre dado retorna un null.
	 * @throws MyException Proporcionar nombre invalido
	 */
	public Asteroide listarAsteroide(String asteroide) throws MyException;
	
	/**
	 * Verifica los datos del asteroide dado para guardarlos.
	 * @param nombre nombre del asteroide a guardar
	 * @param diametro  diametro del asteroide a guardar
	 * @param peligroso indicada si el asteroide a guardar es peleigroso para la Tierra
	 * @param galaxia galaxia a la que pertenece el asteroide a guardar	  
	 * @return true si el asteoride se guardo con exito, false
	 * si el asteroide no guardo correctamente 
	 * @throws MyException Datos ingresados invalidos.
	 */
	public Boolean guardarAsteroide(String nombre, Double diametro,Boolean peligroso, String galaxia) throws MyException;
		
	/**
	 * Verifica los datos del asteoride  dado para actualizarlos.
	 * @param nombre nombre del asteroide a actualizar
	 * @param diametro  diametro del asteroide a actualizar
	 * @param peligroso indicada si el asteroide a actualizar es peleigroso para la Tierra
	 * @param galaxia galaxia a la que pertenece el asteroide a actualizar	
	 * @return true si el asteroide se actualiza con exito, false
	 * si el asteoride no actualiza correctamente 
	 * @throws MyException Datos ingresados no validos.
	 */
	public Boolean actualizarAsteroide(String nombre, Double diametro,Boolean peligroso, String galaxia) throws MyException;
	
	/**
	 * Verifica los datos del asteoride dado para eliminar.
	 * @param asteroide nombre del asteroide a eliminar
	 * @return true si el asteoride se elimino con exito, false
	 * si el asteoride no elimino correctamente 
	 * @throws MyException Datos ingresados no validos.
	 */
	public Boolean eliminarAsteroide(String asteroide) throws MyException;
}
