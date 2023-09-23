package es.inf.uva.poo.practica1.clases;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import es.inf.uva.poo.practica1.clases.VendingMachine;

public class VendingSystemTest {

	@Test
	public void TestConstructor() {
		VendingSystem sys=new VendingSystem();
		assertNotNull(sys);
	}
	
	@Test
	public void TestConstructorCopiaProducto() {
		VendingSystem ori =new VendingSystem();
		VendingSystem copia=new VendingSystem(ori);
		assertNotNull(copia);
	}
	

	@Test
	public void TestsetMaquinasTotales() {
		VendingSystem sys =new VendingSystem();
		ArrayList<VendingMachine> maquinasTotales=new ArrayList();
		sys.setMaquinasTotales(maquinasTotales);
		assertNotNull(sys.getMaquinasTotales());
	}
	
	
	@Test
	public void TestsetMaquinasLineaVacia() {
		VendingSystem sys =new VendingSystem();
		ArrayList<VendingMachine> maquinasLineaVacia=new ArrayList();
		sys.setMaquinasLineaVacia(maquinasLineaVacia);
		assertNotNull(sys.getMaquinasLineaVacia());
	}
	

	@Test
	public void TestsetMaquinasOperativasExtremoInf() {
		VendingSystem sys =new VendingSystem();
		int maquinasOperativas =0;
		sys.setMaquinasOperativas(maquinasOperativas);
	}
	
	@Test
	public void TestsetMaquinasOperativas() {
		VendingSystem sys =new VendingSystem();
		int maquinasOperativas =5;
		sys.setMaquinasOperativas(maquinasOperativas);
		assertNotNull(sys. getMaquinasOperativas());
		assertEquals(maquinasOperativas, sys.getMaquinasOperativas());
	}
	
	@Test(expected=AssertionError.class)
	public void TestLineaVaciaNull() {
		VendingSystem sys =new VendingSystem();
		ArrayList<VendingMachine> maquinasLineaVacia=null;
		sys.lineaVacia(maquinasLineaVacia);
	}
	
	@Test
	public void TestLineasVacias() {
		VendingSystem sys =new VendingSystem();
		ArrayList<VendingMachine> maquinasLineaVacia=new ArrayList();
		sys.lineaVacia(maquinasLineaVacia);
		assertNotNull(maquinasLineaVacia);
	}
	
	@Test
	public void TestEliminar() {
		VendingSystem sys =new VendingSystem();
		String identif = "3 5";
		ArrayList<VendingMachine> maquina=new ArrayList();
		sys.eliminar(identif,maquina);
		assertNotNull(identif, maquina);
	}
	
	@Test(expected=AssertionError.class)
	public void TestEliminarIdentifNull() {
		VendingSystem sys =new VendingSystem();
		String identif =null;
		ArrayList<VendingMachine> maquina=new ArrayList();
		sys.eliminar(identif,maquina);
	}
	
	@Test(expected=AssertionError.class)
	public void TestEliminarMaquinaNull() {
		VendingSystem sys =new VendingSystem();
		String identif ="3 5";
		ArrayList<VendingMachine> maquina=null;
		sys.eliminar(identif,maquina);
	}
	
	@Test
	public void Testaniadir() {
		VendingSystem sys =new VendingSystem();
		ArrayList<VendingMachine> maquinasTotales=new ArrayList();
		sys.aniadir(maquinasTotales);
		assertNotNull(maquinasTotales);
	}
	
}
