package com.edu.udea.iw.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.edu.udea.iw.bl.AdministradorBL;
import com.edu.udea.iw.dto.Administrador;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion de los metodos HTTP GET, POST, PUT, DELETE para el servicio  web Restful de administrador
 * @author enhanced_universe
*/
@Component
@Path("/administrador")
public class AdministradorService {
	
	
	@Autowired
	AdministradorBL administradorBL;
	
	/**
	 * HTTP GET para obtener todos administradores de la base de datos	 
	 * @throws MyException No hay administradores en la base de datos
	 */
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getAdministrador() throws MyException {
		List<Administrador> administradores = new ArrayList<Administrador>();
		administradores = administradorBL.listarAdministradores();
		return Response
				.ok()
				// 200
				.entity(administradores)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	
	/**
	 * HTTP POST para validar el administrador en el login
	 * @param login nombre del usuario login del administrador
	 * @param contrasena contrase�a del administrador	 
	 * @throws MyException Administrador no valido
	 */
	@GET
	@Path("/login/{login}/{contrasena}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response administradorBL(
			@PathParam("login") String login,
			@PathParam("contrasena") String contrasena) throws MyException {
		
		boolean validado = administradorBL.validarAdministrador(login, contrasena);
		String res = "{\"validado\":" + validado + "}";
		
		return Response.status(Response.Status.CREATED)
				// 201
				.entity(res)
				.header("Location",
						"http://localhost:8080/enhanced_universe/rest/administrador"
								+ login).build();
	}
	
	/**
	 * HTTP POST para guardar un nuevo administrador en la base de datos
	 * @param administrador administrador que se va a guardar	
	 * @throws MyException El administrador no se pudo crear
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response guardarAdministrador(Administrador administrador) throws MyException {
		administradorBL.guardarAdministrador(administrador.getUsuario(), administrador.getEmail(),
				administrador.getNombre(), administrador.getApellido(), administrador.getContrasena());

		
		return Response.status(Response.Status.CREATED)
				// 201				
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	/**
	 * HTTP PUT para actualizar  un  administrador en la base de datos
	 * @param administrador administrador que se va a actualizar	
	 * @throws MyException El administrador no se pudo actualizar
	 */
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response actualizarAdministrador(Administrador administrador) throws MyException {
		
		boolean actualizado = administradorBL.actualizarAdministrador(administrador.getUsuario(), administrador.getEmail(),
				administrador.getNombre(), administrador.getApellido(), administrador.getContrasena());

		
		return Response.status(Response.Status.CREATED)
				// 201				
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	/**
	 * HTTP DELETE para borrar  un  administrador en la base de datos
	 * @param usuario usuario del administrador que se va a borrar	
	 * @throws MyException El administrador no se pudo borrar
	 */
	@DELETE
	@Path("/{usuario}")
	@Transactional
	public Response eliminarAdministrador(
			@PathParam("usuario") String usuario)
			throws MyException {
		
		administradorBL.eliminarAdministrador(usuario);
		return Response
				.ok()
				// 200				
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();

	}
}
