package es.inf.uva.poo.practica2.tests;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import es.inf.uva.poo.practica2.clases.Linea;
import es.inf.uva.poo.practica2.clases.Producto;
import es.inf.uva.poo.practica2.clases.Vendible;
import es.inf.uva.poo.practica2.clases.VendingCity;
import es.inf.uva.poo.practica2.clases.VendingMachine;


public class VendingCityTest {

	@Test
	public void TestConstructor() {
		ArrayList<VendingMachine> maquinas=new ArrayList();
		Linea[][]maquina=new Linea [5][5];
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
		for(int i=0;i<maquina.length;i++) {
			for(int j=0;j<maquina.length;j++) {
				maquina[i][j]=relleno;
			}
		}
		VendingMachine Vend =new VendingMachine("3456",true,maquina);
		maquinas.add(Vend);
		maquinas.add(Vend);
		VendingCity ori =new VendingCity(maquinas,34,"Palencia");
		assertNotNull(ori);
	}
	
	
	@Test
	public void TestConstructorCodiproExtremoSup() {
		ArrayList<VendingMachine> maquinas=new ArrayList();
		Linea[][]maquina=new Linea [5][5];
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
		for(int i=0;i<maquina.length;i++) {
			for(int j=0;j<maquina.length;j++) {
				maquina[i][j]=relleno;
			}
		}
		VendingMachine Vend =new VendingMachine("3456",true,maquina);
		maquinas.add(Vend);
		maquinas.add(Vend);
		VendingCity ori =new VendingCity(maquinas,53,"Palencia");
		assertNotNull(ori);
		assertEquals(53,ori.getCodigoProvincia());
	}
	
	

	@Test
	public void TestConstructorCodiproExtremoInf() {
		ArrayList<VendingMachine> maquinas=new ArrayList();
		Linea[][]maquina=new Linea [5][5];
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
		for(int i=0;i<maquina.length;i++) {
			for(int j=0;j<maquina.length;j++) {
				maquina[i][j]=relleno;
			}
		}
		VendingMachine Vend =new VendingMachine("3456",true,maquina);
		maquinas.add(Vend);
		maquinas.add(Vend);
		VendingCity ori =new VendingCity(maquinas,0,"Palencia");
		assertNotNull(ori);
		assertEquals(0,ori.getCodigoProvincia());
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void TestConstructorMaquinasNull() {
		VendingCity ori =new VendingCity(null,34,"Palencia");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestConstructorProvinicaNull() {
		ArrayList<VendingMachine> maquinas=new ArrayList();
		Linea[][]maquina=new Linea [5][5];
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
		for(int i=0;i<maquina.length;i++) {
			for(int j=0;j<maquina.length;j++) {
				maquina[i][j]=relleno;
			}
		}
		VendingMachine Vend =new VendingMachine("3456",true,maquina);
		maquinas.add(Vend);
		maquinas.add(Vend);
		VendingCity ori =new VendingCity(maquinas,0,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestConstructorProvinicaEmpty() {
		ArrayList<VendingMachine> maquinas=new ArrayList();
		Linea[][]maquina=new Linea [5][5];
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
		for(int i=0;i<maquina.length;i++) {
			for(int j=0;j<maquina.length;j++) {
				maquina[i][j]=relleno;
			}
		}
		VendingMachine Vend =new VendingMachine("3456",true,maquina);
		maquinas.add(Vend);
		maquinas.add(Vend);
		VendingCity ori =new VendingCity(maquinas,0,"");
	}
	
	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void TestConstructorCodiproMasGrandeExtremoInf() {
		ArrayList<VendingMachine> maquinas=new ArrayList();
		Linea[][]maquina=new Linea [5][5];
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
		for(int i=0;i<maquina.length;i++) {
			for(int j=0;j<maquina.length;j++) {
				maquina[i][j]=relleno;
			}
		}
		VendingMachine Vend =new VendingMachine("3456",true,maquina);
		maquinas.add(Vend);
		maquinas.add(Vend);
		VendingCity ori =new VendingCity(maquinas,-6,"Palencia");
	}
	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void TestConstructorCodiproMasGrandeExtremoSup() {
		ArrayList<VendingMachine> maquinas=new ArrayList();
		Linea[][]maquina=new Linea [5][5];
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
		for(int i=0;i<maquina.length;i++) {
			for(int j=0;j<maquina.length;j++) {
				maquina[i][j]=relleno;
			}
		}
		VendingMachine Vend =new VendingMachine("3456",true,maquina);
		maquinas.add(Vend);
		maquinas.add(Vend);
		VendingCity ori =new VendingCity(maquinas,60,"Palencia");
	}
	
	
	@Test
	public void TestConstructorCopiaVendingCity() {
		ArrayList<VendingMachine> maquinas=new ArrayList();
		Linea[][]maquina=new Linea [5][5];
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
		for(int i=0;i<maquina.length;i++) {
			for(int j=0;j<maquina.length;j++) {
				maquina[i][j]=relleno;
			}
		}
		VendingMachine Vend =new VendingMachine("3456",true,maquina);
		maquinas.add(Vend);
		maquinas.add(Vend);
		VendingCity ori =new VendingCity(maquinas,34,"Palencia");
		VendingCity copia=new VendingCity(ori);
		assertNotNull(copia);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void TestConstructorCopiaVendingCityNull() {
		VendingCity ori=null;
		VendingCity copia=new VendingCity(ori);
	}
	

	@Test
	public void TestsetMaquinasTotales() {
		ArrayList<VendingMachine> maquinas=new ArrayList();
		VendingCity sys =new VendingCity(maquinas,34,"Palencia");
		ArrayList<VendingMachine> maquinasTotales=new ArrayList();
		sys.setMaquinasTotales(maquinasTotales);
	}
	
	
	@Test
	public void TestgetMaquinasLineaVacia() {
		ArrayList<VendingMachine> maquinas=new ArrayList();
		Linea[][]maquina=new Linea [5][5];
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
		for(int i=0;i<maquina.length;i++) {
			for(int j=0;j<maquina.length;j++) {
				maquina[i][j]=relleno;
			}
		}
		VendingMachine Vend =new VendingMachine("3456",true,maquina);
		maquinas.add(Vend);
		maquinas.add(Vend);
		VendingCity sys =new VendingCity(maquinas,34,"Palencia");
		assertEquals(sys.getMaquinasLineaVacia(),maquinas);
	}
	
	@Test
	public void TestgetMaquinasOperativas() {
		ArrayList<VendingMachine> maquinas=new ArrayList();
		VendingCity sys =new VendingCity(maquinas,34,"Palencia");
		assertEquals(sys.getMaquinasOperativas(),0);
	}
	
	@Test
	public void TestgetProvincia() {
		ArrayList<VendingMachine> maquinas=new ArrayList();
		VendingCity sys =new VendingCity(maquinas,34,"Palencia");
		assertEquals("Palencia",sys.getProvincia());
	}
	
	@Test
	public void TestgetCodigoPro() {
		ArrayList<VendingMachine> maquinas=new ArrayList();
		VendingCity sys =new VendingCity(maquinas,34,"Palencia");
		assertEquals(34,sys.getCodigoProvincia());
	}
	
	@Test
	public void TestEliminar() {
		ArrayList<VendingMachine> maquinas=new ArrayList();
		Linea[][]maquina=new Linea [5][5];
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
		for(int i=0;i<maquina.length;i++) {
			for(int j=0;j<maquina.length;j++) {
				maquina[i][j]=relleno;
			}
		}
		VendingMachine Vend =new VendingMachine("3456",true,maquina);
		maquinas.add(Vend);
		maquinas.add(Vend);
		VendingCity ori =new VendingCity(maquinas,34,"Palencia");
		ori.eliminar("3456");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestEliminarIdentifNull() {
		ArrayList<VendingMachine> maquinas=new ArrayList();
		Linea[][]maquina=new Linea [5][5];
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
		for(int i=0;i<maquina.length;i++) {
			for(int j=0;j<maquina.length;j++) {
				maquina[i][j]=relleno;
			}
		}
		VendingMachine Vend =new VendingMachine("3456",true,maquina);
		maquinas.add(Vend);
		maquinas.add(Vend);
		VendingCity ori =new VendingCity(maquinas,34,"Palencia");
		ori.eliminar(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void TestEliminarIdentifEmpty() {
		ArrayList<VendingMachine> maquinas=new ArrayList();
		Linea[][]maquina=new Linea [5][5];
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
		for(int i=0;i<maquina.length;i++) {
			for(int j=0;j<maquina.length;j++) {
				maquina[i][j]=relleno;
			}
		}
		VendingMachine Vend =new VendingMachine("3456",true,maquina);
		maquinas.add(Vend);
		maquinas.add(Vend);
		VendingCity ori =new VendingCity(maquinas,34,"Palencia");
		ori.eliminar("");
	}
	
	
	
	@Test(expected=IllegalArgumentException.class)
	public void TestEliminarMaquinasEmpty() {
		ArrayList<VendingMachine> maquinas=new ArrayList();
		VendingCity ori =new VendingCity(maquinas,34,"Palencia");
		ori.eliminar("3");
	}
	
	@Test
	public void TestAddMaquina() {
		ArrayList<VendingMachine> maquinas=new ArrayList();
		Linea[][]maquina=new Linea [5][5];
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
		for(int i=0;i<maquina.length;i++) {
			for(int j=0;j<maquina.length;j++) {
				maquina[i][j]=relleno;
			}
		}
		VendingMachine Vend =new VendingMachine("3456",true,maquina);
		maquinas.add(Vend);
		maquinas.add(Vend);
		VendingCity ori =new VendingCity(maquinas,34,"Palencia");
		ori.addMaquina(Vend);
	}
	
	@Test(expected=NullPointerException.class)
	public void TestAddVendingMachineNull() {
		ArrayList<VendingMachine> maquinas=new ArrayList();
		Linea[][]maquina=new Linea [5][5];
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
		for(int i=0;i<maquina.length;i++) {
			for(int j=0;j<maquina.length;j++) {
				maquina[i][j]=relleno;
			}
		}
		VendingMachine Vend =new VendingMachine("3456",true,maquina);
		maquinas.add(Vend);
		maquinas.add(Vend);
		VendingCity ori =new VendingCity(maquinas,34,"Palencia");
		ori.addMaquina(null);
	}
	
}
