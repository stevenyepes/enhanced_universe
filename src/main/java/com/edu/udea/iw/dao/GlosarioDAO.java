package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Glosario;
import com.edu.udea.iw.exception.MyException;

public interface GlosarioDAO {

	public List<Glosario> consultar() throws MyException;
	public Glosario consultaUnica(String termino) throws MyException;
	public Boolean guardar(Glosario glosario) throws MyException;
	public Boolean actualizar(Glosario glosario) throws MyException;
	public Boolean eliminar(Glosario glosario) throws MyException;
	
}
