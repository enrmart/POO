package es.inf.uva.poo.practica2.tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import es.inf.uva.poo.practica2.clases.Linea;
import es.inf.uva.poo.practica2.clases.Producto;
import es.inf.uva.poo.practica2.clases.Vendible;

public class LineaTest {
	
	
	@Test
	public void TestConstructorLinea() {
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		Date datecad = new Date(System.currentTimeMillis());
		Vendible pro= new Producto(datecad,upc);
		Linea ori =new Linea("3456",pro,3);
		assertNotNull(ori);
		assertEquals(3,ori.getCantidad());
	}
	
	
	@Test
	public void TestsetCantidad0() {
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		Date datecad = new Date(System.currentTimeMillis());
		Vendible pro= new Producto(datecad,upc);
		Linea ori =new Linea("3456",pro,0);
		assertNotNull(ori);
		assertEquals(0,ori.getCantidad());
		
	}
	
	
	@Test
	public void TestsetCantidad5() {
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		Date datecad = new Date(System.currentTimeMillis());
		Vendible pro= new Producto(datecad,upc);
		Linea ori =new Linea("3456",pro,5);
		assertNotNull(ori);
		assertEquals(5,ori.getCantidad());
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestsetCantidadInferior0() {
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		Date datecad = new Date(System.currentTimeMillis());
		Vendible pro= new Producto(datecad,upc);
		Linea ori =new Linea("3456",pro,-33);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestsetCantSuperior5() {
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		Date datecad = new Date(System.currentTimeMillis());
		Vendible pro= new Producto(datecad,upc);
		Linea ori =new Linea("3456",pro,58);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void TestConstructorLineaVendibleNull() {
		Linea ori =new Linea("3456",null,3);
	}
	
	
	@Test
	public void TestConstructorCopiaLinea() {
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		Date datecad = new Date(System.currentTimeMillis());
		Vendible pro= new Producto(datecad,upc);
		Linea ori =new Linea("3456",pro,3);
		Linea copia=new Linea(ori);
		assertNotNull(copia);
		assertEquals(ori,copia);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestConstructorCopiaLineaNull() {
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		Date datecad = new Date(System.currentTimeMillis());
		Vendible pro= new Producto(datecad,upc);
		Linea ori =new Linea("3456",pro,3);
		Linea copia=new Linea(ori);
	}
	
	@Test
	public void TestSetIdentificador() {
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		Date datecad = new Date(System.currentTimeMillis());
		Vendible pro= new Producto(datecad,upc);
		Linea ori =new Linea("3456",pro,3);
		ori.setIdentificadorl("34");
		assertNotNull(ori.getIdentificadorl());
		assertEquals("34",ori.getIdentificadorl());
		
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void TestSetIdentificadorNull() {
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		Date datecad = new Date(System.currentTimeMillis());
		Vendible pro= new Producto(datecad,upc);
		Linea ori =new Linea("3456",pro,3);
		ori.setIdentificadorl(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestSetIdentificadorEmpty() {
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		Date datecad = new Date(System.currentTimeMillis());
		Vendible pro= new Producto(datecad,upc);
		Linea ori =new Linea("3456",pro,3);
		ori.setIdentificadorl("");
	}
	
}
