package enhanced_universe;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.CometaDAO;
import com.edu.udea.iw.dao.EstrellaDAO;
import com.edu.udea.iw.dto.Estrella;
import com.edu.udea.iw.exception.MyException;


/**
 * Implementacion de pruebas para los metodos del dao {@link EstrellaDAO}
 * @author enhanced_universe
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springcfg.xml")
public class EstrellaDAOImplTest {

	@Autowired
	EstrellaDAO estrellaDao;	
	
	@Test
	public void testConsultar() throws MyException{
		List <Estrella> estrella = new ArrayList<Estrella>();
		estrella = estrellaDao.consultar();
		
		assertTrue(estrella.size()>0);
	}

	@Test
	public void testConsultaUnica() throws MyException {
		Estrella estrella;
		estrella  = (Estrella) estrellaDao.consultaUnica("sol");
		assertTrue(estrella != null);
	}

}
