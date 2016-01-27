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

import com.edu.udea.iw.bl.GalaxiaBL;
import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion de los metodos HTTP GET, POST, PUT, DELETE para el servicio  web Restful de galaxia
 * @author enhanced_universe
*/
@Component
@Path("/galaxia")
public class GalaxiaService {

	@Autowired
	GalaxiaBL galaxiaBL;

	/**
	 * HTTP GET para obtener una galaxia de la base de datos	
	 * @param galaxia_nombre nombre de la galaxia a consultar 
	 * @throws MyException La galaxia no existe en la base de datos
	 */
	@GET
	@Path("/{galaxia_nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getGalaxia(
			@PathParam("galaxia_nombre") String galaxia_nombre)
			throws MyException {
		Galaxia galaxia = new Galaxia();
		galaxia = galaxiaBL.listarGalaxia(galaxia_nombre);
		return Response
				.ok()
				// 200
				.entity(galaxia)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	/**
	 * HTTP GET para obtener todas las galaxias de la base de datos	 
	 * @throws MyException No hay galaxias en la base de datos
	 */
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getGalaxias() throws MyException {
		List<Galaxia> galaxias = new ArrayList<Galaxia>();
		galaxias = galaxiaBL.listarGalaxias();
		return Response
				.ok()
				// 200
				.entity(galaxias)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}

	/**
	 * HTTP POST para guardar una galaxia nueva en la base de datos
	 * @param galaxia galaxia a guardar en la base de datos 
	 * @throws MyException La galaxia no se pudo guardar
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response guardarGalaxia(Galaxia galaxia) throws MyException {
		galaxiaBL.guardarGalaxia(galaxia.getNombre(), galaxia.getTipogalaxia().getNombre(),
								galaxia.getAlto(),galaxia.getAncho(), galaxia.getProfundidad(), galaxia.getDiametro(),
								galaxia.getDistanciatierra());

		
		
		return Response.status(Response.Status.CREATED)
				// 201
				
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	/**
	 * HTTP PUT para actualizar  una galaxia en la base de datos
	 * @param galaxia galaxia que se va a actualizar	
	 * @throws MyException La galaxia no se pudo actualizar
	 */
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response actualizarGalaxia(Galaxia galaxia) throws MyException {
		
		boolean actualizado = galaxiaBL.actualizarGalaxia(galaxia.getNombre(), galaxia.getTipogalaxia().getNombre(),
								galaxia.getAlto(),galaxia.getAncho(), galaxia.getProfundidad(), galaxia.getDiametro(),
								galaxia.getDistanciatierra());

		
		return Response.status(Response.Status.CREATED)
				// 201
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	/**
	 * HTTP DELETE para borrar  una galaxia en la base de datos
	 * @param galaxia_nombre nombre de la galaxia que se va a borrar	
	 * @throws MyException La galaxia no se pudo borrar
	 */
	@DELETE
	@Path("/{galaxia_nombre}")
	@Transactional
	public Response eliminarGalaxia(
			@PathParam("galaxia_nombre") String galaxia_nombre)
			throws MyException {
		
		galaxiaBL.eliminarGalaxia(galaxia_nombre);
		return Response
				.ok()
				// 200
				.entity("")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();

	}
	
	

}
