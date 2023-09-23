package es.inf.uva.poo.practica2.tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import es.inf.uva.poo.practica2.clases.Producto;
import es.inf.uva.poo.practica2.clases.Vendible;
public class ProductoTest {

	@Test
	public void TestConstructor() {
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		Date datecad = new Date(System.currentTimeMillis());
		Producto pro= new Producto(datecad,upc);
		assertNotNull(pro);
		assertEquals(pro.getFechaCad(),datecad);
		assertEquals(pro.getIdentificador(),upc.toString());
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void TestConstructorFechaNull() {
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		Producto pro= new Producto(null,upc);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestConstructorUpcNull() {
		Date datecad = new Date(System.currentTimeMillis());
		Producto pro= new Producto(datecad,null);
	}
	
	@Test
	public void TestConstructorCopia() {
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		Date datecad = new Date(System.currentTimeMillis());
		Producto pro= new Producto(datecad,upc);
		Producto copia=new Producto(pro);
		assertNotNull(copia);
	}

	@Test(expected=IllegalArgumentException.class)
	public void TestConstructorCopiaNull() {
		Producto copia=new Producto(null);
	}
	
	@Test
	public void TestSetIdentificador() {
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=97;
		Date datecad = new Date(System.currentTimeMillis());
		Producto pro= new Producto(datecad,upc);
		pro.setIdentificador("1234567891");
		assertEquals("123456789101",pro.getIdentificador());
	}

	
}
