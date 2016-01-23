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

import com.edu.udea.iw.bl.TipoGalaxiaBL;
import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.dto.TipoGalaxia;
import com.edu.udea.iw.exception.MyException;


@Component
@Path("/tipogalaxia")
public class TipoGalaxiaService {

	@Autowired
	TipoGalaxiaBL tipoGalaxiaBL;
	
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
