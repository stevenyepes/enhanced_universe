package com.edu.udea.iw.service;

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

import com.edu.udea.iw.bl.GlosarioBL;
import com.edu.udea.iw.dto.Glosario;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion de los metodos HTTP GET, POST, PUT, DELETE para el servicio REST de glosario
 * @author enhanced_universe
*/
@Component
@Path("/glosario")
public class GlosarioService {
	
	@Autowired
	GlosarioBL glosarioBL;


	@GET
	@Path("/{glosario_termino}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getTermino(@PathParam("glosario_termino") String glosario_termino)
			throws MyException {
		Glosario glosario = new Glosario();
		glosario = glosarioBL.buscarTermino(glosario_termino);
		return Response
				.ok()
				// 200
				.entity(glosario)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response guardarTermino(Glosario glosario) throws MyException {
		glosarioBL.guardarTermino(glosario.getTermino(),glosario.getDefinicion());

		
		return Response.status(Response.Status.CREATED)
				// 201
				.entity("Creado")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response actualizarTermino(Glosario glosario) throws MyException {
		
		boolean actualizado = glosarioBL.actualizarTermino(glosario.getTermino(), glosario.getDefinicion());
		
		return Response.status(Response.Status.CREATED)
				// 201
				.entity("Actualizado: "+actualizado)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	
	@DELETE
	@Path("/{glosario_termino}")
	@Transactional
	public Response eliminarTermino(@PathParam("glosario_termino") String glosario_termino)
			throws MyException {
		
		glosarioBL.eliminarTermino(glosario_termino);
		return Response
				.ok()
				// 200
				.entity("Eliminado")
				.header("Access-Control-Allow-Origin", "*")
				.header("s-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();

	}	
	


}
