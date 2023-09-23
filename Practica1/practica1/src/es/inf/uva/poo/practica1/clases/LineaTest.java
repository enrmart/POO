package es.inf.uva.poo.practica1.clases;

import static org.junit.Assert.*;
import org.junit.Test;

public class LineaTest {
	
	
	@Test
	public void TestConstructorLinea() {
		Linea ori =new Linea();
		assertNotNull(ori);
		assertEquals(0,ori.getCantidad());
	}
	
	@Test
	public void TestConstructorCopiaLinea() {
		Linea ori =new Linea();
		Linea copia=new Linea(ori);
		assertNotNull(copia);
	}
	
	
	@Test
	public void TestSetIdentificador() {
		Linea ori =new Linea();
		ori.setIdentificadorl("34");
		assertNotNull(ori.getIdentificadorl());
		assertEquals("34",ori.getIdentificadorl());
		
	}
	
	@Test(expected=AssertionError.class)
	public void TestSetProducto() {
		Linea ori =new Linea();
		Producto b= new Producto();
		ori.setProducto(b);
		assertNotNull(ori.getProducto());
		assertEquals(b,ori.getProducto());	
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestSetCantidadAVLPasandoMaximo() {
		Linea ori =new Linea();
		int cant=6;
		ori.setCantidad(cant);
		}
	
	@Test
	public void TestSetCantidadAVLExtremoSuperior() {
		Linea ori =new Linea();
		int cant=5;
		ori.setCantidad(cant);
		assertEquals(5,ori.getCantidad());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestSetCantidadAVLPasandoMinimo() {
		Linea ori =new Linea();
		int cant=-3;
		ori.setCantidad(cant);
	}
	
}
