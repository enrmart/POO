package es.inf.uva.poo.practica2.tests;


import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import es.inf.uva.poo.practica2.clases.Linea;
import es.inf.uva.poo.practica2.clases.Producto;
import es.inf.uva.poo.practica2.clases.Vendible;
import es.inf.uva.poo.practica2.clases.VendingMachine;
import fabricante.externo.tarjetas.TarjetaMonedero;

public class VendingMachineTest {

		@Test
		public void TestConstructorVendingMachine() {
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
			VendingMachine ori =new VendingMachine("3456",true,maquina);
			assertNotNull(ori);	
			assertEquals("3456",ori.getIdentificador());
			assertEquals(true,ori.getEstado());
		}

		@Test(expected=IllegalArgumentException.class)
		public void TestConstructorVendingMachineIdNull() {
			Linea[][]maquina=new Linea [6][6];
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
			VendingMachine ori =new VendingMachine(null,true,maquina);
			VendingMachine copia=new VendingMachine(ori);	
			assertNotNull(copia);	
			assertEquals(ori,copia);
		}
		
		

		
		
		@Test
		public void TestConstructorCopiaVendingMachine() {
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
			VendingMachine ori =new VendingMachine("3456",true,maquina);
			VendingMachine copia=new VendingMachine(ori);	
			assertNotNull(copia);	
		}
	
		
		@Test(expected=IllegalArgumentException.class)
		public void TestConstructorCopiaVendingMachineNull() {
			VendingMachine copia=new VendingMachine(null);	
		}
		
		
		@Test
		public void TestSetMaquina() {
			Linea[][]maquina=new Linea [3][3];
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
			VendingMachine ori =new VendingMachine("3456",true,maquina);
			ori.setMaquina(5);
			assertNotNull(ori.getMaquina());
			assertEquals(5,ori.getMaquina().length);
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void TestSetMaquinaExtremoInferior() {
			Linea[][]maquina=new Linea [3][3];
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
			VendingMachine ori =new VendingMachine("3456",true,maquina);
			ori.setMaquina(0);
			assertNotNull(ori.getMaquina());
			assertEquals(0,ori.getMaquina().length);
		}
		
		
		
		@Test(expected=IllegalArgumentException.class)
		public void TestSetMaquinaInferiorque0() {
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
			VendingMachine ori =new VendingMachine("3456",true,maquina);
			ori.setMaquina(-4);
		}
		
		
		
		@Test
		public void TestCompra() {
			TarjetaMonedero tarjeta=new TarjetaMonedero("A156Bv09_1zXo894",450);
			Linea[][]maquina=new Linea [6][6];
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
			VendingMachine prueba =new VendingMachine("3456",true,maquina);
			prueba.compra(tarjeta,"3 5","6Z1y00Nm31aA-571");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void TestCompraTarjetaNull() {
			Linea[][]maquina=new Linea [6][6];
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
			VendingMachine prueba =new VendingMachine("3456",true,maquina);
			prueba.compra(null, "3 5","6Z1y00Nm31aA-571");
		}
		
		
		@Test(expected=IllegalArgumentException.class)
		public void TestCompraIdentificadorNull() {
			TarjetaMonedero tarjeta=new TarjetaMonedero("A156Bv09_1zXo894",450);
			Linea[][]maquina=new Linea [6][6];
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
			VendingMachine prueba =new VendingMachine("3456",true,maquina);
			prueba.compra(tarjeta,null,"6Z1y00Nm31aA-571");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void TestCompraIdentificadorEmpty() {
			TarjetaMonedero tarjeta=new TarjetaMonedero("A156Bv09_1zXo894",450);
			Linea[][]maquina=new Linea [6][6];
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
			VendingMachine prueba =new VendingMachine("3456",true,maquina);
			prueba.compra(tarjeta,"","6Z1y00Nm31aA-571");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void TestCompraCredencialNull() {
			TarjetaMonedero tarjeta=new TarjetaMonedero("A156Bv09_1zXo894",450);
			Linea[][]maquina=new Linea [6][6];
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
			VendingMachine prueba =new VendingMachine("3456",true,maquina);
			prueba.compra(tarjeta, "3 5",null);
		}
		
		
		@Test(expected=IllegalArgumentException.class)
		public void TestCompraNum1Mayor() {
			TarjetaMonedero tarjeta=new TarjetaMonedero("A156Bv09_1zXo894",450);
			Linea[][]maquina=new Linea [6][6];
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
			VendingMachine prueba =new VendingMachine("3456",true,maquina);
			prueba.compra(tarjeta, "34 5","6Z1y00Nm31aA-571");
		}
		
		
		@Test(expected=IllegalArgumentException.class)
		public void TestCompraNum2Mayor() {
			TarjetaMonedero tarjeta=new TarjetaMonedero("A156Bv09_1zXo894",450);
			Linea[][]maquina=new Linea [6][6];
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
			VendingMachine prueba =new VendingMachine("3456",true,maquina);
			prueba.compra(tarjeta, "3 56","6Z1y00Nm31aA-571");
		}
		
		
		
		@Test(expected=IllegalArgumentException.class)
		public void TestCompraNum2Extremo() {
			TarjetaMonedero tarjeta=new TarjetaMonedero("A156Bv09_1zXo894",450);
			Linea[][]maquina=new Linea [6][6];
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
			VendingMachine prueba =new VendingMachine("3456",true,maquina);
			String identificador= "3 "+String.valueOf(prueba.getMaquina().length);
			prueba.compra(tarjeta, identificador,"6Z1y00Nm31aA-571");
		}
		
		
		@Test(expected=IllegalArgumentException.class)
		public void TestCompraNum1Extremo() {
			TarjetaMonedero tarjeta=new TarjetaMonedero("A156Bv09_1zXo894",450);
			Linea[][]maquina=new Linea [6][6];
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
			VendingMachine prueba =new VendingMachine("3456",true,maquina);
			String identificador= String.valueOf(prueba.getMaquina().length)+" 3";
			prueba.compra(tarjeta, identificador,"6Z1y00Nm31aA-571");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void TestCompraNoCantidad() {
			TarjetaMonedero tarjeta=new TarjetaMonedero("A156Bv09_1zXo894",450);
			Linea[][]maquina=new Linea [6][6];
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
			Linea relleno=new Linea("34",pro,0);
			for(int i=0;i<maquina.length;i++) {
				for(int j=0;j<maquina.length;j++) {
					maquina[i][j]=relleno;
				}
			}
			VendingMachine prueba =new VendingMachine("3456",true,maquina);
			prueba.compra(tarjeta, "3 3","6Z1y00Nm31aA-571");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void TestCompraDineroInsuficiente() {
			TarjetaMonedero tarjeta=new TarjetaMonedero("A156Bv09_1zXo894",1);
			Linea[][]maquina=new Linea [6][6];
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
			VendingMachine prueba =new VendingMachine("3456",true,maquina);
			prueba.compra(tarjeta, "3 3","6Z1y00Nm31aA-571");
		}
		
		@Test
		public void TestReabastecimientoModoUnicaLinea() {
			Linea[][]maquina=new Linea [6][6];
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
			VendingMachine prueba =new VendingMachine("3456",true,maquina);
			prueba.reabastecimiento(4,5,5);
		}
		
		
		@Test
		public void TestReabastecimientoMaquinaTotal() {
			Linea[][]maquina=new Linea [6][6];
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
			Linea relleno=new Linea("34",pro,0);
			for(int i=0;i<maquina.length;i++) {
				for(int j=0;j<maquina.length;j++) {
					maquina[i][j]=relleno;
				}
			}
			VendingMachine prueba =new VendingMachine("3456",true,maquina);
			prueba.reabastecimiento(4,5,1);
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void TestReabastecimientoNum1ExtremoSuperior() {
			Linea[][]maquina=new Linea [6][6];
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
			VendingMachine prueba =new VendingMachine("3456",true,maquina);
			prueba.reabastecimiento(6,4,5);
		}
		
		
		@Test(expected=IllegalArgumentException.class)
		public void TestReabastecimientoNum2ExtremoSuperior() {
			Linea[][]maquina=new Linea [6][6];
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
			VendingMachine prueba =new VendingMachine("3456",true,maquina);
			prueba.reabastecimiento(4,6,6);
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void TestReabastecimientoExtremoInferiorNum2() {
			Linea[][]maquina=new Linea [6][6];
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
			VendingMachine prueba =new VendingMachine("3456",true,maquina);
			prueba.reabastecimiento(4,-5,5);
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void TestReabastecimientoExtremoInferiorNum1() {
			Linea[][]maquina=new Linea [6][6];
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
			VendingMachine prueba =new VendingMachine("3456",true,maquina);
			prueba.reabastecimiento(-4,5,5);
		}
		
		
		
		
		
}
