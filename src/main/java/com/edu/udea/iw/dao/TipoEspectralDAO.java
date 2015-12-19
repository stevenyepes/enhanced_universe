package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.TipoEspectral;
import com.edu.udea.iw.exception.MyException;

public interface TipoEspectralDAO {

	public List<TipoEspectral> consultar() throws MyException;
	public Boolean guardar(TipoEspectral tipoEspectral) throws MyException;
	public Boolean eliminar(TipoEspectral tipoEspectral) throws MyException;
}
