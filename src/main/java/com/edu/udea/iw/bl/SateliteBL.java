package com.edu.udea.iw.bl;

import java.util.List;


import com.edu.udea.iw.dto.Satelite;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el bl satelite
 * @author enhanced_universe
 *
 */
public interface SateliteBL {
	/**
	 *Verifica que se ingrese un nombre valido del satelite para la consulta
	 * @param satelite nombre del satelite a consultar
	 * @return una instacia de los datos del satelite consultada, si no
	 * existe el satelite con el nombre dado retorna un null.
	 * @throws MyException Proporcionar nombre valido del satelite
	 */
	public Satelite buscarSatelite(String satelite) throws MyException;
	
	/**
	 * Verifica que la lista de satelites no sea vacia o nula
	 * @return lista satelites
	 * @throws MyException No hay satelites en la base de datos
	 */	
	public List<Satelite> listarSalites() throws MyException;
	
	/**
	 * Verifica los datos del satelite dado para guardarlos.
	 * @param nombre nombre del satelite a guardar
	 * @param masa  masa satelite a guardar
	 * @param gravedad gravedad satelite a guardar
	 * @param diametro diametro satelite a guardar
	 * @param temperatura temperatura satelite a guardar
	 * @param periodoRotacional periodo rotacional satelite a guardar
	 * @param periodoOrbital periodo orbital planeta a guardar
	 * @param planeta planeta a la que pertenece satelite a guardar 
	 * @return true si el satelite se guardo con exito, false
	 * si el satelite no guardo correctamente 
	 * @throws MyException Datos ingresados invalidos.
	 */
	public Boolean guardarsatelite(String nombre, Double masa, Double gravedad, Double diametro, Double temperatura, Double periodoRotacional,
			Double periodoOrbital, String planeta) throws MyException;
	
	/**
	 * Verifica los datos del satelite dado para actualizarlos.
	 * @param nombre nombre del satelite a actualizar
	 * @param masa  masa satelite a actualizar
	 * @param gravedad gravedad satelite a actualizar
	 * @param diametro diametro satelite a actualizar
	 * @param temperatura temperatura satelite a actualizar
	 * @param periodoRotacional periodo rotacional satelite a actualizar
	 * @param periodoOrbital periodo orbital planeta a actualizar
	 * @param planeta planeta a la que pertenece satelite a actualizar 
	 * @return true si el satelite se actualizado con exito, false
	 * si el satelite no actualizado correctamente 
	 * @throws MyException Datos ingresados invalidos.
	 */
	public Boolean actualizarSatelite(String nombre, Double masa, Double gravedad, Double diametro, Double temperatura, Double periodoRotacional,
			Double periodoOrbital, String planeta) throws MyException;
	
	/**
	 * Verifica los datos del satelite dado para eliminar.
	 * @param satelite nombre del satelite a eliminar
	 * @return true si el satelite se elimino con exito, false
	 * si el satelite no elimino correctamente 
	 * @throws MyException Datos ingresados no validos.
	 */
	public Boolean eliminarSatelite(String satelite) throws MyException;
}
