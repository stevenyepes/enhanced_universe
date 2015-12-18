package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.TipoGalaxia;
import com.edu.udea.iw.exception.MyException;

public interface TipoGalaxiaDAO {
	
	public List<TipoGalaxia> consultar() throws MyException;
	public boolean guardar(TipoGalaxia tipogalaxia);

}
