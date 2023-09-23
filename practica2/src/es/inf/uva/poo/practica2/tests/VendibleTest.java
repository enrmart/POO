package es.inf.uva.poo.practica2.tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import es.inf.uva.poo.practica2.clases.Producto;
import es.inf.uva.poo.practica2.clases.Vendible;
public class VendibleTest {

	@Test
	public void TestSetNombre() {
		String nombre="Chupachups";
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		Date datecad = new Date(System.currentTimeMillis());
		Vendible pro= new Producto(datecad,upc);
		pro.setNombre(nombre);
		assertEquals(nombre,pro.getNombre());
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestSetNombreNull() {
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		Date datecad = new Date(System.currentTimeMillis());
		Vendible pro= new Producto(datecad,upc);
		pro.setNombre(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestSetNombreVacio() {
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		Date datecad = new Date(System.currentTimeMillis());
		Vendible pro= new Producto(datecad,upc);
		pro.setNombre("");
	}
	
	
	@Test
	public void TestSetPrecio() {
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		Date datecad = new Date(System.currentTimeMillis());
		Vendible pro= new Producto(datecad,upc);
		pro.setPrecio(2.0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestSetPrecioNegativo() {
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		Date datecad = new Date(System.currentTimeMillis());
		Vendible pro= new Producto(datecad,upc);
		pro.setPrecio(-2.0);
	}
	
	@Test
	public void TestGetPrecio() {
		int [] upc= new int [12];
		int num=1;
		for(int i=0;i<upc.length-1;i++) {
			upc[i]=num;
			num++;
		}
		upc[11]=138;
		Date datecad = new Date(System.currentTimeMillis());
		Vendible pro= new Producto(datecad,upc);
		pro.setPrecio(2.0);
		assert(pro.getPrecio()==2.0);
	}
}
