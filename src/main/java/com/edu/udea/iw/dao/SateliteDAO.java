package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.dto.Satelite;
import com.edu.udea.iw.exception.MyException;

public interface SateliteDAO {

	public List<Satelite> consultar() throws MyException;
	public Satelite consultaUnica(String nombre) throws MyException;
	public Boolean guardar(Satelite satelite) throws MyException;
	public Boolean actualizar(Satelite satelite) throws MyException;
	public Boolean eliminar(Satelite satelite) throws MyException;
}
