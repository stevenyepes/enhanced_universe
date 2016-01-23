package com.edu.udea.iw.bl.impl;

import java.util.ArrayList;
import java.util.List;

import com.edu.udea.iw.bl.TipoEspectralBL;
import com.edu.udea.iw.dao.TipoEspectralDAO;
import com.edu.udea.iw.dto.TipoEspectral;
import com.edu.udea.iw.exception.MyException;

public class TipoEspectralBLImpl implements TipoEspectralBL{

	TipoEspectralDAO tipoEspectralDao;
	
	public TipoEspectralDAO getTipoEspectralDao() {
		return tipoEspectralDao;
	}

	public void setTipoEspectralDao(TipoEspectralDAO tipoEspectralDao) {
		this.tipoEspectralDao = tipoEspectralDao;
	}

	public List<TipoEspectral> listarTipoEspectrals() throws MyException {
		
		List<TipoEspectral> tipoEspectrals = new ArrayList<TipoEspectral>();
		tipoEspectrals = tipoEspectralDao.consultar();
		if (tipoEspectrals.isEmpty() || tipoEspectrals == null) {

			throw new MyException("No hay tipoEspectrals en la base de datos", null);
		}

		return tipoEspectrals;
	}

	public Boolean guardarTipoEspectral(String clasificacion, String color,
			Double temperatura) throws MyException {
		
		if (clasificacion.isEmpty() || color.isEmpty() || temperatura.isNaN()) {

			throw new MyException("Por favor proporcione datos válidos ", null);
		}

		if ("".equals(clasificacion) || "".equals(color)) {

			throw new MyException("Datos nulos, por favor reviselos ", null);
		}

		for (TipoEspectral tipoEspectralAux : tipoEspectralDao.consultar()) {

			if (tipoEspectralAux.getClasificacion().equals(clasificacion)) {

				throw new MyException("El tipoEspectral ya existe ", null);
			}

		}
		
		TipoEspectral tipoEspectral = new TipoEspectral();
		
		tipoEspectral.setClasificacion(clasificacion);
		tipoEspectral.setColor(color);
		tipoEspectral.setTemperatura(temperatura);

		return tipoEspectralDao.guardar(tipoEspectral);
		
	}

	public Boolean eliminarTipoEspectral(String clasificacion)
			throws MyException {
		
		boolean isDeleted = false;
		
		TipoEspectral tipoEspectralDTO = null;
		for (TipoEspectral tipoEspectralAux : tipoEspectralDao.consultar()) {
			if (tipoEspectralAux.getClasificacion().equals(clasificacion)) {
				tipoEspectralDTO = new TipoEspectral();
				tipoEspectralDTO = tipoEspectralAux;
				break;
			}
		}
		
		if (tipoEspectralDTO != null) {
			tipoEspectralDao.eliminar(tipoEspectralDTO);
			isDeleted = true;
		}
		
		return isDeleted;
	}

}
