package com.edu.udea.iw.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

import com.edu.udea.iw.bl.TipoGalaxiaBL;
import com.edu.udea.iw.dto.TipoGalaxia;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion de los metodos HTTP GET, POST, PUT, DELETE para el servicio web Restful de tipo galaxia
 * @author enhanced_universe
*/
@Component
@Path("/tipogalaxia")
public class TipoGalaxiaService {

	@Autowired
	TipoGalaxiaBL tipoGalaxiaBL;
	

	/**
	 * HTTP GET para obtener todos los tipos galaxia de la base de datos	 
	 * @throws MyException No hay tipos galaxia en la base de datos
	 */
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getTipoGalaxia() throws MyException {
		List<TipoGalaxia> tipoGalaxias = new ArrayList<TipoGalaxia>();
		tipoGalaxias = tipoGalaxiaBL.listarTiposGalaxias();
		return Response
				.ok()
				// 200
				.entity(tipoGalaxias)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	/**
	 * HTTP POST para guardar un tipo galixa nuevo en la base de datos
	 * @param tipoGalaxia tipo galaxia a guardar en la base de datos 
	 * @throws MyException El tipo galaxia no se pudo guardar
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response guardarTipoGalaxia(TipoGalaxia tipoGalaxia) throws MyException {
		tipoGalaxiaBL.guardarTipoGalaxia(tipoGalaxia.getNombre());

		
		return Response.status(Response.Status.CREATED)
				// 201
				.entity("Creado")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	/**
	 * HTTP DELETE para borrar  un tipo galaxia en la base de datos
	 * @param tipoGalaxia_nombre nombre del tipo galaxia que se va a borrar	
	 * @throws MyException El tipo galaxia no se pudo borrar
	 */
	@DELETE
	@Path("/{tipogalaxia_nombre}")
	@Transactional
	public Response eliminarTipoGalaxia(
			@PathParam("tipogalaxia_nombre") String tipogalaxia_nombre)
			throws MyException {
		
		tipoGalaxiaBL.eliminarTipoGalaxia(tipogalaxia_nombre);
		return Response
				.ok()
				// 200
				.entity("Eliminado")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();

	}

}
