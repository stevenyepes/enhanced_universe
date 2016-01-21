package com.edu.udea.iw.bl.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ThrowsAdvice;

import com.edu.udea.iw.bl.GalaxiaBL;
import com.edu.udea.iw.dao.GalaxiaDAO;
import com.edu.udea.iw.dao.PlanetaDAO;
import com.edu.udea.iw.dao.TipoGalaxiaDAO;
import com.edu.udea.iw.dao.impl.GalaxiaDAOImpl;
import com.edu.udea.iw.dao.impl.TipoGalaxiaDAOImpl;
import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.dto.TipoGalaxia;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion de los metodos de la interface {@link GalaxiaBL}
 * @author enhanced_universe
*/
public class GalaxiaBLImpl implements GalaxiaBL {

	GalaxiaDAO galaxiaDao;
	TipoGalaxiaDAO tipoGalaxiaDao;
	
	public List<Galaxia> listarGalaxias() throws MyException {
		List<Galaxia> galaxias = new ArrayList<Galaxia>();
		galaxias = galaxiaDao.consultar();
		if(galaxias.isEmpty() || galaxias == null) {
			
			throw new MyException("No hay galaxias en la base de datos",null );
		}
		
		return galaxias;
	}

	public Galaxia listarGalaxia(String galaxia) throws MyException {
		Galaxia galaxiaDTO = new Galaxia();
		if(galaxia.isEmpty() || "".equals(galaxia)) {
			
			throw new MyException("Por favor proporcione el nombre de la"
					+ " galaxia a buscar",null );
		}
		
		galaxiaDTO = galaxiaDao.consultaUnica(galaxia);
		if(galaxiaDTO == null) {
			throw new MyException("Por favor proporcione un nombre de"
					+ " galaxia v�lido ",null );
			
		}
		
		return galaxiaDTO;
	}

	public Boolean guardarGalaxia(String nombre, String tipo, Double alto, Double ancho, Double profundidad,
			Double diametro, Double distanciatierra) throws MyException {
		
		Boolean isSaved = false;
		
		if(nombre.isEmpty() || tipo == null) {
			
			throw new MyException("Por favor proporcione el nombre y el tipo"
					+ "de galaxia ",null );
		}
		
		if("".equals(nombre) || "".equals(tipo)) {
			
			throw new MyException("Datos nulos, por favor reviselos ",null );
		}
		
		for(Galaxia galaxiaAux : galaxiaDao.consultar()) {
			
			if(galaxiaAux.getNombre().equals(nombre)) {
				
				throw new MyException("La galaxia ya existe ",null );
			}
	
		}
		
		Galaxia galaxia = new Galaxia();
		galaxia.setNombre(nombre);
		

		
		
		for(TipoGalaxia tipoGalaxia : tipoGalaxiaDao.consultar()) {
			
			if(tipoGalaxia.getNombre().equals(tipo)){
				System.out.println("Pase por aqui y soy" + tipoGalaxia.getNombre());
				galaxia.setTipogalaxia(tipoGalaxia);
			}
		}
		
		if(galaxia.getTipogalaxia() == null){
			throw new MyException("El tipo de galaxia no existe ",null );
		}
		
		galaxia.setAlto(alto);
		galaxia.setAncho(ancho);
		galaxia.setProfundidad(profundidad);
		galaxia.setDiametro(diametro);
		galaxia.setDistanciatierra(distanciatierra);
		galaxiaDao.guardar(galaxia);
		isSaved = true;
		
		return isSaved;
	}

	public Boolean actualizarGalaxia(String nombre, String tipo, Double alto, Double ancho, Double profundidad, Double diametro, Double distanciatierra) throws MyException {
		Boolean isUpdated = false;
		
		if(nombre.isEmpty() ) {
			
			throw new MyException("Por favor proporcione el nombre"
					+ "de galaxia ",null );
		}
		
		if("".equals(nombre)) {
			
			throw new MyException("Datos nulos, por favor reviselos ",null );
		}
		TipoGalaxiaDAO tipoGalaxiaDao = new TipoGalaxiaDAOImpl();
		
		Galaxia galaxiaDTO = new Galaxia();
		
		for(Galaxia galaxia : galaxiaDao.consultar()) {
			
			if(galaxia.getNombre().equals(nombre)) {
				
				galaxiaDTO.setId(galaxia.getId());
			}
		}
		
		
		
		galaxiaDTO.setNombre(nombre);
		
		
		for(TipoGalaxia tipoGalaxia : tipoGalaxiaDao.consultar()) {
			
			if(tipoGalaxia.getNombre().equals(tipo)){
				galaxiaDTO.setTipogalaxia(tipoGalaxia);
			}
		}
		
		if(galaxiaDTO.getTipogalaxia() == null){
			throw new MyException("El tipo de galaxia no existe ",null );
		}
		
		galaxiaDTO.setAlto(alto);
		galaxiaDTO.setAncho(ancho);
		galaxiaDTO.setProfundidad(profundidad);
		galaxiaDTO.setDiametro(diametro);
		galaxiaDTO.setDistanciatierra(distanciatierra);
		isUpdated = true;
		
		return isUpdated;
		
	}

	

	public Boolean eliminarGalaxia(String galaxia) throws MyException {
		Boolean isDeleted = false;
		
		if(galaxia.isEmpty() || "".equals(galaxia)) {
			
			throw new MyException("El nombre de la galaxia no puede ser nulo ",null );
		}
		
		for(Galaxia galaxiaDTO : galaxiaDao.consultar()){
			
			if(galaxiaDTO.getNombre().equals(galaxia)){
				galaxiaDao.eliminar(galaxiaDTO);
				isDeleted = true;
				
			}
		}

		
		return isDeleted;
	}
	
	public GalaxiaDAO getGalaxiaDao() {
		return galaxiaDao;
	}

	public void setGalaxiaDao(GalaxiaDAO galaxiaDao) {
		this.galaxiaDao = galaxiaDao;
	}
	

	public TipoGalaxiaDAO getTipoGalaxiaDao() {
		return tipoGalaxiaDao;
	}

	public void setTipoGalaxiaDao(TipoGalaxiaDAO tipoGalaxiaDao) {
		this.tipoGalaxiaDao = tipoGalaxiaDao;
	}


}
