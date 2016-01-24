package com.edu.udea.iw.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

import com.edu.udea.iw.bl.AsteroideBL;
import com.edu.udea.iw.dto.Asteroide;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion de los metodos HTTP GET, POST, PUT, DELETE para el servicio REST de asteroide
 * @author enhanced_universe
*/
@Component
@Path("/asteroide")
public class AsteroideService {

	@Autowired
	AsteroideBL asteroideBL;
	
	@GET
	@Path("/{asteroide_nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getAsteroide(
			@PathParam("asteroide_nombre") String asteroide_nombre)
			throws MyException {
		Asteroide asteroide = new Asteroide();
		asteroide = asteroideBL.listarAsteroide(asteroide_nombre);
		return Response
				.ok()
				// 200
				.entity(asteroide)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getAsteroides() throws MyException {
		List<Asteroide> asteroides = new ArrayList<Asteroide>();
		asteroides = asteroideBL.listarAsteroides();
		return Response
				.ok()
				// 200
				.entity(asteroides)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response guardarAsteroide(Asteroide asteroide) throws MyException {
		asteroideBL.guardarAsteroide(asteroide.getNombre(), asteroide.getDiametro(), 
				asteroide.getPeligroso(), asteroide.getGalaxia().getNombre());

		
		return Response.status(Response.Status.CREATED)
				// 201
				.entity("Creado")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response actualizarAsteroide(Asteroide asteroide) throws MyException {
		
		asteroideBL.actualizarAsteroide(asteroide.getNombre(), asteroide.getDiametro(), 
				asteroide.getPeligroso(), asteroide.getGalaxia().getNombre());

		
		return Response.status(Response.Status.CREATED)
				// 201
				.entity("Actualizado")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	
	@DELETE
	@Path("/{asteroide_nombre}")
	@Transactional
	public Response eliminarAsteroide(
			@PathParam("asteroide_nombre") String asteroide_nombre)
			throws MyException {
		
		asteroideBL.eliminarAsteroide(asteroide_nombre);
		return Response
				.ok()
				// 200
				.entity("Eliminado")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();

	}
	
}
