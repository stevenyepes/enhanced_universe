package com.edu.udea.iw.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
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

@Component
@Path("/galaxia")
public class GalaxiaService {

	@Autowired
	GalaxiaBL galaxiaBL;

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

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response getGalaxias()
			throws MyException {
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


	@POST
	@Path("/guardar")
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarGalaxia(InputStream datosEntrada) throws MyException {
		StringBuilder galaxiaBuilder = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					datosEntrada));
			String line = null;
			
			while ((line = in.readLine()) != null) {
				System.out.println(line);
				galaxiaBuilder.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		System.out.println("Data Received: " + galaxiaBuilder.toString());

		//boolean isSaved =galaxiaBL.guardarGalaxia("lactosa", "espiral", 45.0, 45.0, 89.9, 65.9, 458.8);
		
		
		return Response
				.ok()
				// 201
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods",
						"GET, POST, DELETE, PUT").build();
	}

}
