package es.uniovi.asw;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

//import static org.junit.Assert.*;

//import org.junit.Test;

import es.uniovi.asw.test.CircunscripcionTest;
import es.uniovi.asw.test.ColegioElectoralTest;
import es.uniovi.asw.test.ComunidadAutonomaTest;
import es.uniovi.asw.test.ExcelTest;
import es.uniovi.asw.test.OpcionTest;
import es.uniovi.asw.test.TestBeans;
import es.uniovi.asw.test.UsuarioTest;
import es.uniovi.asw.test.VotacionTest;
import es.uniovi.asw.test.VotadoTest;
import es.uniovi.asw.test.VotoTest;

@RunWith(Suite.class)
@SuiteClasses( { CircunscripcionTest.class,
	ColegioElectoralTest.class,
	ComunidadAutonomaTest.class,
	OpcionTest.class,
	UsuarioTest.class,
	VotacionTest.class,
	VotadoTest.class,
	VotoTest.class,
	TestBeans.class,
	ExcelTest.class,
	CucumberTest.class,
	MainControllerTest.class
	})
public class ControlTest {

	//@Test
	//public static void test() {
		
		//TestSuite suite = new TestSuite("Test for com.chuidiang.ejemplos");
	    // suite.addTestSuite();
	    //  suite.addTest(ColegioElectoralTest.class);
		//suite.addTestSuite(new CircunscripcionTest().getClass());
		
		//new ComunidadAutonomaTest();
		//new OpcionTest();
	
		
	//}

}
