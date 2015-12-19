package com.edu.udea.iw.bl;

import java.util.List;

import com.edu.udea.iw.dto.Administrador;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el bl administrador
 * @author enhanced_universe
 *
 */
public interface AdministradorBL {
	
	/**
	 * Verifica que la lista de administradores no sea vacia o nula
	 * @return lista asteroides
	 * @throws MyException No hay administradores en la base de datos
	 */	
	public List<Administrador> listarAdministradores () throws MyException;
	
	/**
	 *Verifica que se ingrese un usuario valido del administrador para la consulta
	 * @param usuario usuario del administrador a consultar
	 * @return una instacia de los datos del administrador consultado, si no
	 * existe el administrador con el usuario dado retorna un null.
	 * @throws MyException Proporcionar nombre invalido
	 */
	public Administrador listarAdministrador (String usuario) throws MyException;
	
	/**
	 * Verifica los datos del administrador dado para guardarlos.
	 * @param usuario usuario del administrador a guardar
	 * @param email  correo electronico del administrador a guardar
	 * @param nombre nombre del administrador a guardar
	 * @param apellido apellido del administrador a guardar
	 * @param contrasena contrasena del usuario del administrador a guardar	  
	 * @return true si el administrador se guardo con exito, false
	 * si el administrador no guardo correctamente 
	 * @throws MyException Datos ingresados invalidos.
	 */	
	public Boolean guardarAdministrador (String usuario, String email, String nombre, String apellido, String contrasena) throws MyException;
	
	/**
	 * Verifica los datos del administrador  dado para actualizarlos.
	 * @param usuario usuario del administrador a actualizar
	 * @param email  correo electronico del administrador a actualizar
	 * @param nombre nombre del administrador a actualizar
	 * @param apellido apellido del administrador a actualizar
	 * @param contrasena contrasena del usuario del administrador a actualizar	 
	 * @return true si el administrador se actualiza con exito, false
	 * si el administrador no actualiza correctamente 
	 * @throws MyException Datos ingresados no validos.
	 */
	public Boolean actualizarAdministrador (String usuario, String email, String nombre, String apellido, String contrasena) throws MyException;
	
	/**
	 * Verifica los datos del administrador dado para eliminar.
	 * @param usuario  usuario del administrador a eliminar
	 * @return true si el administrador se elimino con exito, false
	 * si el administrador no elimino correctamente 
	 * @throws MyException Datos ingresados no validos.
	 */
	public Boolean eliminarAdministrador (String usuario) throws MyException;
	
	/**
	 * Verifica los datos de autenticacion del administrador.
	 * @param usuario  usuario del administrador
	 * @param contrasena contrasena del administrador
	 * @return true si los datos de autenticacion del administrador son validos, false
	 * si los datos de autenticacion del administrador no son validos 
	 * @throws MyException Datos ingresados no validos.
	 */
	public Boolean validarAdministrador (String usuario, String contrasena) throws MyException;
	
}
