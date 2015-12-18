package enhanced_universe;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.dao.TipoGalaxiaDAO;
import com.edu.udea.iw.dto.TipoGalaxia;
import com.edu.udea.iw.exception.MyException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springcfg.xml")

@Transactional

public class TipoGalaxiaDAOimplTest {

	@Autowired
	TipoGalaxiaDAO tipogalaxiaDAO;
	
	@Test
	public void testConsultar() throws MyException {
		List <TipoGalaxia> tipoGalaxia = new ArrayList<TipoGalaxia>();
		tipoGalaxia = tipogalaxiaDAO.consultar();
		
		assertTrue(tipoGalaxia.size()>0);
	}

	//@Test
	public void testGuardar() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminar() {
		fail("Not yet implemented");
	}

}
