package enhanced_universe;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.TipoEspectralDAO;
import com.edu.udea.iw.dto.TipoEspectral;
import com.edu.udea.iw.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springcfg.xml")

public class TipoEspectralDAOImplTest {

	@Autowired
	TipoEspectralDAO tipoEspectralDao;
	
	@Test
	public void testConsultar() throws MyException {
		List <TipoEspectral> tipoEspectral = new ArrayList<TipoEspectral>();
		tipoEspectral = tipoEspectralDao.consultar();
		
		assertTrue(tipoEspectral.size()>0);
	}

}
