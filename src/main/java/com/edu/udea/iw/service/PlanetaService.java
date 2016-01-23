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

import com.edu.udea.iw.bl.PlanetaBL;
import com.edu.udea.iw.dto.Planeta;
import com.edu.udea.iw.exception.MyException;

@Component
@Path("/planeta")
public class PlanetaService {
	
	@Autowired
	PlanetaBL planetaBL;
	
	@GET
	@Path("/{planeta_nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getPlaneta(
			@PathParam("planeta_nombre") String planeta_nombre)
			throws MyException {
		Planeta planeta = new Planeta();
		planeta = planetaBL.buscarPlaneta(planeta_nombre);
		return Response
				.ok()
				// 200
				.entity(planeta)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getPlanetas() throws MyException {
		List<Planeta> planetas = new ArrayList<Planeta>();
		planetas = planetaBL.listarPlanetas();
		return Response
				.ok()
				// 200
				.entity(planetas)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}


	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response guardarPlaneta(Planeta planeta) throws MyException {
		planetaBL.guardarPlaneta(planeta.getNombre(),planeta.getMasa(),planeta.getGravedad(),planeta.getDiametro(),planeta.getTemperatura(),planeta.getPeriodorotacional(),planeta.getPeriodoorbital(),planeta.getDistanciatierra(),planeta.getGalaxia().getNombre());

		
		return Response.status(Response.Status.CREATED)
				// 201
				.entity("Creado")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response actualizarPlaneta(Planeta planeta) throws MyException {
		boolean actualizado = planetaBL.actualizarPlaneta(planeta.getNombre(),planeta.getMasa(),planeta.getGravedad(),planeta.getDiametro(),planeta.getTemperatura(),planeta.getPeriodorotacional(),planeta.getPeriodoorbital(),planeta.getDistanciatierra(),planeta.getGalaxia().getNombre());

		
		return Response.status(Response.Status.CREATED)
				// 201
				.entity("Actualizado: "+actualizado)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	
	@DELETE
	@Path("/{planeta_nombre}")
	@Transactional
	public Response eliminarPlaneta(@PathParam("planeta_nombre") String planeta_nombre)	throws MyException {
		planetaBL.eliminarPlaneta(planeta_nombre);
		return Response
				.ok()
				// 200
				.entity("Eliminado")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();

	}
	
	

}
