package enhanced_universe;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edu.udea.iw.bl.AdministradorBL;
import com.edu.udea.iw.bl.AsteroideBL;
import com.edu.udea.iw.dto.Administrador;
import com.edu.udea.iw.exception.MyException;

/**
 * Implementacion de pruebas para los metodos del bl {@link AdministradorBL}
 * @author enhanced_universe
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springcfg.xml")
public class AdministradorBLImplTest {
	
	@Autowired
	AdministradorBL administradorBL;
	
	@Test
	public void testListarAdministradores() throws MyException {
		List<Administrador> administradores = new ArrayList<Administrador>();
		administradores = administradorBL.listarAdministradores();
		assertTrue(administradores.size()>0);
	}

	@Test
	public void testListarAdministrador() throws MyException {
		Administrador administrador;
		String usuario = "Steven Yepes ";
		administrador = administradorBL.listarAdministrador(usuario);
		assertTrue(administrador.getUsuario().equals(usuario));
	}

	@Test
	public void testValidarAdministrador() throws MyException {
		String usuario = "Steven Yepes ";
		String contrasena = "zxc456zxc";
		assertTrue(administradorBL.validarAdministrador(usuario, contrasena));
	}

}
