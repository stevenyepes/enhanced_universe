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
 * Implementacion de los metodos HTTP GET, POST, PUT, DELETE para el servicio  web Restful de asteroide
 * @author enhanced_universe
*/
@Component
@Path("/asteroide")
public class AsteroideService {

	@Autowired
	AsteroideBL asteroideBL;
	
	/**
	 * HTTP GET para obtener un asteroide de la base de datos	
	 * @param asteoride_nombre nombre del asteroide a consultar 
	 * @throws MyException El asteoride no existe en la base de datos
	 */
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
	
	
	/**
	 * HTTP GET para obtener todos asteorides de la base de datos	 
	 * @throws MyException No hay asteroides en la base de datos
	 */
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
	

	/**
	 * HTTP POST para guardar un asteroide nuevo en la base de datos
	 * @param asteroide asteoride a guardar en la base de datos 
	 * @throws MyException El asteroide no se pudo guardar
	 */
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
	
	/**
	 * HTTP PUT para actualizar  un  asteroide en la base de datos
	 * @param asteoride asteoride que se va a actualizar	
	 * @throws MyException El asteroide no se pudo actualizar
	 */
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
	
	/**
	 * HTTP DELETE para borrar  un  asteroide en la base de datos
	 * @param asteoride_nombre nombre del asteoride que se va a borrar	
	 * @throws MyException El asteroide no se pudo borrar
	 */
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
