package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Glosario;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el dao glosario
 * @author enhanced_universe
 *
 */
public interface GlosarioDAO {
	
	/**
	 * Entrega la lista de glosarios en la base de datos
	 * @return lista glosarios
	 * @throws MyException Ocurre un error con la conexion.
	 */
	public List<Glosario> consultar() throws MyException;
	
	/**
	 * Consulta los datos de un glosario dado su termino.
	 * @param termino termino del glosario a consultar
	 * @return una instacia de los datos del glosario consultado, si no
	 * existe un glosario con el termino dado retorna un null.
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Glosario consultaUnica(String termino) throws MyException;
	
	/**
	 * Guarda los datos del glosario dado.
	 * @param glosario glosario a guardar
	 * @return true si el glosario se guardo con exito, false
	 * si el glosario no guardo correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean guardar(Glosario glosario) throws MyException;
	
	/**
	 * Actualiza los datos del glosario dado.
	 * @param glosario glosario a actualizar
	 * @return true si el glosario se actualiza con exito, false
	 * si el glosario no actualiza correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean actualizar(Glosario glosario) throws MyException;
	
	/**
	 * Elimina los datos del glosario dado.
	 * @param glosario glosario a eliminar
	 * @return true si el glosario se elimino con exito, false
	 * si el glosario no elimino correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean eliminar(Glosario glosario) throws MyException;
	
}
