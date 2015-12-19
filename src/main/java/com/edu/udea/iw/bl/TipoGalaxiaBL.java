package com.edu.udea.iw.bl;

import java.util.List;

import com.edu.udea.iw.dto.Asteroide;
import com.edu.udea.iw.dto.TipoGalaxia;
import com.edu.udea.iw.exception.MyException;

public interface TipoGalaxiaBL {

	public List<TipoGalaxia> listarTiposGalaxias() throws MyException;
	public TipoGalaxia listarTipoGalaxia(String tipoGalaxia) throws MyException;
	public Boolean guardarTipoGalaxia(String nombre) throws MyException;
	public Boolean eliminarTipoGalaxia(String tipoGalaxia) throws MyException;
}
