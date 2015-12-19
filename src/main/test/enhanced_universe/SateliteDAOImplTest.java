package enhanced_universe;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.PlanetaDAO;
import com.edu.udea.iw.dao.SateliteDAO;
import com.edu.udea.iw.dto.Cometa;
import com.edu.udea.iw.dto.Satelite;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion de pruebas para los metodos del dao {@link SateliteDAO}
 * @author enhanced_universe
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springcfg.xml")
public class SateliteDAOImplTest {

	@Autowired
	SateliteDAO sateliteDao;
	
	@Test
	public void testConsultar() throws MyException {
		List <Satelite> satelites = new ArrayList<Satelite>();
		satelites = sateliteDao.consultar();
		
		assertTrue(satelites.size()>0);
	}

	@Test
	public void testConsultaUnica() throws MyException {
		Satelite satelite;
		satelite  = sateliteDao.consultaUnica("luna");
		assertTrue(satelite != null);
	}

}
