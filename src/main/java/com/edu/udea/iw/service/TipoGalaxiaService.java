package com.edu.udea.iw.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.edu.udea.iw.bl.TipoGalaxiaBL;
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
	public Response getGalaxias() throws MyException {
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

}
