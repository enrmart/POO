package es.inf.uva.poo.practica1.clases;
import java.text.NumberFormat;
import java.util.Date;
import org.junit.Assert.*;

/**
 * 
 * @author enrmart - Enrique Martin Calvo
 * @author fersanj - Fernando San Jose Dominguez
 *
 */
public class Producto {
	private double precio;
	private Date fechaCad;
	private String nombre;
	private int[] upc;
	
	/**
	 * Constructor
	 */
	public Producto() {
		this.precio = 0;
		this.fechaCad = null;
		this.nombre = "";
		this.upc = null;
	}
	
	/**
	 * Constructor para crear una copia de un prodcto
	 * @param b
	 * @throws IllegalArgumentException no puede no contener nada
	 */
	public Producto(Producto b) {
		if(b==null) {
			throw new IllegalArgumentException("Producto no contiene nada");
		}
		this.precio = b.getPrecio();
		this.fechaCad =b.getFechaCad();
		this.nombre =b.getNombre();
		this.upc =b.getUpc();
	}
	
	/**
	 * getPrecio obtengo el precio
	 * @return el precio del producto
	 */
	public double getPrecio() {
		return this.precio;
	}
	
	/**
	 * getFechaCad obtengo la fecha caducidad
	 * @return la fecha de caducidad
	 */
	public Date getFechaCad() {
		return this.fechaCad;
	}
	
	/**
	 * getNombre Obtengo el nombre del producto
	 * @return el nombre del producto
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * getUpc obtengo el upc del producto
	 * @return el upc del producto
	 */
	public int[] getUpc() {
		return this.upc;
	}
	
	/**
	 * setPrecio establezco el precio del produto
	 * @param precio
	 * @throws IllegalArgumentException el precio no puede ser negativo
	 */
	public void setPrecio(double precio) {
		if(precio<0) {
			throw new IllegalArgumentException("EL precio no puede ser negativo");
		}else {
		this.precio = precio;
	}
}
	/**
	 * setFechaCad establezco la fecha de caducidad del producto
	 * @param fechaCad
	 * assert.pre(fechaCad!=null)
	 * AssertionError con monitorizacion de asertos en ejecucion
	 */
	public void setFechaCad(Date fechaCad) {
		assert (fechaCad!=null);
		this.fechaCad = fechaCad;
	}
	
	/**
	 * setNombre establezco el nombre del producto
	 * @param nombre
	 * AssertionError con monitorizacion de asertos en ejecucion
	 */
	public void setNombre(String nombre) {
		assert (nombre!=null);
		this.nombre = nombre;
	}
	
	/**
	 * SetUpc establezco el upc del producto
	 * @param identif
	 * AssertionError con monitorizacion de asertos en ejecucion
	 * AssertionError con monitorizacion de asertos en ejecucion
	 */
	public void setUpc(String identif) {
		assert(identif.length()==11);
		assert(identif!=null);
		this.upc = calcUpc(identif);
	}
	
//calculo el upc	
	private int[] calcUpc(String identif) {
		
		int [] upc1= new int[12];
		
		boolean comprobar=false;
		int s=0; 		// suma s
		int m=0;		//aproximcion de s 
		int d=0;		//resta de s y m
		int num;		//numero a leer
		char caracter;	//caracter a pasar a int
		String elemento;
		
		for(int i = 1; i<12;i++) {
				
					if((i%2) != 0) {
						caracter = identif.charAt(i-1);				//coger el caracter 
						elemento = Character.toString(caracter);	//pasar el caracter a string
						num = Integer.parseInt(elemento);			//pasar el string a int
						s = s + (num*3);							//calcular ese int
						upc1[i-1]= num;
					}
					else {
						caracter = identif.charAt(i-1);				//coger el caracter 
						elemento = Character.toString(caracter);	//pasar el caracter a string
						num = Integer.parseInt(elemento);			//pasar el string a int
						s = s + (num*1);							//calcular ese int
						upc1[i-1]= num;
					}
			}
		m=Math.round(s/10)*10;
		d=s-m;
		upc1[11] = d;
		return upc1;
	}
}
