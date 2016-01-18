package com.edu.udea.iw.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
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

@Component
@Path("/galaxia")
public class GalaxiaService {

	@Autowired
	GalaxiaBL galaxiaBL;

	@GET
	@Path("/{galaxia_nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getGalaxia(@PathParam("galaxia_nombre") String galaxia_nombre)
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
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getUser(@PathParam("galaxia_id") String galaxia_id)
			throws MyException {
		List<Galaxia> galaxias = new ArrayList<Galaxia>();
		galaxias = galaxiaBL.listarGalaxias();
		return Response.ok() //200
		.entity(galaxias)
		.header("Access-Control-Allow-Origin", "*")
		.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
		.build();
	}
	

}
