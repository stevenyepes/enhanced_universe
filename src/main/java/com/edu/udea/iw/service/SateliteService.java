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

import com.edu.udea.iw.bl.SateliteBL;
import com.edu.udea.iw.dto.Satelite;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion de los metodos HTTP GET, POST, PUT, DELETE para el servicio  web Restful de satelite
 * @author enhanced_universe
*/
@Component
@Path("/satelite")
public class SateliteService {
	
	@Autowired
	SateliteBL sateliteBL;
	
	/**
	 * HTTP GET para obtener un satelite de la base de datos	
	 * @param satelite_nombre nombre del satelite a consultar 
	 * @throws MyException El satelite no existe en la base de datos
	 */
	@GET
	@Path("/{satelite_nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getSatelite(@PathParam("satelite_nombre") String satelite_nombre)
			throws MyException {
		Satelite satelite = new Satelite();
		satelite = sateliteBL.buscarSatelite(satelite_nombre);
		return Response
				.ok()
				// 200
				.entity(satelite)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	/**
	 * HTTP GET para obtener todos satelites de la base de datos	 
	 * @throws MyException No hay satelites en la base de datos
	 */
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getSatelites() throws MyException {
		List<Satelite> satelites = new ArrayList<Satelite>();
		satelites = sateliteBL.listarSalites();
		return Response
				.ok()
				// 200
				.entity(satelites)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}

	/**
	 * HTTP POST para guardar un satelite nuevo en la base de datos
	 * @param satelite satelite a guardar en la base de datos 
	 * @throws MyException El satelite no se pudo guardar
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response guardarSatelite(Satelite satelite) throws MyException {
		sateliteBL.guardarsatelite(satelite.getNombre(),satelite.getMasa(),satelite.getGravedad(),satelite.getDiametro(),satelite.getTemperatura(),satelite.getPeriodorotacional(),satelite.getPeriodoorbital(),satelite.getPlaneta().getNombre());

		
		return Response.status(Response.Status.CREATED)
				// 201				
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	/**
	 * HTTP PUT para actualizar  un  satelite en la base de datos
	 * @param satelite satelite que se va a actualizar	
	 * @throws MyException El satelite no se pudo actualizar
	 */
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response actualizarSatelite(Satelite satelite) throws MyException {
		boolean actualizado = sateliteBL.actualizarSatelite(satelite.getNombre(),satelite.getMasa(),satelite.getGravedad(),satelite.getDiametro(),satelite.getTemperatura(),satelite.getPeriodorotacional(),satelite.getPeriodoorbital(),satelite.getPlaneta().getNombre());

		
		return Response.status(Response.Status.CREATED)
				// 201				
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	/**
	 * HTTP DELETE para borrar  un satelite en la base de datos
	 * @param satelite_nombre nombre del satelite que se va a borrar	
	 * @throws MyException El satelite no se pudo borrar
	 */
	@DELETE
	@Path("/{satelite_nombre}")
	@Transactional
	public Response eliminarSatelite(@PathParam("satelite_nombre") String satelite_nombre)	throws MyException {
		sateliteBL.eliminarSatelite(satelite_nombre);
		return Response
				.ok()
				// 200				
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();

	}
	

}
