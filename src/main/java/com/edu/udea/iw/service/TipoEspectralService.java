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

import com.edu.udea.iw.bl.TipoEspectralBL;
import com.edu.udea.iw.dto.TipoEspectral;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion de los metodos HTTP GET, POST, PUT, DELETE para el servicio  web Restful de tipo espectral
 * @author enhanced_universe
*/
@Component
@Path("/tipoespectral")
public class TipoEspectralService {

	@Autowired
	TipoEspectralBL tipoEspectralBL;
	
	/**
	 * HTTP GET para obtener todos los tipos espectrales de la base de datos	 
	 * @throws MyException No hay tipos espectrales en la base de datos
	 */
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getTiposEspectrales() throws MyException {
		List<TipoEspectral> tipoEspectrals = new ArrayList<TipoEspectral>();
		tipoEspectrals = tipoEspectralBL.listarTipoEspectrals();
		return Response
				.ok()
				// 200
				.entity(tipoEspectrals)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}
	
	/**
	 * HTTP POST para guardar un tipo espectral nuevo en la base de datos
	 * @param tipoEspectral tipo espectral a guardar en la base de datos 
	 * @throws MyException El tipo espectral no se pudo guardar
	 */
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response guardarTipoEspectral(TipoEspectral tipoEspectral) throws MyException {
		tipoEspectralBL.guardarTipoEspectral(tipoEspectral.getClasificacion(), tipoEspectral.getColor(),
								tipoEspectral.getTemperatura());

		
		return Response.status(Response.Status.CREATED)
				// 201
				.entity("Creado")
				.header("Location",
						"http://localhost:8080/enhanced_universe/rest/tipoEspectral"
								+ tipoEspectral.getClasificacion()).build();
	}
	
	/**
	 * HTTP DELETE para borrar  un tipo espectral en la base de datos
	 * @param tipoEspectral_nombre nombre del tipo espectral que se va a borrar	
	 * @throws MyException El tipo espectral no se pudo borrar
	 */
	@DELETE
	@Path("/{tipoEspectral_nombre}")
	@Transactional
	public Response eliminarTipoEspectral(
			@PathParam("tipoEspectral_nombre") String tipoEspectral_nombre)
			throws MyException {
		
		tipoEspectralBL.eliminarTipoEspectral(tipoEspectral_nombre);
		return Response
				.ok()
				// 200
				.entity("Eliminado")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();

	}
	
}
