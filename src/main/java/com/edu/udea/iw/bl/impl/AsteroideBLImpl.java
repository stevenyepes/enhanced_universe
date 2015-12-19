package com.edu.udea.iw.bl.impl;

import java.util.ArrayList;
import java.util.List;

import com.edu.udea.iw.bl.AsteroideBL;
import com.edu.udea.iw.bl.GalaxiaBL;
import com.edu.udea.iw.dao.AsteroideDAO;
import com.edu.udea.iw.dao.GalaxiaDAO;
import com.edu.udea.iw.dao.impl.GalaxiaDAOImpl;
import com.edu.udea.iw.dto.Asteroide;
import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion de los metodos de la interface {@link AsteroideBL}
 * @author enhanced_universe
*/
public class AsteroideBLImpl implements AsteroideBL {

	AsteroideDAO asteroideDao;

	public List<Asteroide> listarAsteroides() throws MyException {

		List<Asteroide> asteroides = new ArrayList<Asteroide>();
		asteroides = asteroideDao.consultar();
		if (asteroides.isEmpty() || asteroides == null) {

			throw new MyException("No hay asteroides en la base de datos", null);
		}

		return asteroides;
	}

	public AsteroideDAO getAsteroideDao() {
		return asteroideDao;
	}

	public void setAsteroideDao(AsteroideDAO asteroideDao) {
		this.asteroideDao = asteroideDao;
	}

	public Asteroide listarAsteroide(String asteroide) throws MyException {
		Asteroide asteroideDTO = new Asteroide();
		if (asteroide.isEmpty() || "".equals(asteroide)) {

			throw new MyException("Por favor proporcione el nombre del" + " asteroide a buscar", null);
		}

		asteroideDTO = asteroideDao.consultaUnica(asteroide);
		if (asteroideDTO == null) {
			throw new MyException("Por favor proporcione un nombre de" + " asteroide válido ", null);

		}

		return asteroideDTO;
	}

	public Boolean guardarAsteroide(String nombre, Double diametro, Boolean peligroso, String galaxia)
			throws MyException {

		if (nombre.isEmpty() || galaxia.isEmpty()) {

			throw new MyException("Por favor proporcione el nombre y la galaxia" + "del asteroide ", null);
		}

		if ("".equals(nombre) || "".equals(galaxia)) {

			throw new MyException("Datos nulos, por favor reviselos ", null);
		}

		for (Asteroide asteroideAux : asteroideDao.consultar()) {

			if (asteroideAux.getNombre().equals(nombre)) {

				throw new MyException("El asteroide ya existe ", null);
			}

		}
		Asteroide asteroide = new Asteroide();

		GalaxiaDAO galaxiaDao = new GalaxiaDAOImpl();
		for (Galaxia galaxiaAux : galaxiaDao.consultar()) {

			if (galaxiaAux.getNombre().equals(galaxia)) {
				asteroide.setGalaxia(galaxiaDao.consultaUnica(galaxia));
			}
		}

		if (asteroide.getGalaxia() == null) {
			throw new MyException("La galaxia a la que quiere ingresar el asteroide" + " no existe", null);
		}

		asteroide.setDiametro(diametro);
		asteroide.setPeligroso(peligroso);

		return asteroideDao.guardar(asteroide);
	}

	public Boolean actualizarAsteroide(String nombre, Double diametro, Boolean peligroso, String galaxia)
			throws MyException {

		if (nombre.isEmpty()) {

			throw new MyException("Por favor proporcione el nombre del asteroide a modificar", null);
		}

		if ("".equals(nombre)) {

			throw new MyException("Datos nulos, por favor reviselos ", null);
		}

		Asteroide asteroide = new Asteroide();

		GalaxiaDAO galaxiaDao = new GalaxiaDAOImpl();
		if (!"".equals(galaxia)) {
			for (Galaxia galaxiaAux : galaxiaDao.consultar()) {

				if (galaxiaAux.getNombre().equals(galaxia)) {
					asteroide.setGalaxia(galaxiaAux);
				}
			}
		}

		for (Asteroide asteroideAux : asteroideDao.consultar()) {

			if (asteroideAux.getNombre().equals(nombre)) {
				asteroide.setId(asteroideAux.getId());
				asteroide.setDiametro(diametro);
				asteroide.setPeligroso(peligroso);
				return asteroideDao.actualizar(asteroide);

			}

		}

		return false;
	}

	public Boolean eliminarAsteroide(String asteroide) throws MyException {
		
		
		
		if(asteroide.isEmpty() || "".equals(asteroide)) {
			
			throw new MyException("El nombre del asteroide no puede ser nulo ",null );
		}
		
		for(Asteroide asteroideDTO : asteroideDao.consultar()){
			
			if(asteroideDTO.getNombre().equals(asteroide)){
				return asteroideDao.eliminar(asteroideDTO);
				
				
			}
		}

		
		return false;
	}

}
