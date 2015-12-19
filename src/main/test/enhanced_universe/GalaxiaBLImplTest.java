package enhanced_universe;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.bl.GalaxiaBL;
import com.edu.udea.iw.dto.Galaxia;
import com.edu.udea.iw.exception.MyException;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springcfg.xml")
public class GalaxiaBLImplTest {

	@Autowired
	GalaxiaBL galaxiaBL;
	
	@Test
	public void testListarGalaxias() throws MyException {
		List<Galaxia> galaxias = new ArrayList<Galaxia>();
		galaxias = galaxiaBL.listarGalaxias();
		assertTrue(galaxias.size()>0);
	}

	@Test
	public void testListarGalaxia() throws MyException {
		Galaxia galaxia;
		String nombre = "via lactea";
		galaxia = galaxiaBL.listarGalaxia(nombre);
		assertTrue(galaxia.getNombre().equals(nombre));
	}

}
