package enhanced_universe;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.AsteroideDAO;
import com.edu.udea.iw.dto.Asteroide;
import com.edu.udea.iw.exception.MyException;

//
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springcfg.xml")

public class AsteroideDAOImplTest {

	@Autowired
	AsteroideDAO asteroideDao;
	
	@Test
	public void testConsultar() throws MyException {
		List <Asteroide> asteroides = new ArrayList<Asteroide>();
		asteroides = asteroideDao.consultar();
		
		assertTrue(asteroides.size()>0);
	}

	@Test
	public void testConsultaUnica() throws MyException {
		Asteroide asteroide;
		asteroide  = asteroideDao.consultaUnica("ceres");
		assertTrue(asteroide != null);
	}

}
