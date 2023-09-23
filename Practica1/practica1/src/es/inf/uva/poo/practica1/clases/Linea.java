package es.inf.uva.poo.practica1.clases;

import org.junit.Assert.*;

/**
 * 
 * @author enrmart - Enrique Martin Calvo
 * @author fersanj - Fernando San Jose Dominguez
 *
 */
public class Linea {
		private String identificadorl;
		private Producto producto;
		private int cantidad;
		
		/**
		 * Constructor de inicializacion
		 */
		public Linea() {
			this.identificadorl=null;
			this.producto=null;
			this.cantidad=0;
		}
		
		/**
		 * Constructor de copia.
		 * 
		 * @param fuente
		 */
		
		public Linea(Linea fuente) {
			this.identificadorl=fuente.getIdentificadorl();
			this.producto=fuente.getProducto();
			this.cantidad=fuente.getCantidad();
		}
		
		
		/**
		 * Establezco el identificador
		 * @param cad String 
		 */
		
		public void setIdentificadorl(String cad) {
			this.identificadorl=cad;
		}
		
		/**
		 * Establezco el produto
		 * @param p
		 */
		
		public void setProducto(Producto p) {
			this.producto=p;
		}
		
		/**
		 * Establezco la cantidad
		 * @param b un entero
		 * @throws IllegalArgumentException porque la cantidad maxima que puede almacenar una linea es 5
		 *  @throws IllegalArgumentException porque la cantidad minima es 0
		 */
		
		public void setCantidad(int b) {
			if(b>5) {
				throw new IllegalArgumentException("El numero maximo de productos por linea solo puede ser 5");
			}
			if(b<0) {
				throw new IllegalArgumentException("No puede haber una cantidad negativa de productos");
			}
			this.cantidad=b;
		}
		
		/**
		 * @return el identificador de la linea
		 */
		
		public String getIdentificadorl() {
			return this.identificadorl;
		}
		
		/**
		 * @return tipo de producto que esta en la linea
		 */
		
		public Producto getProducto() {
			return this.producto;
		}
		
		/**
		 * @return cantidad restante de producto 
		 */
		
		public int getCantidad() {
			return this.cantidad;
		}
		
}
