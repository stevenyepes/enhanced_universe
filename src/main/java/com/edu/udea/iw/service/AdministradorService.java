package com.edu.udea.iw.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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


@Component
@Path("/administrador")
public class AdministradorService {

	@Autowired
	AdministradorBL administradorBL;
	
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
	
	@POST
	@Path("/login")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response administradorBL(
			@FormParam("login") String login,
			@FormParam("contrasena") String contrasena) throws MyException {
		
		boolean validado = administradorBL.validarAdministrador(login, contrasena);

		
		return Response.status(Response.Status.CREATED)
				// 201
				.entity(" el usuario es  " + validado)
				.header("Location",
						"http://localhost:8080/enhanced_universe/rest/administrador"
								+ login).build();
	}
}
