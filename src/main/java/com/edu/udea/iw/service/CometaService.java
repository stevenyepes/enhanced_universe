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

import com.edu.udea.iw.bl.CometaBL;
import com.edu.udea.iw.dto.Cometa;
import com.edu.udea.iw.exception.MyException;


/**
 * Implementacion de los metodos HTTP GET, POST, PUT, DELETE para el servicio REST de cometa
 * @author enhanced_universe
*/
@Component
@Path("/cometa")
public class CometaService {

	@Autowired
	CometaBL cometaBL;
	
	@GET
	@Path("/{cometa_nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getCometa(
			@PathParam("cometa_nombre") String cometa_nombre)
			throws MyException {
		Cometa cometa = new Cometa();
		cometa = cometaBL.listarCometa(cometa_nombre);
		return Response
				.ok()
				// 200
				.entity(cometa)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getCometas() throws MyException {
		List<Cometa> cometas = new ArrayList<Cometa>();
		cometas = cometaBL.listarCometas();
		return Response
				.ok()
				// 200
				.entity(cometas)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response guardarCometa(Cometa cometa) throws MyException {
		cometaBL.guardarCometa(cometa.getNombre(), cometa.getDiametro(), cometa.getPeriodoorbital(),
				cometa.getUltimoperihelio(), cometa.getGalaxia().getNombre());

		
		return Response.status(Response.Status.CREATED)
				// 201
				.entity("Creado")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response actualizarCometa(Cometa cometa) throws MyException {
		
		cometaBL.actualizarCometa(cometa.getNombre(), cometa.getDiametro(), cometa.getPeriodoorbital(),
				cometa.getUltimoperihelio(), cometa.getGalaxia().getNombre());

		
		return Response.status(Response.Status.CREATED)
				// 201
				.entity("Actualizado")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	
	@DELETE
	@Path("/{cometa_nombre}")
	@Transactional
	public Response eliminarCometa(
			@PathParam("cometa_nombre") String cometa_nombre)
			throws MyException {
		
		cometaBL.eliminarCometa(cometa_nombre);
		return Response
				.ok()
				// 200
				.entity("Eliminado")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();

	}
	
}
