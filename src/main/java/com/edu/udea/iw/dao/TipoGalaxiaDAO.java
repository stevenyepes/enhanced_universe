package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.TipoGalaxia;
import com.edu.udea.iw.exception.MyException;

public interface TipoGalaxiaDAO {
	
	public List<TipoGalaxia> consultar() throws MyException;
	public Boolean guardar(TipoGalaxia tipogalaxia) throws MyException;
	public Boolean eliminar(TipoGalaxia tipoGalaxia) throws MyException;

}
