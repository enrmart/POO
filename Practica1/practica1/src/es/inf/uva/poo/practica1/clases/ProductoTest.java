package es.inf.uva.poo.practica1.clases;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class ProductoTest {

	@Test
	public void TestConstructorProducto() {
		Producto ori =new Producto();
		assertNotNull(ori);
		assertNull(ori.getFechaCad());
		assertEquals("",ori.getNombre());
	}
	
	
	@Test
	public void TestConstructorCopiaProducto() {
		Producto ori =new Producto();
		Producto copia=new Producto(ori);
		assertNotNull(copia);
	}


	@Test
	public void TestSetPrecio() {
		Producto ori =new Producto();
		double pre=5;
		ori.setPrecio(pre);
		assertEquals(pre,ori.getPrecio(),0.4);
	}
	
	
	@Test
	public void TestSetPrecioAVLExtremoInferior() {
		Producto ori =new Producto();
		double pre=0;
		ori.setPrecio(pre);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void TestSetPrecioAVLMenorExtremo() {
		Producto ori =new Producto();
		double pre=-4;
		ori.setPrecio(pre);
	}
	
	@Test
	public void TestSetFechaCad() {
		Producto ori =new Producto();
		Date fec=new Date();
		fec.setTime(29714136);
		ori.setFechaCad(fec);
		assertNotNull(ori.getFechaCad());
		assertEquals(fec,ori.getFechaCad());
	}
	
	
	@Test
	public void TestSetNombre() {
		Producto ori =new Producto();
		String nom="AZUL";
		ori.setNombre(nom);
		assertNotNull(ori.getNombre());
		assertEquals(nom,ori.getNombre());
	}
	
	
	@Test
	public void TestSetUpc() {
		Producto ori =new Producto();
		String pc="12345678910";
		ori.setUpc(pc);
		assertNotNull(ori.getUpc());
	}
	
	
	@Test(expected=AssertionError.class)
	public void TestSetUpcMenor() {
		Producto ori =new Producto();
		String pc="12345";
		ori.setUpc(pc);
	}
	
	@Test(expected=AssertionError.class)
	public void TestSetUpcMayor() {
		Producto ori =new Producto();
		String pc="1234946586285";
		ori.setUpc(pc);
	}
	
	
}
