package es.inf.uva.poo.practica2.clases;

import java.util.ArrayList;

public class Pack extends Vendible{
	 private ArrayList<Producto> pack;
	 //comprobar si al detecra un producto repetedido, hacerlo sobre su identificador tmb
	
	 /**
	  * constructor de Pack
	  * @param productos arraylist de productos
	  */
	 public Pack(ArrayList<Producto> productos) {
		 if(productos== null) {
			 throw new IllegalArgumentException("No puede ser null");
		 }
		 if(productos.size() <2) {
			 throw new IllegalArgumentException("no puede haber menos de dos productos");
		 }
		 for(int i =0; i<productos.size(); i++) {
			if(productos.contains(productos.get(i).getNombre())){
				throw new IllegalArgumentException("no puede haber productos de nombres repetidos");
			}
		 }
		 this.pack = productos;
		 double precioPack = calcPrecio();
		 setPrecio(precioPack);
	 }
	 
	 
	@Override
	public void setIdentificador(String nombre) {
		super.Identificador=nombre;
		
	}

	@Override
	public String getIdentificador() {
		
		return super.Identificador;
	}
	
	/**
	 * obtengo el numero de productos del pack
	 * @return this.pack.length 
	 */
	public int getProductosTotales() {
		return this.pack.size();
		
	}
	/**
	 * calculo el precio pack
	 * @return precio total del pack
	 */
	private double calcPrecio() {
		double precio=0;
		for(int i = 0;i<pack.size(); i++) {
			precio = precio + pack.get(i).getPrecio();
		}
		precio = precio*0.8;
		return precio;
	}
	/**
	 * obtengo ArrayList de los nombres de los productos del pack
	 * @return nombreProductos 
	 * @throws IllegalArgumentException Producto no puede ser null o estar vacio
	 */
	public ArrayList<String> productosConcretos(){
		ArrayList<String>nombreProductos = new ArrayList<>();
		for(int i = 0; i<getProductosTotales();i++) {
			if((this.pack.get(i).getNombre()==null)||this.pack.get(i).getNombre().isEmpty()) {
				throw new IllegalArgumentException("Producto no puede ser null o estar vacio");
			}
			nombreProductos.add(this.pack.get(i).getNombre());
		}
		return nombreProductos;
	}
	/**
	 * comprobar que contiene el pack un producto dado
	 * @param producto un producto
	 * @return check si esta o no el producto en le pack
	 * @throws IllegalArgumentException Producto no puede ser null
	 */
	public boolean formarParte(Producto producto) {
		if(producto==null) {
			throw new IllegalArgumentException("Producto no puede ser null");
		}
		
		boolean check= false;
			if(this.pack.contains(producto.getNombre())) {
				check = true;
		}
		return check;
	}
	/**
	 * aniado un producto al pack
	 * @param producto un producto
	 * @throws IllegalArgumentException Producto no puede ser null
	 * @throws IllegalArgumentException no puede haber productos de nombres repetidos
	 */
	public void addProducto(Producto producto) {
		if(producto==null) {
			throw new IllegalArgumentException("Producto no puede ser null");
		}
		
		 if(this.pack.contains(producto.getNombre())){
				throw new IllegalArgumentException("no puede haber productos de nombres repetidos");
			 }
			pack.add(producto);
	}
	/**
	 * Elimino un producto del pack
	 * @param nombre un nombre
	 * @throws IllegalArgumentException Tamaño minimo del pack, no se puede eliminar productos
	 * @throws IllegalArgumentException Producto no puede ser null o vacio
	 */
	public void removeProducto(String nombre) {
		if(this.pack.size()==2) {
			throw new IllegalArgumentException("Tamaño minimo del pack, no se puede eliminar productos");
		}
		if(nombre.equals(null) || nombre.isEmpty()) {
			throw new IllegalArgumentException("Producto no puede ser null o vacio");
		}	
		for(int i = 0;i<getProductosTotales();i++) {
			if(this.pack.get(i).getNombre() == nombre) {
				this.pack.remove(i);
				break;
			}
		}
		
	}
}
