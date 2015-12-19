package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Administrador;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el dao administrador
 * @author enhanced_universe
 *
 */
public interface AdministradorDAO {
	

	/**
	 * Entrega la lista de administradores en la base de datos
	 * @return lista administradores
	 * @throws MyException Ocurre un error con la conexion.
	 */
	public List<Administrador> consultar() throws MyException;
	
	/**
	 * Consulta los datos de un administrador dado su usuario.
	 * @param usuario usuario del administrador a consultar
	 * @return una instacia de los datos del administrador consultado, si no
	 * existe un administrador con el nombre dado retorna un null.
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Administrador consultaUnica(String usuario) throws MyException;
	
	/**
	 * Guarda los datos del administrador dado.
	 * @param administrador administrador a guardar
	 * @return true si el administrador se guardo con exito, false
	 * si el administrador no guardo correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean guardar(Administrador administrador) throws MyException;
	
	/**
	 * Actualiza los datos del administrador dado.
	 * @param administrador administrador a actualizar
	 * @return true si el administrador se actualiza con exito, false
	 * si el administrador no actualiza correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean actualizar(Administrador administrador) throws MyException;
	
	/**
	 * Elimina los datos del administrador dado.
	 * @param administrador administrador a eliminar
	 * @return true si el administrador se elimino con exito, false
	 * si el administrador no elimino correctamente 
	 * @throws MyException Ocurre un error con la base de datos.
	 */
	public Boolean eliminar(Administrador administrador) throws MyException;
}
