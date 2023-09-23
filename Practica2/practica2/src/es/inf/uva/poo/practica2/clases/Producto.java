package es.inf.uva.poo.practica2.clases;
import java.util.Date;

import es.inf.uva.poo.practica2.clases.Vendible;

public class Producto extends Vendible {
	
	private Date fechaCad;
	private int [] upc;
	
	/**
	 * Constructor
	 * 
	 * @param fechacad Un Date que debe indicar la fecha de caducidad
	 * @param Upc Un Array de enteros que sera el identificador del producto
	 * 
	 * @throws IllegalArgumentException Si la fecha de caducidad es null
	 * @throws IllegalArgumentException Si el Upc es null
	 */
	public Producto(Date fechacad, int [] Upc) {
		if(fechacad==null) {
			throw new IllegalArgumentException("La fecha no puede ser null");
		}
		if(Upc==null) {
			throw new IllegalArgumentException("El UPC no puede ser null");
		}
		this.fechaCad =fechacad;
		this.upc=Upc;
	}
	
	/**
	 * Constructor para crear una copia de un prodcto
	 * @param product tipo producto del cual se hara una copia 
	 * @throws IllegalArgumentException Si el producto que se va a copiar es null
	 */
	public Producto(Producto product) {
		if(product==null) {
			throw new IllegalArgumentException("Producto no contiene nada");
		}
		this.fechaCad =product.getFechaCad();
		this.upc =product.getUpc();
	}
	
	
	/**
	 * getFechaCad
	 * @return la fecha de caducidad
	 */
	public Date getFechaCad() {
		return this.fechaCad;
	}
	
	
	private int [] getUpc() {
		return this.upc;
	}
	
	/**
	 * SetIdentificador
	 * @param identif es el identificador de ese producto
	 * @throws IllegalArgumentException Si el identificador de producto es null o esta vacio
	 * @throws IllegalArgumentException Si la longitud de identificador es distinto de 12
	 */
	@Override
	public void setIdentificador(String identif) {
		if(identif==null||identif.isEmpty()) {
			throw new IllegalArgumentException("El identificador de producto no puede ser null o estar vacio");
		}
		if(identif.length()!=12) {
			throw new IllegalArgumentException("La longitud del identificador debe ser 12");
		}
		
		this.upc = calcUpc(identif);
	}
	/**
	 * getIdentificador
	 * @return upc en forma de cadena 
	 */
	@Override
	public String getIdentificador() {
		return this.upc.toString();
	}
	
	
//calculo el upc	
	private int[] calcUpc(String identif) {
		int [] upc1= new int[12];
		
		int s=0; 		// suma s
		int m=0;		//aproximcion de s 
		int d=0;		//resta de s y m
		int num;		//numero a leer
		char caracter;	//caracter a pasar a int
		String elemento;
		caracter = identif.charAt(11);				//coger el caracter 
		elemento = Character.toString(caracter);	//pasar el caracter a string
		int z= Integer.parseInt(elemento);		
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
		if(z!=d) {
			throw new IllegalArgumentException("El ultimo digito del upc no es correcto");
		}
		return upc1;
	}

	
	
}
