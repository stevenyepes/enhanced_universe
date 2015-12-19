package enhanced_universe;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.AdministradorDAO;
import com.edu.udea.iw.dao.AsteroideDAO;
import com.edu.udea.iw.dto.Administrador;
import com.edu.udea.iw.dto.Asteroide;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion de pruebas para los metodos del dao {@link AdministradorDAO}
 * @author enhanced_universe
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springcfg.xml")
public class AdministradorDAOImplTest {

	@Autowired
	AdministradorDAO administradorDao;
	
	@Test
	public void testConsultar() throws MyException {
		List <Administrador> administradores = new ArrayList<Administrador>();
		administradores = administradorDao.consultar();
		
		assertTrue(administradores.size()>0);
	}

	@Test
	public void testConsultaUnica() throws MyException {
		Administrador administrador;
		administrador  = administradorDao.consultaUnica("Steven Yepes");
		assertTrue(administrador != null);
	}

}
