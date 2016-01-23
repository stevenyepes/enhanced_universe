package com.edu.udea.iw.bl.impl;

import java.util.ArrayList;
import java.util.List;

import com.edu.udea.iw.bl.AdministradorBL;
import com.edu.udea.iw.bl.AsteroideBL;
import com.edu.udea.iw.dao.AdministradorDAO;
import com.edu.udea.iw.dto.Administrador;
import com.edu.udea.iw.exception.MyException;
import com.edu.udea.iw.util.EmailAddressValidator;
import com.edu.udea.iw.util.MD5;

/**
 * Implementacion de los metodos de la interface {@link AdministradorBL}
 * @author enhanced_universe
*/
public class AdministradorBLImpl implements AdministradorBL {

	AdministradorDAO administradorDao;
	
	public List<Administrador> listarAdministradores() throws MyException {
		List<Administrador> administradores = new ArrayList<Administrador>();
		administradores = administradorDao.consultar();
		if(administradores.isEmpty() || administradores == null) {
			
			throw new MyException("No hay administradores en la base de datos",null );
		}
		
		return administradores;
	}

	public Administrador listarAdministrador(String usuario) throws MyException {
		Administrador administradorDTO = new Administrador();
		if(usuario.isEmpty() || "".equals(usuario)) {
			
			throw new MyException("Por favor proporcione el usuario del"
					+ " administrador a buscar",null );
		}
		
		administradorDTO = administradorDao.consultaUnica(usuario);
		if(administradorDTO == null) {
			throw new MyException("Por favor proporcione un usuario de"
					+ " administrador v�lido ",null );
			
		}
		
		return administradorDTO;
	}

	public Boolean guardarAdministrador(String usuario, String email, String nombre, String apellido, String contrasena)
			throws MyException {
		
		Boolean isSaved = false;
		
		if(usuario.isEmpty() || "".equals(usuario)) {
			
			throw new MyException("Por favor proporcione el usuario del nuevo administrador",null);
		}
		// Aqui esta el email validator de la clase email... (util) que usa a javax.mail
		if(email.isEmpty() || "".equals(email) || !EmailAddressValidator.isValidEmailAddress(email)) {
			
			throw new MyException("Email no valido, por favor reviselo ",null );
		}
		
		if(nombre.isEmpty() || "".equals(nombre)) {
			
			throw new MyException("Por favor proporcione el nombre del nuevo administrador",null);
		}
		if(apellido.isEmpty() || "".equals(apellido)) {
			
			throw new MyException("Por favor proporcione el apellido del nuevo administrador",null);
		}
		if(contrasena.isEmpty() || "".equals(contrasena)) {
			
			throw new MyException("Por favor proporcione la contrasena del nuevo administrador",null);
		}
		
		for (Administrador adm : administradorDao.consultar()) {
			// Email unico
			if (adm.getUsuario().equals(usuario) || adm.getEmail().equals(email)) {
				throw new MyException("Los datos ya pertenecen a otro administrador",null);
			}
		}
		
		Administrador administrador = new Administrador();
		administrador.setUsuario(usuario);
		administrador.setApellido(apellido);
		administrador.setNombre(nombre);
		administrador.setEmail(email);
		// Uso de MD5
		administrador.setContrasena(MD5.getMD5(contrasena));
		administradorDao.guardar(administrador);
		isSaved = true;
		
		return isSaved;
	}

	public Boolean actualizarAdministrador(String usuario, String email, String nombre, String apellido,
			String contrasena) throws MyException {
		
		Boolean isUpdated = false;
		
		if(usuario.isEmpty() || "".equals(usuario)) {
			
			throw new MyException("Por favor proporcione el usuario del administrador",null);
		}
		
		Administrador administrador = new Administrador();
		
		for (Administrador adm : administradorDao.consultar()) {
			if (adm.getUsuario().equals(usuario)) {
				administrador.setUsuario(adm.getUsuario());
				break;
			}
		}
		
		// Aqui esta el email validator de la clase email... (util) que usa a javax.mail
		if(email.isEmpty() || "".equals(email) || !EmailAddressValidator.isValidEmailAddress(email)) {
			
			throw new MyException("Email no valido, por favor reviselo ",null );
		}
		
		if(nombre.isEmpty() || "".equals(nombre)) {
			
			throw new MyException("Por favor proporcione el nombre del administrador",null);
		}
		if(apellido.isEmpty() || "".equals(apellido)) {
			
			throw new MyException("Por favor proporcione el apellido del administrador",null);
		}
		if(contrasena.isEmpty() || "".equals(contrasena)) {
			
			throw new MyException("Por favor proporcione la contrasena del administrador",null);
		}
		
		administrador.setApellido(apellido);
		administrador.setNombre(nombre);
		administrador.setEmail(email);
		administrador.setContrasena(MD5.getMD5(contrasena));
		administradorDao.actualizar(administrador);
		isUpdated = true;
		
		return isUpdated;
	}

	public Boolean eliminarAdministrador(String usuario) throws MyException {
		
		Boolean isDeleted = false;
		
		if(usuario.isEmpty() || "".equals(usuario)) {
			
			throw new MyException("Por favor proporcione el usuario del administrador",null);
		}
		
		Administrador administrador = null;
		for (Administrador adm : administradorDao.consultar()) {
			if (adm.getUsuario().equals(usuario)) {
				administrador = new Administrador();
				administrador = adm;
				break;
			}
		}
		
		if (administrador != null) {
			administradorDao.eliminar(administrador);
			isDeleted = true;
		}
		
		return isDeleted;
	}

	public Boolean validarAdministrador(String usuario, String contrasena) throws MyException {
		
		Boolean valido = false;
		
		if("".equals(usuario) || usuario.isEmpty()) {
			
			throw new MyException("Por favor proporcione el usuario del administrador",null);
		}
		if(contrasena.isEmpty() || "".equals(contrasena)) {
			
			throw new MyException("Por favor proporcione la contrasena del administrador",null);
		}
		
		Administrador administrador = administradorDao.consultaUnica(usuario);
		if (administrador != null) {
			if (administrador.getContrasena().equals(MD5.getMD5(contrasena))) {
				valido = true;
			}
		}
		
		
		return valido;
	}

	public AdministradorDAO getAdministradorDao() {
		return administradorDao;
	}

	public void setAdministradorDao(AdministradorDAO administradorDao) {
		this.administradorDao = administradorDao;
	}

	
	
}
