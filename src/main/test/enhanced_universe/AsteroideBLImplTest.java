package enhanced_universe;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.bl.AsteroideBL;
import com.edu.udea.iw.bl.GalaxiaBL;
import com.edu.udea.iw.dto.Asteroide;
import com.edu.udea.iw.dto.TipoGalaxia;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion de pruebas para los metodos del bl {@link AsteroideBL}
 * @author enhanced_universe
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springcfg.xml")
public class AsteroideBLImplTest {

	@Autowired
	AsteroideBL asteroideBL;
	
	@Test
	public void testListarAsteroides() throws MyException {
		List<Asteroide> tiposAsteroides = new ArrayList<Asteroide>();
		tiposAsteroides = asteroideBL.listarAsteroides();
		assertTrue(tiposAsteroides.size()>0);
	}

	@Test
	public void testListarAsteroide() throws MyException {
		Asteroide asteroide;
		String nombre = "ceres";
		asteroide = asteroideBL.listarAsteroide(nombre);
		assertTrue(asteroide.getNombre().equals(nombre));
	}

}
