package enhanced_universe;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.edu.udea.iw.dao.EstrellaDAO;
import com.edu.udea.iw.dao.GalaxiaDAO;
import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.dao.TipoGalaxiaDAO;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion de pruebas para los metodos del dao {@link GalaxiaDAO}
 * @author enhanced_universe
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springcfg.xml")
@Transactional
public class GalaxiaDAOImplTest {

	@Autowired
	GalaxiaDAO galaxiaDao;
	
	@Autowired
	TipoGalaxiaDAO tipoGalaxiaDao;
	
	@Test
	public void testConsultar() throws MyException {
		List <Galaxia> galaxia = new ArrayList<Galaxia>();
		galaxia = galaxiaDao.consultar();
		
		assertTrue(galaxia.size()>0);
	}

	@Test
	public void testConsultaUnica() throws MyException {
		
		Galaxia galaxia;
		galaxia  = (Galaxia) galaxiaDao.consultaUnica("via lactea");
		assertTrue(galaxia != null);
	}

	@Test
	public void testGuardar() throws MyException {
		Galaxia galaxia = new Galaxia();
		galaxia.setId(1);
		galaxia.setNombre("via nueva");
		galaxia.setTipogalaxia(tipoGalaxiaDao.consultar().get(0));
		
		
		assertTrue(galaxiaDao.guardar(galaxia));
	}

	@Test
	public void testActualizar() throws MyException {
		Galaxia galaxia = new Galaxia();
		galaxia.setId(1);
		galaxia.setNombre("Via nueva");
		
		
		assertTrue(galaxiaDao.actualizar(galaxia));
	}

	@Test
	public void testEliminar() throws MyException {
		Galaxia galaxia = new Galaxia();
		galaxia.setId(1);
		
		
		assertTrue(galaxiaDao.eliminar(galaxia));
	}

}
