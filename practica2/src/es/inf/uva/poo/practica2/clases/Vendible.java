package es.inf.uva.poo.practica2.clases;

public abstract class Vendible {
	
	protected double precio;
	protected String nombre;
	protected String Identificador;
	/**
	 * SetPrecio
	 * @param p precio
	 */
	public void setPrecio(double p) {
		if(p<0) {
			throw new IllegalArgumentException("El precio no puede ser negativo");
		}
		this.precio=p;
	}
	/**
	 * SetNombre
	 * @param nombre un nombre
	 */
	public void setNombre(String nombre) {
		if(nombre==null || nombre.isEmpty()){
			throw new IllegalArgumentException("El nombre no puede ser ni null ni estar vacio");
		}
		this.nombre=nombre;
	}
	/**
	 * setIdentificador
	 * @param nombre un nombre
	 */
	public abstract void setIdentificador(String nombre);
	
	/**
	 * getPrecio
	 * @return precio
	 */
	public double getPrecio() {
		return this.precio;
	}
	/**
	 * getNombre
	 * @return nombre
	 */
	public String getNombre() {
		return this.nombre;
	}
	/**
	 *  getIdentificador
	 * @return abstracto
	 */
	public abstract  String getIdentificador();
	
}
