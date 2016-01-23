package com.edu.udea.iw.bl.impl;

import java.util.ArrayList;
import java.util.List;

import com.edu.udea.iw.bl.GalaxiaBL;
import com.edu.udea.iw.bl.TipoGalaxiaBL;
import com.edu.udea.iw.dao.TipoGalaxiaDAO;
import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.dto.TipoGalaxia;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion de los metodos de la interface {@link TipoGalaxiaBL}
 * @author enhanced_universe
*/
public class TipoGalaxiaBLImpl implements TipoGalaxiaBL {

	TipoGalaxiaDAO tipoGalaxiaDao;
	
	public TipoGalaxiaDAO getTipoGalaxiaDao() {
		return tipoGalaxiaDao;
	}

	public void setTipoGalaxiaDao(TipoGalaxiaDAO tipoGalaxiaDao) {
		this.tipoGalaxiaDao = tipoGalaxiaDao;
	}

	public List<TipoGalaxia> listarTiposGalaxias() throws MyException {
		
		List<TipoGalaxia> tiposGalaxias = new ArrayList<TipoGalaxia>();
		tiposGalaxias = tipoGalaxiaDao.consultar();
		if(tiposGalaxias.isEmpty() || tiposGalaxias == null) {
			
			throw new MyException("No hay tipos de galaxias en la base de datos",null );
		}
		
		return tiposGalaxias;
	}

	public TipoGalaxia listarTipoGalaxia(String tipoGalaxia) throws MyException {
		TipoGalaxia tipoGalaxiaDTO = null;
		if(tipoGalaxia.isEmpty() || "".equals(tipoGalaxia)) {
			
			throw new MyException("Por favor proporcione el nombre de la"
					+ " galaxia a buscar",null );
		}
		
		for(TipoGalaxia tipoGalaxiaAux : tipoGalaxiaDao.consultar()){
			if(tipoGalaxiaAux.getNombre().equals(tipoGalaxia)){
				
				tipoGalaxiaDTO = tipoGalaxiaAux;
			}
		}
		
		if(tipoGalaxiaDTO == null) {
			throw new MyException("Por favor proporcione un nombre de"
					+ " galaxia v�lido ",null );
			
		}
		
		return tipoGalaxiaDTO;
	}

	public Boolean guardarTipoGalaxia(String nombre) throws MyException {
	
		Boolean isSaved = false;
		
		if(nombre.isEmpty() || "".equals(nombre)) {
			
			throw new MyException("Por favor proporcione el nombre ",null );
		}
		
		for(TipoGalaxia tipoGalaxiaAux : tipoGalaxiaDao.consultar()) {
			
			if(tipoGalaxiaAux.getNombre().equals(nombre)) {
				
				throw new MyException("El tipo de galaxia ya existe ",null );
			}
	
		}
		
		TipoGalaxia tipoGalaxiaDTO= new TipoGalaxia();
		tipoGalaxiaDTO.setNombre(nombre);
		tipoGalaxiaDao.guardar(tipoGalaxiaDTO);
		isSaved = true;
		
		
		return isSaved;
	}

	

	public Boolean eliminarTipoGalaxia(String tipoGalaxia) throws MyException {
		Boolean isDeleted = false;
		
		if(tipoGalaxia.isEmpty() || "".equals(tipoGalaxia)) {
			
			throw new MyException("Por favor proporcione el nombre ",null );
		}
		//TipoGalaxia tipoGalaxiaDTO= null;
		
		for(TipoGalaxia tipoGalaxiaAux : tipoGalaxiaDao.consultar()) {
			
			if(tipoGalaxiaAux.getNombre().equals(tipoGalaxia)) {
				
				tipoGalaxiaDao.eliminar(tipoGalaxiaAux);
				isDeleted = true;
			}
	
		}
		
		return isDeleted;
	}

}
