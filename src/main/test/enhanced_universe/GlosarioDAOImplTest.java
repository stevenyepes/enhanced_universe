package enhanced_universe;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.GlosarioDAO;
import com.edu.udea.iw.dto.Glosario;
import com.edu.udea.iw.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springcfg.xml")

public class GlosarioDAOImplTest {

	@Autowired
	GlosarioDAO glosarioDao;
	
	@Test
	public void testConsultar() throws MyException {
		List <Glosario> glosarios = new ArrayList<Glosario>();
		glosarios = glosarioDao.consultar();
		
		assertTrue(glosarios.size()>0);
	}

	@Test
	public void testConsultaUnica() throws MyException {
		Glosario glosario;
		glosario  = glosarioDao.consultaUnica("tipo espectral");
		assertTrue(glosario != null);
	}

}
