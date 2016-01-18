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
import com.edu.udea.iw.dao.PlanetaDAO;
import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.dto.Planeta;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion de pruebas para los metodos del dao {@link PlanetaDAO}
 * @author enhanced_universe
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springcfg.xml")
@Transactional
public class PlanetaDAOImplTest {

	@Autowired
	PlanetaDAO planetaDao;
	
	@Autowired
	GalaxiaDAO galaxiaDao;
	
	@Test
	public void testConsultar() throws MyException {
		List <Planeta> planetas = new ArrayList<Planeta>();
		planetas = planetaDao.consultar();
		
		assertTrue(planetas.size()>0);
	}

	@Test
	public void testConsultaUnica() throws MyException {

		Planeta planeta;
		planeta  = planetaDao.consultaUnica("tierra");
		assertTrue(planeta != null);
	}

	@Test
	public void testGuardar() throws MyException {
		Planeta planeta = new Planeta();
		planeta.setNombre("marte");
		planeta.setGalaxia(galaxiaDao.consultaUnica("via lactea"));
		
		
		assertTrue(planetaDao.guardar(planeta));
	}

	@Test
	public void testActualizar() throws MyException {
		
		Planeta planeta = new Planeta();
		planeta.setId(1);
		planeta.setNombre("Tierra 2");
		
		
		assertTrue(planetaDao.actualizar(planeta));
	}

	@Test
	public void testEliminar() throws MyException {
		Planeta planeta = new Planeta();
		planeta.setNombre("Via nu");
		
		
		assertTrue(planetaDao.eliminar(planeta));
	}

}
