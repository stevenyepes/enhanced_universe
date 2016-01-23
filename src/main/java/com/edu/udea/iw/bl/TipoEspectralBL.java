package com.edu.udea.iw.bl;

import java.util.List;

import com.edu.udea.iw.dto.TipoEspectral;
import com.edu.udea.iw.exception.MyException;

public interface TipoEspectralBL {
	

	public List<TipoEspectral> listarTipoEspectrals() throws MyException;

	public Boolean guardarTipoEspectral(String clasificacion, String color, Double temperatura) throws MyException;

	public Boolean eliminarTipoEspectral(String clasificacion) throws MyException;
	
}
