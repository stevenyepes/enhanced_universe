package enhanced_universe;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.EstrellaDAO;
import com.edu.udea.iw.dao.TipoGalaxiaDAO;
import com.edu.udea.iw.dto.TipoGalaxia;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion de pruebas para los metodos del dao {@link TipoGalaxiaDAO}
 * @author enhanced_universe
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springcfg.xml")
@Transactional
public class TipoGalaxiaDAOimplTest {

	@Autowired
	TipoGalaxiaDAO tipogalaxiaDAO;
	
	@Test
	public void testConsultar() throws MyException {
		List <TipoGalaxia> tipoGalaxia = new ArrayList<TipoGalaxia>();
		tipoGalaxia = tipogalaxiaDAO.consultar();
		
		assertTrue(tipoGalaxia.size()>0);
	}

	@Test
	public void testGuardar() throws MyException {

		TipoGalaxia tipoGalaxia = new TipoGalaxia();
		tipoGalaxia.setNombre("Tipo 1");
		
		
		assertTrue(tipogalaxiaDAO.guardar(tipoGalaxia));
	}

	@Test
	public void testEliminar() throws MyException {
		
		TipoGalaxia tipoGalaxia = new TipoGalaxia();
		tipoGalaxia.setId(1);
		assertTrue(tipogalaxiaDAO.eliminar(tipoGalaxia));
	}

}
