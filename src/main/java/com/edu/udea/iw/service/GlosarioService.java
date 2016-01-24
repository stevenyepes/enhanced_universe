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
 * Implementacion de los metodos HTTP GET, POST, PUT, DELETE para el servicio  web Restful de glosario
 * @author enhanced_universe
*/
@Component
@Path("/glosario")
public class GlosarioService {
	
	@Autowired
	GlosarioBL glosarioBL;

	/**
	 * HTTP GET para obtener un termino de la base de datos	
	 * @param glosario_termino termino a consultar 
	 * @throws MyException El termino no existe en la base de datos
	 */
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
	
	/**
	 * HTTP POST para guardar un termino nuevo en la base de datos
	 * @param glosario termino a guardar en la base de datos 
	 * @throws MyException El termino no se pudo guardar
	 */
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
	
	/**
	 * HTTP PUT para actualizar  un termino en la base de datos
	 * @param glosario termino que se va a actualizar	
	 * @throws MyException El termino no se pudo actualizar
	 */
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
	
	/**
	 * HTTP DELETE para borrar  un  termino en la base de datos
	 * @param glosario_termino termino que se va a borrar	
	 * @throws MyException El termino no se pudo borrar
	 */
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
