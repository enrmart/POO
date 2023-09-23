package es.inf.uva.poo.practica2.tests;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.ArrayList;

import org.junit.Test;

import es.inf.uva.poo.practica2.clases.Pack;
import es.inf.uva.poo.practica2.clases.Producto;

public class PackTest {
	static Date fecha;
	static Producto producto1;
	static Producto producto2;
	static Producto producto4;
	static Producto producto5;
	static ArrayList<Producto> productos= new ArrayList();
	static ArrayList<Producto> productos2= new ArrayList();
	static ArrayList<Producto> productos3= new ArrayList();
	private int [] upc() {
		int [] upc= new int [12];
		int num=1;
		
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		return upc;
	}
	
	private void llenarDatos() {
		int [] upc = upc();
		fecha = new Date(System.currentTimeMillis());
		producto1 = new Producto(fecha,upc);
		producto2 = new Producto(fecha,upc);
		llenarProductos();
	}
	private void llenarDatos2() {
		int [] upc = upc();
		fecha = new Date(System.currentTimeMillis());
		producto1 = new Producto(fecha,upc);
		producto2 = new Producto(fecha,upc);
		producto4 = new Producto(fecha,upc);
		llenarProductos2();
	}
	
	private void llenarDatos3() {
		int [] upc = upc();
		fecha = new Date(System.currentTimeMillis());
		producto1 = new Producto(fecha,upc);
		producto5 = null;
		llenarProductos3();
	}
	private void llenarProductos3() {
		productos2.add(producto1);
		productos2.add(producto5);
}
	private void llenarProductos2() {
		productos2.add(producto1);
		productos2.add(producto2);
		productos2.add(producto4);
}
	private void llenarProductos() {
			productos.add(producto1);
			productos.add(producto2);
	}
	
	@Test
	public void TestConstructor() {
		llenarDatos();
		ArrayList<Producto>product = new ArrayList(productos);
		assertNotNull(product);
	}
	@Test (expected=IllegalArgumentException.class)
	public void TestConstructorNull() {
		llenarDatos();
		ArrayList<Producto>product = null;
		
	}
	@Test (expected=IllegalArgumentException.class)
	public void TestConstructorMenor2() {
		llenarDatos();
		ArrayList<Producto> product2 = new ArrayList();
		product2.add(producto1);
		Pack pack = new Pack(product2);
		
	}
	@Test (expected=IllegalArgumentException.class)
	public void TestConstructorNombresIguales() {
		llenarDatos();
		ArrayList<Producto> product2 = new ArrayList();
		product2.add(producto1);
		product2.add(producto1);
		Pack pack = new Pack(product2);
	}
	
	@Test
	public void TestSetIdentificador() {
		llenarDatos();
		Pack pack = new Pack(productos);
		pack.setIdentificador("Cerveza");
	}
	@Test (expected=IllegalArgumentException.class)
	public void TestSetIdentificadorNull() {
		llenarDatos();
		Pack pack = new Pack(productos);
		pack.setIdentificador(null);
	}
	
	@Test 
	public void TestGetIdentificadorNull() {
		llenarDatos();
		Pack pack = new Pack(productos);
		assertEquals(upc(), pack.getIdentificador());
	}
	
	
	@Test 
	public void TestGetProductosTotales() {
		llenarDatos();
		Pack pack = new Pack(productos);
		assertEquals(4, pack.getProductosTotales());
	}
	
	@Test 
	public void TestFormarParte() {
		llenarDatos();
		Pack pack = new Pack(productos);
		assertEquals(true, pack.formarParte(producto1));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void TestFormarParteNull() {
		llenarDatos();
		Producto producto3 = null;
		Pack pack = new Pack(productos);
		pack.formarParte(producto3);
	}
	
	@Test 
	public void TestAddProducto() {
		llenarDatos();
		Producto producto3 = new Producto(producto1);
		Pack pack = new Pack(productos);
		pack.addProducto(producto3);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void TestAddProductoNull() {
		llenarDatos();
		Producto producto3 = null;
		Pack pack = new Pack(productos);
		pack.addProducto(producto3);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void TestAddProductoIgual() {
		llenarDatos();
		Pack pack = new Pack(productos);
		pack.addProducto(producto2);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void TestRemoveProductoNull() {
		llenarDatos();
		String nombre = null;
		Pack pack = new Pack(productos);
		pack.removeProducto(nombre);
	}
	@Test (expected=IllegalArgumentException.class)
	public void TestRemoveProductoPackigual2() {
		llenarDatos();
		String nombre = "Salchicha";
		Pack pack = new Pack(productos);
		pack.removeProducto(nombre);
	}
	@Test 
	public void TestRemoveProducto() {
		llenarDatos2();
		String nombre = "Salchicha";
		Pack pack = new Pack(productos2);
		pack.removeProducto(nombre);
	}

	@Test 
	public void TestProductosConcretos() {
		llenarDatos();
		Pack pack = new Pack(productos);
		pack.productosConcretos();
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void TestProductosConcretosNull() {
		llenarDatos3();
		Pack pack = new Pack(productos3);
		pack.productosConcretos();
	}
}
