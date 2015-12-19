package com.edu.udea.iw.bl;


import com.edu.udea.iw.dto.Glosario;
import com.edu.udea.iw.exception.MyException;

/**
 * Interface que define los metodos que va a proveer el bl glosario
 * @author enhanced_universe
 *
 */
public interface GlosarioBL {
	
	/**
	 *Verifica que se ingrese un termino valido del glosario para la consulta
	 * @param termino termino del glosario a consultar
	 * @return una instacia de los datos del termino consultado, si no
	 * existe el termino con el nombre dado retorna un null.
	 * @throws MyException Proporcionar termino invalido
	 */
	public Glosario buscarTermino(String termino) throws MyException;
	
	/**
	 * Verifica los datos del termino dado para guardarlos.
	 * @param termino termino del glosario a guardar
	 * @param descripcion  descripcion del termino del glosario a guardar	
	 * @return true si el termino se guardo con exito, false
	 * si el termino no guardo correctamente 
	 * @throws MyException Datos ingresados invalidos.
	 */
	public Boolean guardarTermino(String termino, String descripcion) throws MyException;
		
	/**
	 * Verifica los datos del termino  dado para actualizarlos.
	 * @param termino termino del glosario a actualizar
	 * @param descripcion  descripcion del termino del glosario a actualizar
	 * @return true si el termino se actualiza con exito, false
	 * si el termino no actualiza correctamente 
	 * @throws MyException Datos ingresados no validos.
	 */
	public Boolean actualizarTermino(String termino,String descripcion) throws MyException;
	
	/**
	 * Verifica los datos del termino dado para eliminar.
	 * @param termino termino del glosario a eliminar
	 * @return true si el termino se elimino con exito, false
	 * si el termino no elimino correctamente 
	 * @throws MyException Datos ingresados no validos.
	 */
	public Boolean eliminarTermino(String termino) throws MyException;
}
