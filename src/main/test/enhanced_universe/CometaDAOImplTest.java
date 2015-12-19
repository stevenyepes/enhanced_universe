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

import com.edu.udea.iw.dao.CometaDAO;
import com.edu.udea.iw.dto.Cometa;
import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.dto.Planeta;
import com.edu.udea.iw.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springcfg.xml")



public class CometaDAOImplTest {

	@Autowired
	CometaDAO cometaDao;
	
	@Test
	public void testConsultar() throws MyException {
		List <Cometa> cometas = new ArrayList<Cometa>();
		cometas = cometaDao.consultar();
		
		assertTrue(cometas.size()>0);
	}

	@Test
	public void testConsultaUnica() throws MyException {
		Cometa cometa;
		cometa  = cometaDao.consultaUnica("halley");
		assertTrue(cometa != null);
	}

}
