package com.edu.udea.iw.bl;


import java.util.List;


import com.edu.udea.iw.dto.Planeta;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el bl planeta
 * @author enhanced_universe
 *
 */
public interface PlanetaBL {

	/**
	 *Verifica que se ingrese un nombre valido del planeta para la consulta
	 * @param planeta nombre del planeta a consultar
	 * @return una instacia de los datos del planeta consultada, si no
	 * existe el planeta con el nombre dado retorna un null.
	 * @throws MyException Proporcionar nombre valido del planeta
	 */
	public Planeta buscarPlaneta(String planeta) throws MyException;
	
	/**
	 * Verifica que la lista de planetas no sea vacia o nula
	 * @return lista planetas
	 * @throws MyException No hay planetas en la base de datos
	 */	
	public List<Planeta> listarPlanetas() throws MyException;
	
	/**
	 * Verifica los datos del planeta dado para guardarlos.
	 * @param nombre nombre del planeta a guardar
	 * @param masa  masa planeta a guardar
	 * @param gravedad gravedad planeta a guardar
	 * @param diametro diametro planeta a guardar
	 * @param temperatura temperatura planeta a guardar
	 * @param periodoRotacional periodo rotacional planeta a guardar
	 * @param periodoOrbital periodo orbital planeta a guardar
	 * @param distanciaTierra distancia a la tierra planeta a guardar
	 * @param galaxia galaxia a la que pertenece planeta a guardar 
	 * @return true si el planeta se guardo con exito, false
	 * si el planeta no guardo correctamente 
	 * @throws MyException Datos ingresados invalidos.
	 */
	public Boolean guardarPlaneta(String nombre, Double masa, Double gravedad, Double diametro, Double temperatura, Double periodoRotacional,
			Double periodoOrbital, Double distanciaTierra, String galaxia) throws MyException;
	
	/**
	 * Verifica los datos del planeta dado para actualizarlos.
	 * @param nombre nombre del planeta a actualizar
	 * @param masa  masa planeta a actualizar
	 * @param gravedad gravedad planeta a actualizar
	 * @param diametro diametro planeta a actualizar
	 * @param temperatura temperatura planeta a actualizar
	 * @param periodoRotacional periodo rotacional planeta a actualizar
	 * @param periodoOrbital periodo orbital planeta a actualizar
	 * @param distanciaTierra distancia a la tierra planeta a actualizar
	 * @param galaxia galaxia a la que pertenece planeta a actualizar
	 * @return true si el planeta se actualizo con exito, false
	 * si el planeta no actulizo correctamente 
	 * @throws MyException Datos ingresados invalidos.
	 */
	public Boolean actualizarPlaneta(String nombre, Double masa, Double gravedad, Double diametro, Double temperatura, Double periodoRotacional,
			Double periodoOrbital, Double distanciaTierra, String galaxia) throws MyException;
	
	/**
	 * Verifica los datos del planeta dado para eliminar.
	 * @param planeta nombre del planeta a eliminar
	 * @return true si el planeta se elimino con exito, false
	 * si el planeta no elimino correctamente 
	 * @throws MyException Datos ingresados no validos.
	 */
	public Boolean eliminarPlaneta(String Planeta) throws MyException;
}
