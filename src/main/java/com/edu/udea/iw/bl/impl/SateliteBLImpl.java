package com.edu.udea.iw.bl.impl;

import java.util.ArrayList;
import java.util.List;

import com.edu.udea.iw.bl.SateliteBL;
import com.edu.udea.iw.dao.GalaxiaDAO;
import com.edu.udea.iw.dao.PlanetaDAO;
import com.edu.udea.iw.dao.SateliteDAO;
import com.edu.udea.iw.dao.impl.GalaxiaDAOImpl;
import com.edu.udea.iw.dao.impl.PlanetaDAOImpl;
import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.dto.Planeta;
import com.edu.udea.iw.dto.Satelite;
import com.edu.udea.iw.exception.MyException;

public class SateliteBLImpl implements SateliteBL {

	SateliteDAO sateliteDao;
	PlanetaDAO planetaDao;
	
	public PlanetaDAO getPlanetaDao() {
		return planetaDao;
	}

	public void setPlanetaDao(PlanetaDAO planetaDao) {
		this.planetaDao = planetaDao;
	}

	public SateliteDAO getSateliteDao() {
		return sateliteDao;
	}

	public void setSateliteDao(SateliteDAO sateliteDao) {
		this.sateliteDao = sateliteDao;
	}

	public Satelite buscarSatelite(String satelite) throws MyException {

		Satelite sateliteDTO = new Satelite();
		if (satelite.isEmpty() || "".equals(satelite)) {

			throw new MyException("Por favor proporcione el nombre del" + " satelite a buscar", null);
		}

		sateliteDTO = sateliteDao.consultaUnica(satelite);
		if (sateliteDTO == null) {
			throw new MyException("Por favor proporcione un nombre de" + " satelite v�lido ", null);
		}

		return sateliteDTO;

	}

	public List<Satelite> listarSalites() throws MyException {
		List<Satelite> satelites = new ArrayList<Satelite>();
		satelites = sateliteDao.consultar();
		if (satelites.isEmpty() || satelites == null) {

			throw new MyException("No hay satelites en la base de datos", null);
		}

		return satelites;
	}

	public Boolean guardarsatelite(String nombre, Double masa, Double gravedad,
			Double diametro, Double temperatura, Double periodoRotacional,
			Double periodoOrbital, String planeta) throws MyException {
		
		if (nombre.isEmpty() || planeta.isEmpty() || masa.isNaN() || gravedad.isNaN()
				|| diametro.isNaN() || temperatura.isNaN() || periodoRotacional.isNaN()
				|| periodoOrbital.isNaN()) {

			throw new MyException("Por favor proporcione datos válidos ", null);
		}

		if ("".equals(nombre) || "".equals(planeta)) {

			throw new MyException("Datos nulos, por favor reviselos ", null);
		}

		for (Satelite sateliteAux : sateliteDao.consultar()) {

			if (sateliteAux.getNombre().equals(nombre)) {

				throw new MyException("El satelite ya existe ", null);
			}

		}
		Satelite satelite = new Satelite();

	
		for (Planeta planetaAux : planetaDao.consultar()) {

			if (planetaAux.getNombre().equals(planeta)) {
				satelite.setPlaneta(planetaDao.consultaUnica(planeta));
			}
		}

		if (satelite.getPlaneta() == null) {
			throw new MyException("El planeta a la que quiere ingresar el satelite" + " no existe", null);
		}
		
		satelite.setNombre(nombre);
		satelite.setMasa(masa);
		satelite.setGravedad(gravedad);
		satelite.setPeriodoorbital(periodoOrbital);
		satelite.setDiametro(diametro);
		satelite.setTemperatura(temperatura);

		return sateliteDao.guardar(satelite);
	}

	public Boolean actualizarSatelite(String nombre, Double masa,
			Double gravedad, Double diametro, Double temperatura,
			Double periodoRotacional, Double periodoOrbital, String planeta)
			throws MyException {
		
		
		if (nombre.isEmpty()) {

			throw new MyException("Por favor proporcione el nombre del asteroide a modificar", null);
		}

		if ("".equals(nombre)) {

			throw new MyException("Datos nulos, por favor reviselos ", null);
		}

		Satelite satelite = new Satelite();

		if (!"".equals(planeta)) {
			for (Planeta planetaAux : planetaDao.consultar()) {

				if (planetaAux.getNombre().equals(planeta)) {
					satelite.setPlaneta(planetaAux);
				}
			}
		}

		for (Satelite sateliteAux : sateliteDao.consultar()) {

			if (sateliteAux.getNombre().equals(nombre)) {
				satelite.setId(sateliteAux.getId());
				satelite.setMasa(masa);
				satelite.setGravedad(gravedad);
				satelite.setPeriodoorbital(periodoOrbital);
				satelite.setDiametro(diametro);
				satelite.setTemperatura(temperatura);
				satelite.setNombre(nombre);
				return sateliteDao.actualizar(satelite);

			}

		}

		return false;
	}



	public Boolean eliminarSatelite(String satelite) throws MyException {
Boolean isDeleted = false;
		
		if(satelite.isEmpty() || "".equals(satelite)) {
			
			throw new MyException("Por favor proporcione el nombre del planeta",null);
		}
		
		Satelite sateliteDTO = null;
		for (Satelite sateliteAux : sateliteDao.consultar()) {
			if (sateliteAux.getNombre().equals(satelite)) {
				sateliteDTO = new Satelite();
				sateliteDTO = sateliteAux;
				break;
			}
		}
		
		if (sateliteDTO != null) {
			sateliteDao.eliminar(sateliteDTO);
			isDeleted = true;
		}
		
		return isDeleted;
	}

}
