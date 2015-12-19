package enhanced_universe;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.bl.TipoGalaxiaBL;
import com.edu.udea.iw.dao.GalaxiaDAO;
import com.edu.udea.iw.dto.TipoGalaxia;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion de pruebas para los metodos del bl {@link TipoGalaxiaBL}
 * @author enhanced_universe
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springcfg.xml")
public class TipoGalaxiaBLImplTest {

	@Autowired
	TipoGalaxiaBL tipoGalaxiaBL; 
	
	@Test
	public void testListarTiposGalaxias() throws MyException {
		List<TipoGalaxia> tiposGalaxias = new ArrayList<TipoGalaxia>();
		tiposGalaxias = tipoGalaxiaBL.listarTiposGalaxias();
		assertTrue(tiposGalaxias.size()>0);
	}

	@Test
	public void testListarTipoGalaxia() throws MyException {
		TipoGalaxia tipoGalaxia;
		String nombre = "espiral";
		tipoGalaxia = tipoGalaxiaBL.listarTipoGalaxia(nombre);
		assertTrue(tipoGalaxia.getNombre().equals(nombre));
	}

}
