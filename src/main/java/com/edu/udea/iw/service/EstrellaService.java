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

import com.edu.udea.iw.bl.EstrellaBL;
import com.edu.udea.iw.dto.Estrella;
import com.edu.udea.iw.exception.MyException;

@Component
@Path("/estrella")
public class EstrellaService {

	@Autowired
	EstrellaBL estrellaBL;


	@GET
	@Path("/{estrella_nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getEstrella(
			@PathParam("estrella_nombre") String estrella_nombre)
			throws MyException {
		Estrella estrella = new Estrella();
		estrella = estrellaBL.listarEstrella(estrella_nombre);
		return Response
				.ok()
				// 200
				.entity(estrella)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getEstrellas() throws MyException {
		List<Estrella> estrellas = new ArrayList<Estrella>();
		estrellas = estrellaBL.listarEstrellas();
		return Response
				.ok()
				// 200
				.entity(estrellas)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}


	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response guardarEstrella(Estrella estrella) throws MyException {
		estrellaBL.guardarEstrella(estrella.getNombre(), estrella.getTipoespectral().getClasificacion()
				, estrella.getTemperatura(), estrella.getClase(), estrella.getMasa()
				, estrella.getDiametro(), estrella.getGalaxia().getNombre());

		
		return Response.status(Response.Status.CREATED)
				// 201
				.entity("Creado")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response actualizarEstrella(Estrella estrella) throws MyException {
		
		boolean actualizado = estrellaBL.actualizarEstrella(estrella.getNombre(), estrella.getTipoespectral().getClasificacion()
				, estrella.getTemperatura(), estrella.getClase(), estrella.getMasa()
				, estrella.getDiametro(), estrella.getGalaxia().getNombre());

		
		return Response.status(Response.Status.CREATED)
				// 201
				.entity("Actualizado: " + actualizado)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	
	@DELETE
	@Path("/{estrella_nombre}")
	@Transactional
	public Response eliminarEstrella(
			@PathParam("estrella_nombre") String estrella_nombre)
			throws MyException {
		
		estrellaBL.eliminarEstrella(estrella_nombre);
		return Response
				.ok()
				// 200
				.entity("Eliminado")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();

	}
}
