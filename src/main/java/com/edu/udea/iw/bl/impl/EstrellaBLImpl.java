package com.edu.udea.iw.bl.impl;

import java.util.ArrayList;
import java.util.List;

import com.edu.udea.iw.bl.EstrellaBL;
import com.edu.udea.iw.dao.EstrellaDAO;
import com.edu.udea.iw.dao.GalaxiaDAO;
import com.edu.udea.iw.dao.TipoEspectralDAO;
import com.edu.udea.iw.dao.impl.GalaxiaDAOImpl;
import com.edu.udea.iw.dao.impl.TipoEspectralDAOImpl;
import com.edu.udea.iw.dto.Estrella;
import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.dto.TipoEspectral;
import com.edu.udea.iw.exception.MyException;

public class EstrellaBLImpl implements EstrellaBL {

	EstrellaDAO estrellaDao;
	TipoEspectralDAO tipoEspectralDao;
	GalaxiaDAO galaxiaDao;
	
	public EstrellaDAO getEstrellaDao() {
		return estrellaDao;
	}

	public void setEstrellaDao(EstrellaDAO estrellaDao) {
		this.estrellaDao = estrellaDao;
	}

	public List<Estrella> listarEstrellas() throws MyException {
		List<Estrella> estrellas = new ArrayList<Estrella>();
		estrellas = estrellaDao.consultar();
		if (estrellas.isEmpty() || estrellas == null) {

			throw new MyException("No hay estrellas en la base de datos", null);
		}

		return estrellas;
	}

	public Estrella listarEstrella(String estrella) throws MyException {
		Estrella estrellaDTO = new Estrella();
		if (estrella.isEmpty() || "".equals(estrella)) {

			throw new MyException("Por favor proporcione el nombre del" + " estrella a buscar", null);
		}

		estrellaDTO = estrellaDao.consultaUnica(estrella);
		if (estrellaDTO == null) {
			throw new MyException("Por favor proporcione un nombre de" + " estrella valido ", null);

		}

		return estrellaDTO;
	}

	public Boolean guardarEstrella(String nombre, String tipoespectral,
			Double temperatura, String clase, Double masa, Double diametro,
			String galaxia) throws MyException {
		
		if (nombre.isEmpty() || galaxia.isEmpty()) {
			throw new MyException("Por favor proporcione el nombre y la galaxia" + "del estrella ", null);
		}

		if ("".equals(nombre) || "".equals(galaxia)) {
			throw new MyException("Datos nulos, por favor reviselos ", null);
		}

		for (Estrella estrellaAux : estrellaDao.consultar()) {
			if (estrellaAux.getNombre().equals(nombre)) {
				throw new MyException("La estrella ya existe ", null);
			}
		}
		
		Estrella estrella = new Estrella();
		
		for (Galaxia galaxiaAux : galaxiaDao.consultar()) {
			if (galaxiaAux.getNombre().equals(galaxia)) {
				estrella.setGalaxia(galaxiaDao.consultaUnica(galaxia));
			}
		}
		
		if (estrella.getGalaxia() == null) {
			throw new MyException("La galaxia a la que quiere ingresar el estrella" + " no existe", null);
		}
		
		estrella.setDiametro(diametro);
		estrella.setMasa(masa);
		estrella.setNombre(nombre);
		estrella.setTemperatura(temperatura);
		
		 
		for (TipoEspectral tipoAux : tipoEspectralDao.consultar()) {
			if (tipoAux.getClasificacion().equals(tipoespectral)) {
				estrella.setTipoespectral(tipoAux);
			}
		}
		
		return estrellaDao.guardar(estrella);
	}

	public Boolean actualizarEstrella(String nombre, String tipoespectral,
			Double temperatura, String clase, Double masa, Double diametro,
			String galaxia) throws MyException {
		
		if (nombre.isEmpty() || galaxia.isEmpty()) {
			throw new MyException("Por favor proporcione el nombre y la galaxia" + "del estrella ", null);
		}

		if ("".equals(nombre) || "".equals(galaxia)) {
			throw new MyException("Datos nulos, por favor reviselos ", null);
		}

		for (Estrella estrellaAux : estrellaDao.consultar()) {
			if (estrellaAux.getNombre().equals(nombre)) {
				throw new MyException("La estrella ya existe ", null);
			}
		}
		
		Estrella estrella = new Estrella();
		
		
		for (Galaxia galaxiaAux : galaxiaDao.consultar()) {
			if (galaxiaAux.getNombre().equals(galaxia)) {
				estrella.setGalaxia(galaxiaDao.consultaUnica(galaxia));
			}
		}
		
		if (estrella.getGalaxia() == null) {
			throw new MyException("La galaxia a la que quiere ingresar el estrella" + " no existe", null);
		}
		
		for (Estrella estrellaAux : estrellaDao.consultar()) {
		
			if (estrellaAux.getNombre().equals(estrellaAux.getNombre())) {
			
				estrella.setDiametro(diametro);
				estrella.setMasa(masa);
				estrella.setTemperatura(temperatura);
				
				
				for (TipoEspectral tipoAux : tipoEspectralDao.consultar()) {
					if (tipoAux.getClasificacion().equals(tipoespectral)) {
						estrella.setTipoespectral(tipoAux);
					}
				}
				return estrellaDao.actualizar(estrella);
			}
		}
		return false;
	}

	public TipoEspectralDAO getTipoEspectralDao() {
		return tipoEspectralDao;
	}

	public void setTipoEspectralDao(TipoEspectralDAO tipoEspectralDao) {
		this.tipoEspectralDao = tipoEspectralDao;
	}

	public GalaxiaDAO getGalaxiaDao() {
		return galaxiaDao;
	}

	public void setGalaxiaDao(GalaxiaDAO galaxiaDao) {
		this.galaxiaDao = galaxiaDao;
	}

	public Boolean eliminarEstrella(String estrella) throws MyException {
		
		if(estrella.isEmpty() || "".equals(estrella)) {
			
			throw new MyException("El nombre del estrella no puede ser nulo ",null );
		}
		
		for(Estrella estrellaDTO : estrellaDao.consultar()){
			
			if(estrellaDTO.getNombre().equals(estrella)){
				return estrellaDao.eliminar(estrellaDTO);
								
			}
		}
		
		return false;
	}

}
