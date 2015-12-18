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
import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.dto.TipoGalaxia;
import com.edu.udea.iw.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springcfg.xml")

@Transactional

public class GalaxiaDAOImplTest {

	@Autowired
	GalaxiaDAO galaxiaDAO;
	
	@Test
	public void testConsultar() throws MyException {
		List <Galaxia> galaxia = new ArrayList<Galaxia>();
		galaxia = galaxiaDAO.consultar();
		
		assertTrue(galaxia.size()>0);
	}

	@Test
	public void testConsultaUnica() throws MyException {
		
		Galaxia galaxia;
		galaxia  = galaxiaDAO.consultaUnica("via lactea");
		assertTrue(galaxia != null);
	}

	@Test
	public void testGuardar() throws MyException {
		Galaxia galaxia = new Galaxia();
		galaxia.setNombre("Via nueva");
		
		
		assertTrue(galaxiaDAO.guardar(galaxia));
	}

	//@Test
	public void testActualizar() throws MyException {
		Galaxia galaxia = new Galaxia();
		galaxia.setNombre("Via nueva");
		
		
		assertTrue(galaxiaDAO.actualizar(galaxia));
	}

	//@Test
	public void testEliminar() {
		fail("Not yet implemented");
	}

}
