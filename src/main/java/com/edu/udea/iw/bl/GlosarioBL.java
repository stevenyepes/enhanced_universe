package com.edu.udea.iw.bl;

import com.edu.udea.iw.dto.Asteroide;
import com.edu.udea.iw.dto.Glosario;
import com.edu.udea.iw.exception.MyException;

public interface GlosarioBL {

	public Glosario buscarTermino(String termino) throws MyException;
	

	public Boolean guardarTermino(String termino, String descripcion) throws MyException;
		

	public Boolean actualizarTermino(String termino,String descripcion) throws MyException;
	
	
	public Boolean eliminarTermino(String termino) throws MyException;
}
