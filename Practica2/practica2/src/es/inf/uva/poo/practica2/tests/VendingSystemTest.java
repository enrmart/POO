package es.inf.uva.poo.practica2.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.junit.Test;

import es.inf.uva.poo.practica2.clases.Linea;
import es.inf.uva.poo.practica2.clases.Producto;
import es.inf.uva.poo.practica2.clases.Vendible;
import es.inf.uva.poo.practica2.clases.VendingCity;
import es.inf.uva.poo.practica2.clases.VendingMachine;
import es.inf.uva.poo.practica2.clases.VendingSystem;

public class VendingSystemTest {
	static Linea[][]linea;
	static VendingMachine maquinaA;
	static ArrayList<VendingMachine> maquinas;
	static ArrayList<VendingCity> city;
	static VendingCity city1 ;
	
	private void llenarDatos() {
		
		linea= new Linea[4][4];
		rellenaLinea();
		maquinaA=new VendingMachine("124567891", true, linea);
		maquinas = new ArrayList<>();
		rellenaMaquina();
		city = new ArrayList<>();
		city1 = new VendingCity(maquinas, 48, "Tarragona");
		city.add(city1);
	}
	private void rellenaMaquina() {
		maquinas.add(maquinaA);
		
	}
	private void rellenaLinea() {
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
		pro.setPrecio(2.0);
		Linea relleno=new Linea("34",pro,5);
		for(int i=0;i<linea.length;i++) {
			for(int j=0;j<linea.length;j++) {
				linea[i][j]=relleno;
			}
		}
	}
	@Test
	public void TestConstructorVendingSystem() {
		llenarDatos();
		VendingSystem sede1= new VendingSystem(city);
		assertNotNull(sede1);
	}
	@Test (expected=IllegalArgumentException.class)
	public void TestConstructorVendingSystemNull() {
		VendingSystem sede1= new VendingSystem(null);
		assertNull(sede1);
	}
	@Test
	public void TestGetSedesTotales() {
		llenarDatos();
		VendingSystem sede1= new VendingSystem(city);
		assertEquals(city, sede1.getSedesTotales());
	}
	@Test
	public void TestGetNumSedes() {
		llenarDatos();
		VendingSystem sede1= new VendingSystem(city);
		assertEquals(city.size(), sede1.getNumSedes());
	}
	@Test
	public void TestGetNumProvincias() {
		llenarDatos();
		VendingSystem sede1= new VendingSystem(city);
		assertEquals(1, sede1.getNumProvincias());
	}
	@Test
	public void TestGetMaquinasProvincias() {
		llenarDatos();
		VendingSystem sede1= new VendingSystem(city);
		int maquinas;
		String provincia;
		HashMap<String, Integer> maquinasProvincias = new HashMap<>();
		
		for(int i = 0;i<city.size();i++) {
			maquinas= city.get(i).getMaquinasTotales().size();
			provincia = city.get(i).getProvincia();
			maquinasProvincias.put(provincia,maquinas);
		}
		assertEquals(sede1.getMaquinasProvincia(),maquinasProvincias);
	}
	
	@Test
	public void TestAddSede() {
		llenarDatos();
		VendingSystem sede1= new VendingSystem(city);
		VendingCity sede2= new VendingCity(city1);
		sede1.addSede(sede2);
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void TestAddSedeNull() {
		llenarDatos();
		VendingCity sede2=null;
		VendingSystem sede1= new VendingSystem(city);
		sede1.addSede(sede2);
	}
	
	
	@Test (expected=IllegalArgumentException.class)
	public void TestRemoveSedeIdentificadorMayor53() {
		llenarDatos();
		VendingSystem sede1= new VendingSystem(city);
		sede1.removeSede(54);
	}
	@Test (expected=IllegalArgumentException.class)
	public void TestRemoveSedeIdentificadorNeg() {
		llenarDatos();
		VendingSystem sede1= new VendingSystem(city);
		sede1.removeSede(-1);
	}
	@Test
	public void TestRemoveSede() {
		llenarDatos();
		VendingSystem sede1= new VendingSystem(city);
		sede1.removeSede(48);
	}
	
	
	@Test
	public void TestGetNumMaquinasSede() {
		llenarDatos();
		VendingSystem sede1= new VendingSystem(city);
		assertEquals(1, sede1.getNumMaquinasSede(48));
	}
	@Test (expected=IllegalArgumentException.class)
	public void TestGetNumMaquinasSedeNumMayor53() {
		llenarDatos();
		VendingSystem sede1= new VendingSystem(city);
		sede1.getNumMaquinasSede(-1);
	}
	@Test (expected=IllegalArgumentException.class)
	public void TestGetNumMaquinasSedeNumNeg() {
		llenarDatos();
		VendingSystem sede1= new VendingSystem(city);
		sede1.getNumMaquinasSede(54);
	}
	
	
	@Test
	public void TestGetMaquinasSede() {
		llenarDatos();
		rellenaLinea();
		rellenaMaquina();
		VendingSystem sede1= new VendingSystem(city);
		assertEquals(maquinas.get(0), sede1.getMaquinasSede(48));
	}
	@Test (expected=IllegalArgumentException.class)
	public void TestGetMaquinasSedeNumNeg() {
		llenarDatos();
		VendingSystem sede1= new VendingSystem(city);
		sede1.getMaquinasSede(-1);
	}
	@Test (expected=IllegalArgumentException.class)
	public void TestGetMaquinasSedeNumMayor53() {
		llenarDatos();
		VendingSystem sede1= new VendingSystem(city);
		sede1.getMaquinasSede(54);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void TestSetSedesTotalesNull() {
		llenarDatos();
		VendingSystem sede1= new VendingSystem(city);
		ArrayList<VendingCity> city2 = null;
		sede1.setSedesTotales(city2);
	}
	@Test 
	public void TestSetSedesTotales() {
		llenarDatos();
		VendingSystem sede1= new VendingSystem(city);
		ArrayList<VendingCity> city2 = new ArrayList();
		city2.add(city1);
		sede1.setSedesTotales(city2);
	}
}
