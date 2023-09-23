package es.inf.uva.poo.practica1.clases;
import static org.junit.Assert.*;
import org.junit.Test;

import es.inf.uva.poo.practica1.clases.Linea;
import es.inf.uva.poo.practica1.clases.Producto;
import fabricante.externo.tarjetas.TarjetaMonedero;

public class VendingMachineTest {

		@Test
		public void TestConstructorVendingMachine() {
			VendingMachine ori =new VendingMachine();
			assertNotNull(ori);	
		}
		
		@Test
		public void TestConstructorCopiaVendingMachine() {
			VendingMachine ori =new VendingMachine();
			VendingMachine copia=new VendingMachine(ori);	
		}
		
		


		@Test
		public void TestSetIdentificador() {
			VendingMachine ori =new VendingMachine();
			ori.setIdentificador("3456");
			assertNotNull(ori.getIdentificador());
			assertEquals("3456",ori.getIdentificador());
			
		}
		

		
		
		@Test
		public void TestSetEstadoTrue() {
			VendingMachine ori =new VendingMachine();
			ori.setEstado(true);
			assertNotNull(ori.getEstado());
			assertEquals(true,ori.getEstado());
			
		}
		
		@Test
		public void TestSetEstadoFalse() {
			VendingMachine ori =new VendingMachine();
			ori.setEstado(false);
			assertNotNull(ori.getEstado());
			assertEquals(false,ori.getEstado());
			
		}
		
		@Test
		public void TestSetMaquina() {
			VendingMachine ori =new VendingMachine();
			ori.setMaquina(6);
			assertNotNull(ori.getMaquina());
			assertEquals(6,ori.getMaquina().length);
			
		}
		
		
		/*
		@Test(expected=IllegalArgumentException.class)
		public void TestCompra() {
			TarjetaMonedero tarjeta=new TarjetaMonedero("Tarjeta2", 450);
			String identificador= "3 5";
			String credencial = "Tarjeta2";
			VendingMachine prueba=new VendingMachine();
			prueba.setMaquina(6);
			prueba.compra(tarjeta, identificador, prueba.getMaquina(),credencial);
		}
		
		@Test(expected=NullPointerException.class)
		public void TestCompraTarjetaNull() {
			TarjetaMonedero tarjeta=null;
			String identificador= "3 5";
			String credencial = "Tarjeta2";
			VendingMachine prueba=new VendingMachine();
			prueba.setMaquina(6);
			prueba.compra(tarjeta, identificador, prueba.getMaquina(),credencial);
		}
		
		
		@Test(expected=IllegalArgumentException.class)
		public void TestCompraIdentificadorNull() {
			TarjetaMonedero tarjeta=new TarjetaMonedero("Tarjeta2", 450);
			String identificador= null;
			String credencial = "Tarjeta2";
			VendingMachine prueba=new VendingMachine();
			prueba.setMaquina(6);
			prueba.compra(tarjeta, identificador, prueba.getMaquina(),credencial);
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void TestCompraCredencialNull() {
			TarjetaMonedero tarjeta=new TarjetaMonedero("Tarjeta2", 450);
			String identificador= "3 5";
			String credencial = null;
			VendingMachine prueba=new VendingMachine();
			prueba.setMaquina(6);
			prueba.compra(tarjeta, identificador, prueba.getMaquina(),credencial);
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void TestCompraMaquinaNull() {
			TarjetaMonedero tarjeta=new TarjetaMonedero("457", 450);
			String identificador= "3 5";
			String credencial = "457";
			VendingMachine prueba=new VendingMachine();
			prueba.compra(tarjeta, identificador, prueba.getMaquina(),credencial);
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void TestCompraNum1Mayor() {
			TarjetaMonedero tarjeta=new TarjetaMonedero("Tarjeta2",450);
			String identificador= "34 5";
			String credencial = "Tarjeta2";
			VendingMachine prueba=new VendingMachine();
			prueba.setMaquina(6);
			prueba.compra(tarjeta, identificador, prueba.getMaquina(),credencial);
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void TestCompraNum2Mayor() {
			TarjetaMonedero tarjeta=new TarjetaMonedero("Tarjeta2",450);
			String identificador= "3 56";
			String credencial = "Tarjeta2";
			VendingMachine prueba=new VendingMachine();
			prueba.setMaquina(6);
			prueba.compra(tarjeta, identificador, prueba.getMaquina(),credencial);
		}
		
		
		@Test(expected=IllegalArgumentException.class)
		public void TestCompraNum2Extremo() {
			TarjetaMonedero tarjeta=new TarjetaMonedero("Tarjeta",450);
			String credencial = "Tarjeta";
			VendingMachine prueba=new VendingMachine();
			prueba.setMaquina(6);
			String identificador= "3 "+String.valueOf(prueba.getMaquina().length);
			prueba.compra(tarjeta, identificador, prueba.getMaquina(),credencial);
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void TestCompraNum1Extremo() {
			String credencial = "Tarjeta3";
			TarjetaMonedero tarjeta=new TarjetaMonedero(credencial,450);
			VendingMachine prueba=new VendingMachine();
			prueba.setMaquina(6);
			String identificador= String.valueOf(prueba.getMaquina().length)+" 3";
			prueba.compra(tarjeta, identificador, prueba.getMaquina(),credencial);
		}*/
		
		@Test(expected=NullPointerException.class)
		public void TestReabastecimiento() {
			VendingMachine prueba=new VendingMachine();
			prueba.setMaquina(6);
			Linea[] [] maquina=prueba.getMaquina();
			prueba.reabastecimiento(maquina);
		}
		
		
		
}
