package com.edu.udea.iw.bl.impl;

import com.edu.udea.iw.bl.GlosarioBL;
import com.edu.udea.iw.dao.GlosarioDAO;
import com.edu.udea.iw.dto.Asteroide;
import com.edu.udea.iw.dto.Glosario;
import com.edu.udea.iw.exception.MyException;

public class GlosarioBLImpl implements GlosarioBL {

	GlosarioDAO glosarioDao;
	
	public Glosario buscarTermino(String termino) throws MyException {
		Glosario glosarioDTO = null;
		if(termino.isEmpty() || "".equals(termino)) {
			
			throw new MyException("Por favor proporcione el nombre del"
					+ " termino a buscar",null );
		}
		
		for(Glosario glosarioAux : glosarioDao.consultar()){
			if(glosarioAux.getTermino().equals(termino)){
				
				glosarioDTO = glosarioAux;
			}
		}
		
		if(glosarioDTO == null) {
			throw new MyException("Por favor proporcione un termino válido ",null );
			
		}
		
		return glosarioDTO;
		
	}

	public Boolean guardarTermino(String termino, String descripcion) throws MyException {
		
		if(termino.isEmpty() || "".equals(termino)) {
			
			throw new MyException("Por favor proporcione el nombre del"
					+ " termino a insertar",null );
		}
		
		if(descripcion.isEmpty() || "".equals(descripcion)) {
			
			throw new MyException("Por favor proporcione la descripcion del"
					+ " termino a insertar",null );
		}
		
		if(glosarioDao.consultaUnica(termino).getTermino().equals(termino)){
			
			throw new MyException("El termino a ingresar ya existe",null );
		}
		
		Glosario glosario = new Glosario();
		glosario.setTermino(termino);
		glosario.setDefinicion(descripcion);
		
		return glosarioDao.guardar(glosario);
	}

	public Boolean actualizarTermino(String termino, String descripcion) throws MyException {
		
		if(termino.isEmpty() || "".equals(termino)) {
			
			throw new MyException("Por favor proporcione el nombre del"
					+ " termino a insertar",null );
		}
		
		if(descripcion.isEmpty() || "".equals(descripcion)) {
			
			throw new MyException("Por favor proporcione la descripcion del"
					+ " termino a insertar",null );
		}
		Glosario glosario = new Glosario();
		
		for (Glosario glosarioAux : glosarioDao.consultar()) {

			if (glosarioAux.getTermino().equals(termino)) {
				glosario.setId(glosarioAux.getId());
				glosario.setDefinicion(descripcion);
				glosario.setTermino(termino);
				return glosarioDao.actualizar(glosario);

			}

		}
		
		return false;
	}

	public Boolean eliminarTermino(String termino) throws MyException {
		// TODO Auto-generated method stub
		return null;
	}

}
