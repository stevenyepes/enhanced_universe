package com.edu.udea.iw.bl.impl;

import java.util.ArrayList;
import java.util.List;

import com.edu.udea.iw.bl.PlanetaBL;
import com.edu.udea.iw.dao.AsteroideDAO;
import com.edu.udea.iw.dao.GalaxiaDAO;
import com.edu.udea.iw.dao.PlanetaDAO;
import com.edu.udea.iw.dao.impl.GalaxiaDAOImpl;
import com.edu.udea.iw.dto.Administrador;
import com.edu.udea.iw.dto.Asteroide;
import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.dto.Planeta;
import com.edu.udea.iw.exception.MyException;

public class PlanetaBLImpl implements PlanetaBL {

	PlanetaDAO planetaDao;
	GalaxiaDAO galaxiaDao;

	public GalaxiaDAO getGalaxiaDao() {
		return galaxiaDao;
	}

	public void setGalaxiaDao(GalaxiaDAO galaxiaDao) {
		this.galaxiaDao = galaxiaDao;
	}

	public Planeta buscarPlaneta(String planeta) throws MyException {

		Planeta planetaDTO = new Planeta();
		if (planeta.isEmpty() || "".equals(planeta)) {

			throw new MyException("Por favor proporcione el nombre del" + " planeta a buscar", null);
		}

		planetaDTO = planetaDao.consultaUnica(planeta);
		if (planetaDTO == null) {
			throw new MyException("Por favor proporcione un nombre de" + " planeta v�lido ", null);

		}

		return planetaDTO;
	}

	public Boolean eliminarPlaneta(String planeta) throws MyException {
Boolean isDeleted = false;
		
		if(planeta.isEmpty() || "".equals(planeta)) {
			
			throw new MyException("Por favor proporcione el nombre del planeta",null);
		}
		
		Planeta planetaDTO = null;
		for (Planeta planetaAux : planetaDao.consultar()) {
			if (planetaAux.getNombre().equals(planeta)) {
				planetaDTO = new Planeta();
				planetaDTO = planetaAux;
				break;
			}
		}
		
		if (planetaDTO != null) {
			planetaDao.eliminar(planetaDTO);
			isDeleted = true;
		}
		
		return isDeleted;
	}

	public Boolean guardarPlaneta(String nombre, Double masa, Double gravedad,
			Double diametro, Double temperatura, Double periodoRotacional,
			Double periodoOrbital, Double distanciaTierra, String galaxia)
			throws MyException {
		
		
		if (nombre.isEmpty() || galaxia.isEmpty() || masa.isNaN() || gravedad.isNaN()
				|| diametro.isNaN() || temperatura.isNaN() || periodoRotacional.isNaN()
				|| periodoOrbital.isNaN() || distanciaTierra.isNaN()) {

			throw new MyException("Por favor proporcione datos válidos ", null);
		}

		if ("".equals(nombre) || "".equals(galaxia)) {

			throw new MyException("Datos nulos, por favor reviselos ", null);
		}

		for (Planeta planetaAux : planetaDao.consultar()) {

			if (planetaAux.getNombre().equals(nombre)) {

				throw new MyException("El planeta ya existe ", null);
			}

		}
		Planeta planeta = new Planeta();

		
		for (Galaxia galaxiaAux : galaxiaDao.consultar()) {

			if (galaxiaAux.getNombre().equals(galaxia)) {
				planeta.setGalaxia(galaxiaDao.consultaUnica(galaxia));
			}
		}

		if (planeta.getGalaxia() == null) {
			throw new MyException("La galaxia a la que quiere ingresar el planeta" + " no existe", null);
		}
		
		planeta.setNombre(nombre);
		planeta.setMasa(masa);
		planeta.setGravedad(gravedad);
		planeta.setPeriodoorbital(periodoOrbital);
		planeta.setDiametro(diametro);
		planeta.setTemperatura(temperatura);

		return planetaDao.guardar(planeta);
	}

	public Boolean actualizarPlaneta(String nombre, Double masa,
			Double gravedad, Double diametro, Double temperatura,
			Double periodoRotacional, Double periodoOrbital,
			Double distanciaTierra, String galaxia) throws MyException {
		
		if (nombre.isEmpty()) {

			throw new MyException("Por favor proporcione el nombre del asteroide a modificar", null);
		}

		if ("".equals(nombre)) {

			throw new MyException("Datos nulos, por favor reviselos ", null);
		}

		Planeta planeta = new Planeta();

		
		if (!"".equals(galaxia)) {
			for (Galaxia galaxiaAux : galaxiaDao.consultar()) {

				if (galaxiaAux.getNombre().equals(galaxia)) {
					planeta.setGalaxia(galaxiaAux);
				}
			}
		}

		for (Planeta planetaAux : planetaDao.consultar()) {

			if (planetaAux.getNombre().equals(nombre)) {
				planeta.setId(planetaAux.getId());
				planeta.setMasa(masa);
				planeta.setGravedad(gravedad);
				planeta.setPeriodoorbital(periodoOrbital);
				planeta.setDiametro(diametro);
				planeta.setTemperatura(temperatura);
				planeta.setNombre(nombre);
				return planetaDao.actualizar(planeta);

			}

		}

		return false;
	}

	public List<Planeta> listarPlanetas() throws MyException {

		List<Planeta> planetas = new ArrayList<Planeta>();
		planetas = planetaDao.consultar();
		if (planetas.isEmpty() || planetas == null) {

			throw new MyException("No hay asteroides en la base de datos", null);
		}

		return planetas;
	}

	public PlanetaDAO getPlanetaDao() {
		return planetaDao;
	}

	public void setPlanetaDao(PlanetaDAO planetaDao) {
		this.planetaDao = planetaDao;
	}

}
