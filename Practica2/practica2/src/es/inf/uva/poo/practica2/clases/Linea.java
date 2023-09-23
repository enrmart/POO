package es.inf.uva.poo.practica2.clases;
import es.inf.uva.poo.practica2.clases.Vendible;
/**
 * 
 * @author enrmart
 *
 */
public class Linea {
		private String identificadorl;
		private Vendible vendible;
		private int cantidad;
		
		/**
		 * Constructor
		 * 
		 * @param id Un String que sera el identificador de la linea
		 * @param vend El tipo de Vendible que estara contenido en esa linea
		 * @param cant El numero de Vendibles que habra en la linea
		 * 
		 * @throws IllegalArgumentException Si id es null o esta vacio
		 * @throws IllegalArgumentException Si el Vendible es null 
		 * @throws IllegalArgumentException Si el numero es negativo o superior a  5  
		 */
		public Linea(String id,Vendible vend,int cant) {
			if(vend==null) {
				throw new IllegalArgumentException("El vendible no puede ser null");
			}
			this.getIdentificadorl();
			this.vendible=vend;
			this.setCantidad(cant);
		}
		
		/**
		 * Constructor de copia.
		 * 
		 * @param fuente La linea que se desea copiar
		 * 
		 * @throws IllegalArgumentException Si la linea que se desea copiar es null
		 */
		
		public Linea(Linea fuente) {
			if(fuente.equals(null)) {
				throw new IllegalArgumentException("La linea a copiar no puede ser null");
			}
			this.identificadorl=fuente.getIdentificadorl();
			this.vendible=fuente.getVendible();
			this.cantidad=fuente.getCantidad();
		}
		
		/**
		 * setCantidad
		 * 
		 * Establecera el numero de Vendibles que hay en la linea
		 * 
		 * @param cant El numero de Vendibles que habra en la linea
		 * 
		 * @throws IllegalArgumentException Si el numero es negativo o superior a  5  
		 */
		public void setCantidad(int cant) {
			if(cant<0 || cant>5) {
				throw new IllegalArgumentException("La cantidad debe estar entre 0 y 5");
			}
			this.cantidad=cant;
		}
		
		/**
		 * getIdentificadorl
		 * 
		 * @return el identificador de la linea
		 */
		
		public String getIdentificadorl() {
			return this.identificadorl;
		}
		

		/**
		 * set Identificador
		 *  
		 * @param linea el String que identificara cada una de las lineas
		 * 
		 * @throw IllegalArgumentException La linea no puede estar vacia o ser null
		 */
		
		public void setIdentificadorl(String linea) {
			if (linea==null || linea.isEmpty()) {
				throw new IllegalArgumentException("La linea no puede estar vacia o ser null");
			}
		}
		
		/**getVendible
		 * 
		 * @return El Vendible que esta en la linea
		 */
		
		public Vendible getVendible() {
			return this.vendible;
		}
		
		/**getCantidad
		 * 
		 * @return cantidad restante de producto 
		 */
		
		public int getCantidad() {
			return this.cantidad;
		}
		
}
