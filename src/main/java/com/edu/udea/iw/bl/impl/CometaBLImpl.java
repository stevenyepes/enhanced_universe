package com.edu.udea.iw.bl.impl;

import java.util.ArrayList;
import java.util.List;

import com.edu.udea.iw.bl.CometaBL;
import com.edu.udea.iw.dao.CometaDAO;
import com.edu.udea.iw.dao.GalaxiaDAO;
import com.edu.udea.iw.dto.Cometa;
import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion de los metodos de la interface {@link CometaBL}
 * @author enhanced_universe
*/
public class CometaBLImpl implements CometaBL{

	CometaDAO cometaDao;
	GalaxiaDAO galaxiaDao;
	
	public GalaxiaDAO getGalaxiaDao() {
		return galaxiaDao;
	}

	public void setGalaxiaDao(GalaxiaDAO galaxiaDao) {
		this.galaxiaDao = galaxiaDao;
	}

	public CometaDAO getCometaDao() {
		return cometaDao;
	}

	public void setCometaDao(CometaDAO cometaDao) {
		this.cometaDao = cometaDao;
	}

	public List<Cometa> listarCometas() throws MyException {
		List<Cometa> cometas = new ArrayList<Cometa>();
		cometas = cometaDao.consultar();
		if (cometas.isEmpty() || cometas == null) {

			throw new MyException("No hay cometas en la base de datos", null);
		}

		return cometas;
	}

	public Cometa listarCometa(String cometa) throws MyException {
		Cometa cometaDTO = new Cometa();
		if (cometa.isEmpty() || "".equals(cometa)) {

			throw new MyException("Por favor proporcione el nombre del" + " cometa a buscar", null);
		}

		cometaDTO = cometaDao.consultaUnica(cometa);
		if (cometaDTO == null) {
			throw new MyException("Por favor proporcione un nombre de" + " cometa valido ", null);

		}

		return cometaDTO;
	}

	public Boolean guardarCometa(String nombre, Double diametro,
			Double periodoorbital, Integer ultimoperihelio, String galaxia)
			throws MyException {
		
		if (nombre.isEmpty() || galaxia.isEmpty()) {

			throw new MyException("Por favor proporcione el nombre y la galaxia" + "del cometa ", null);
		}

		if ("".equals(nombre) || "".equals(galaxia)) {

			throw new MyException("Datos nulos, por favor reviselos ", null);
		}

		for (Cometa cometaAux : cometaDao.consultar()) {

			if (cometaAux.getNombre().equals(nombre)) {

				throw new MyException("El cometa ya existe ", null);
			}

		}
		
		if (diametro.isNaN() || periodoorbital.isNaN()) {
			throw new MyException("Datos invalidos, por favor reviselos ", null);
		}
		
		Cometa cometa = new Cometa();

		
		for (Galaxia galaxiaAux : galaxiaDao.consultar()) {

			if (galaxiaAux.getNombre().equals(galaxia)) {
				cometa.setGalaxia(galaxiaDao.consultaUnica(galaxia));
			}
		}

		if (cometa.getGalaxia() == null) {
			throw new MyException("La galaxia a la que quiere ingresar el cometa" + " no existe", null);
		}
		cometa.setNombre(nombre);
		cometa.setDiametro(diametro);
		cometa.setPeriodoorbital(periodoorbital);
		cometa.setUltimoperihelio(ultimoperihelio);

		return cometaDao.guardar(cometa);
	}

	public Boolean actualizarCometa(String nombre, Double diametro,
			Double periodoorbital, Integer ultimoperihelio, String galaxia)
			throws MyException {
		
		if (nombre.isEmpty()) {

			throw new MyException("Por favor proporcione el nombre del cometa a modificar", null);
		}

		if ("".equals(nombre)) {

			throw new MyException("Datos nulos, por favor reviselos ", null);
		}
		
		if (diametro.isNaN() || periodoorbital.isNaN()) {
			throw new MyException("Datos invalidos, por favor reviselos ", null);
		}

		Cometa cometa = new Cometa();

		
		if (!"".equals(galaxia)) {
			for (Galaxia galaxiaAux : galaxiaDao.consultar()) {

				if (galaxiaAux.getNombre().equals(galaxia)) {
					cometa.setGalaxia(galaxiaAux);
				}
			}
		}

		for (Cometa cometaAux : cometaDao.consultar()) {

			if (cometaAux.getNombre().equals(nombre)) {
				cometa.setId(cometaAux.getId());
				cometa.setNombre(nombre);
				cometa.setDiametro(diametro);
				cometa.setPeriodoorbital(periodoorbital);
				cometa.setUltimoperihelio(ultimoperihelio);
				return cometaDao.actualizar(cometa);

			}

		}

		return false;
		
	}

	public Boolean eliminarCometa(String cometa) throws MyException {
		
		if(cometa.isEmpty() || "".equals(cometa)) {
			
			throw new MyException("El nombre del cometa no puede ser nulo ",null );
		}
		
		for(Cometa cometaDTO : cometaDao.consultar()){
			
			if(cometaDTO.getNombre().equals(cometa)){
				return cometaDao.eliminar(cometaDTO);
				
				
			}
		}

		
		return false;
	}

}
