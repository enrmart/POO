package es.inf.uva.poo.practica2.clases;

import es.inf.uva.poo.practica2.clases.Linea;
import fabricante.externo.tarjetas.*;

/**
 * 
 * @author enrmart
 *
 */
public class VendingMachine {
	private String identificador;
	private boolean estado;
	private Linea [][] maquina;
	
	/**
	 * Constructor 
	 * 
	 * @param id El identificador de la VendingMachine
	 * @param est El estado de la maquina 
	 * @param maq La maquina donde se guardaran los productos
	 * 
	 * @throws IllegalArgumentException Si el identificador es null o esta vacio
	 * @throws IllegalArgumentException Si la matriz de lineas es null
	 * @throws IllegalArgumentException Si alguna de las posiciones de la matriz de lineas es null	
	 */
	public VendingMachine(String id,boolean est,Linea [][] maq) {
		if(id==null || id.isEmpty()) {
			throw new IllegalArgumentException("El identificador no debe ser null o estar vacio");
		}
		if(maq.equals(null)) {
			throw new IllegalArgumentException("La maquina no puede ser null");
		}
		if(!validamaq(maq)) {
			throw new IllegalArgumentException("La maquina no puede tener posiciones que sean null");
		}
		this.identificador=id;
		this.estado=est;
		this.maquina=maq;
	}
	
	
	private boolean validamaq(Linea[][] maq) {
		for(int i=0;i<maq.length;i++) {
			for(int j=0;j<maq.length;j++) {
				if(maq[i][j]==null) {
					return false;
				}
			}
		}
		return true;
	}


	/**
	 * Constructor que genera una copia de VendingMachine. Ambas VendingMachine son iguales.
	 * 
	 * @param fuente VendingMachine que se hace de cppia 
	 * @throws IllegalArgumentException Si la Vendingmachine que se quiere copar es null
	 */
	
	public VendingMachine(VendingMachine fuente) {
		if (fuente==null) {
			throw new IllegalArgumentException("La VendingMachine que se va a crear no puede ser null");
		}
		this.identificador=fuente.identificador;
		this.estado=fuente.estado;
		this.maquina=fuente.maquina;
	}
	
	
	/**
	 * getEstado
	 * 
	 * Devuelve el estado de una maquina(True==Activa, False==Desactivada)
	 * 
	 * @return un Boolean que corresponde con el estado de la maquina
	 */
	
	public boolean getEstado() {
		return this.estado;
	}
	
	
	/**
	 * getIdentificador
	 * 
	 * Devuelve el identificador de una maquina
	 * 
	 * @return un String que corresponde con el identificador de la maquina
	 */
	
	public String getIdentificador() {
		return this.identificador;
	}
	
	/**
	 * setMaquina
	 * 
	 * Se le da tamaño a la maquina de tal manera que sea cuadratica 
	 * 
	 * @param tam el entero que determina el tamaño de la maquina
	 * 
	 * @throws IllegalArgumentException La maquina tiene que tener un tamaño superior a 0
	 *  
	 */
	
	public void setMaquina(int tam) {
		if(tam<=0) {
			throw new IllegalArgumentException("La maquina debe tener un tamaño superior a 0");
		}
		this.maquina=new Linea[tam][tam];
	}
	
	/**
	 * getMaquina
	 * 
	 * Devuelve una copia de la maquina
	 * 
	 * @return maquina un array de arrays de tipo Linea 
	 * 
	 */
	public Linea [][] getMaquina() {
		Linea [][]maquinacop=this.maquina;
		return maquinacop;
	}
	
	
	
	//Funcionalidades
	
	/**
	 * compra
	 * 
	 * Implementa la funcionalidad de comprar
	 * 
	 * @param tarjeta de tipo TarjetaMonedero que debe estar creada
	 * @param identificador de tipo String que debe tener algo
	 * @param maquina es un array de arrays de Lineas 
	 * @param credencial de tipo String
	 * 
	 * @throws IllegalArgumentException no puede llegar una tarjeta que no apunte hacia nada 
	 * @throws IllegalArgumentException ya que no puede llegar un identificador vacio
	 * @throws IllegalArgumentException ya que no puede llegar una crendencial vacia
	 * @throws IllegalArgumentException el identificador debe indicar una posicion que este en la maquina
	 * @throws IllegalArgumentException el saldo de la tarjeta debe ser superior de el precio del articulo deseado
	 * @throws IllegalArgumentException la cantidad restante del articulo deseado debe ser >0
	 */
	
	public void compra(TarjetaMonedero tarjeta,String identificador,String credencial) {
		if(tarjeta==null) {
			throw new IllegalArgumentException("La tarjeta debe estar creada");
		}
		if(identificador==null|| identificador.isEmpty()) {
			throw new IllegalArgumentException("El identificador debe contener algo");
		}
		if(credencial==null||credencial.isEmpty()) {
			throw new IllegalArgumentException("La credencial tiene que contener algo");
		}
		String[] split = identificador.split(" ");
		int num1 = Integer.parseInt(split[0]);
		int num2 = Integer.parseInt(split[1]);
		if (num1>=maquina.length || num2>=maquina.length || num1<0 || num2<0) {
			throw new IllegalArgumentException("Las posiciones a las que se quiere acceder no estan en la maquina");
		}
		if(maquina[num1][num2].getCantidad()>0) {
			if(tarjeta.getSaldoActual()>=maquina[num1][num2].getVendible().getPrecio()) {
				maquina[num1][num2].setCantidad(maquina[num1][num2].getCantidad()-1);
				tarjeta.descontarDelSaldo(credencial,maquina[num1][num2].getVendible().getPrecio());	
			}else {
				throw new IllegalArgumentException("La tarjeta no tiene dinero suficiente");}
		}else{
			throw new IllegalArgumentException("Esa posicion de la maquina esta vacia");
		}
	}
		
	/**
	 * reabastecimiento
	 * 
	 * Una vez llamada se encarga de reponer la cantidad de todas las lineas vacias de la maquina a 5("valor maximo de cantidad de linea")
	 * 
	 * Tiene 2 modos uno reabastece una unica fila y el otro reabastece la maquina entera
	 * 
	 * @param num1 Un entero que indica la fila que se va a rellenar 
	 * @param num2 Un entero que indica la columna que se va a rellenar 
	 * @param modo Un entero que si es igual a 1 rellena la maquina entera y si es distinto la linea que se quiere rellenar segun num1 y num2
	 * 
	 * @throws IllegalArgumentException Si num1 y num 2 no estan en el rango 0 y longitud de maquina
	 */

	public void reabastecimiento( int num1, int num2,int modo) {
		if(modo!=1) {
			if(num1<0 || num2<0 || num1>= maquina.length || num2>=maquina.length) {
				throw new IllegalArgumentException("Los numeros de la linea para rellenar deben estar entre 0 y la longitud de la maquina");
			}
			this.maquina[num1][num2].setCantidad(5);
		}else {
			for(int i=0;i<this.maquina.length;i++) {
				for(int j=0;j<this.maquina[i].length;j++) {
					if(this.maquina[i][j].getCantidad()==0) {
						this.maquina[i][j].setCantidad(5);
					}
				}
			}
		}
	}
	
}
