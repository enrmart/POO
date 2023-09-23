package es.inf.uva.poo.practica1.clases;

import fabricante.externo.tarjetas.*;
import org.junit.Assert.*;
import es.inf.uva.poo.practica1.clases.Linea;

/**
 * 
 *@author enrmart - Enrique Martin Calvo
 *@author fersanj - Fernando San Jose Dominguez
 * 
 */
public class VendingMachine {
	private String identificador;
	private Boolean estado;
	private Linea [][] maquina;
	
	/**
	 * Constructor inicializador
	 */
	
	public VendingMachine() {
		this.identificador="";
		this.estado=false;
		this.maquina=null;
	}
	
	
	/**
	 * Constructor que genera una copia de VendingMachine. Ambas VendingMachine son iguales.
	 * 
	 * @param fuente VendingMachine
	 */
	
	public VendingMachine(VendingMachine fuente) {
		assert(fuente!=null);
		this.identificador=fuente.identificador;
		this.estado=fuente.estado;
		this.maquina=fuente.maquina;
	}
	
	/**
	 * Modifica el estado de la maquina 
	 * 
	 * @param valor de tipo Boolean 
	 */
	
	public void setEstado(Boolean valor) {
		assert(valor!=null);
		this.estado=valor;
	}
	
	/**
	 * Devuelve el estado de una maquina(True==Activa, False==Desactivada)
	 * 
	 * @return un Boolean que corresponde con el estado de la maquina
	 * 
	 */
	
	public Boolean getEstado() {
		return this.estado;
	}
	
	/**
	 * Modifica el estado del identificador de la VendingMachine
	 * 
	 * @param cad String que sdebe contener algo
	 */
	
	public void setIdentificador(String cad) {
		this.identificador=cad;
	}
	
	/**
	 * Devuelve el identificador de una maquina
	 * 
	 * @return un String que corresponde con el identificador de la maquina
	 * 
	 */
	
	public String getIdentificador() {
		return this.identificador;
	}
	
	/**
	 * Se le da tamanio a la maquina de tal manera que sea cuadratica 
	 * 
	 * @param tam Un int   
	 */
	
	public void setMaquina(int tam) {
		this.maquina=new Linea[tam][tam];
	}
	
	/**
	 * Devuelve la maquina
	 * 
	 * @return maquina un array de arrays de tipo Linea 
	 * 
	 */
	public Linea [][] getMaquina() {
		return this.maquina;
	}
	
	
	
	//Funcionalidades
	
//nos da error el sistema compra al hacer los test, nos da error en el credencial con el metodo que nos proporcionais
//lo hemos provado con Strings de numeros, letras, mezclado, con pocas y muchas cifras pero en todas nos salia error
	/**
	 * Implementa la funcionalidad de comprar
	 * 
	 * @param tarjeta de tipo TarjetaMonedero que debe estar creada
	 * @param identificador de tipo String que debe tener algo
	 * @param maquina es un array de arrays de Lineas 
	 * @param credencial de tipo String
	 * 
	 * @throws NullPointerException no puede llegar una tarjeta que no apunte hacia nada 
	 * @throws NullPointerException ya que no puede llegar un identificador vacio
	 * @throws NullPointerException no puede llegar una maquina que no apunte a nada
	 * @throws NullPointerException ya que no puede llegar una crendencial vacia
	 * 
	 * @throws IllegalArgumentException el identificador debe indicar una posicion que este en la maquina
	 * @throws IllegalArgumentException el saldo de la tarjeta debe ser superior de el precio del articulo deseado
	 * @throws IllegalArgumentException la cantidad restante del articulo deseado debe ser mayor que 0
	 */
	
	public void compra(TarjetaMonedero tarjeta,String identificador, Linea [][] maquina,String credencial) {
		if(tarjeta==null) {
			throw new NullPointerException("La tarjeta debe estar creada");
		}
		if(identificador==null) {
			throw new NullPointerException("El identificador debe contener algo");
		}
		if(maquina==null) {
			throw new NullPointerException("La maquina debe estar creada");
		}
		if(credencial==null) {
			throw new NullPointerException("La credencial tiene que contener algo");
		}
		String[] split = identificador.split("");
		int num1 = Integer.parseInt(split[0]);
		int num2 = Integer.parseInt(split[1]);
		if (num1>maquina.length || num2>maquina.length) {
			throw new IllegalArgumentException();
		}
		if(maquina[num1][num2].getCantidad()>0) {
			if(tarjeta.getSaldoActual()>=maquina[num1][num2].getProducto().getPrecio()) {
				maquina[num1][num2].setCantidad(maquina[num1][num2].getCantidad()-1);
				tarjeta.descontarDelSaldo(credencial,maquina[num1][num2].getProducto().getPrecio());	
			}else {throw new IllegalArgumentException("La tarjeta no tiene dinero suficiente");}
		}else{throw new IllegalArgumentException("Esa posicion de la maquina esta vacia");
		}
	}
		
	/**
	 * Una vez llamada se encarga de reponer la cantidad de todas las lineas vacias de la maquina a 5("valor maximo de cantidad de linea")
	 * 
	 *@param maquina2
	 */

	public void reabastecimiento(Linea[][] maquina2) {
		for(int i=0;i<maquina.length;i++) {
			for(int j=0;j<maquina[i].length;j++) {
				if(maquina[i][j].getCantidad()==0) {
					maquina[i][j].setCantidad(5);
				}
			}
		}
	}
	
	
}
