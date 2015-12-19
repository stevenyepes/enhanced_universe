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

import com.edu.udea.iw.dao.GalaxiaDAO;
import com.edu.udea.iw.dao.PlanetaDAO;
import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.dto.Planeta;
import com.edu.udea.iw.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springcfg.xml")

@Transactional

public class planetaDAOImplTest {

	@Autowired
	PlanetaDAO planetaDAO;
	
	@Autowired
	GalaxiaDAO galaxiaDAO;
	
	@Test
	public void testConsultar() throws MyException {
		List <Planeta> planetas = new ArrayList<Planeta>();
		planetas = planetaDAO.consultar();
		
		assertTrue(planetas.size()>0);
	}

	@Test
	public void testConsultaUnica() throws MyException {

		Planeta planeta;
		planeta  = planetaDAO.consultaUnica("tierra");
		assertTrue(planeta != null);
	}

	@Test
	public void testGuardar() throws MyException {
		Planeta planeta = new Planeta();
		planeta.setNombre("marte");
		planeta.setGalaxia(galaxiaDAO.consultaUnica("via lactea"));
		
		
		assertTrue(planetaDAO.guardar(planeta));
	}

	@Test
	public void testActualizar() throws MyException {
		
		Planeta planeta = new Planeta();
		planeta.setId(1);
		planeta.setNombre("Tierra 2");
		
		
		assertTrue(planetaDAO.actualizar(planeta));
	}

	@Test
	public void testEliminar() throws MyException {
		Planeta planeta = new Planeta();
		planeta.setNombre("Via nu");
		
		
		assertTrue(planetaDAO.eliminar(planeta));
	}

}
