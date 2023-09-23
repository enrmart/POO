package es.inf.uva.poo.practica2.clases;
import java.util.ArrayList;

import es.inf.uva.poo.practica2.clases.VendingMachine;

public class VendingCity {
	
	private String provincia;
	private int codigoprovincia;
	private ArrayList<VendingMachine> maquinasTotales;


	 /**
	  * Constructor
	  * @param maquinas Un ArrayList de VendingMachine que representara a las maquinas totales
	  * @param codigopro Un int que representa a una provincia
	  * @param provincia Un String que corresponde al nombre de una provincia de España
	  * 
	  * @throws IllegalArgumentException Si la lista de VendingMachine es null
	  * @throws IllegalArgumentException Si no se recibe una provincia  
	  * @throws IllegalArgumentException Si el codigo es menor que 0 y superior al 53
	  */
	public VendingCity(ArrayList<VendingMachine> maquinas,int codigopro, String provincia) {
		if(maquinas==null) {
			throw new IllegalArgumentException("El ArrayList de maquinas debe ser distinto de null");
		}
		if(provincia==null || provincia.isEmpty()) {
			throw new IllegalArgumentException("El nombre de la provincia no debe ser null o estar vacio");
		}
		if(codigopro<0 || codigopro>53) {
			throw new IllegalArgumentException("El codigo de provincia debe ser mayor que 0 y menor que 53");
		}
		this.maquinasTotales = maquinas;
		this.codigoprovincia=codigopro;
		this.provincia=provincia;
	}
	
	/**
	 * Constructor para crear una copia de VendingCity
	 * @param v VendingCity 
	 */
	
	public VendingCity(VendingCity v) {
		if (v==null) {
			throw new IllegalArgumentException("La VendingCity que se va a copiar no pude ser null");
		}
		this.maquinasTotales = v.getMaquinasTotales();
		this.codigoprovincia=v.getCodigoProvincia();
		this.provincia=v.getProvincia();
	}
	
	
	/**
	 * getMaquinasTotales
	 * @return maquinas araylist de maquinas totales
	 */
	public ArrayList<VendingMachine> getMaquinasTotales() {
		ArrayList<VendingMachine> maquinas= new ArrayList(this.maquinasTotales);
		return maquinas;
	}
	
	/**
	 * getMaquinasVacias
	 * @return lineaVacia un ArrayList<VendingMachines> de maquinas con lineas vacias
	 */
	
	public ArrayList<VendingMachine> getMaquinasLineaVacia() {
		return lineaVacia();
	}
	
	/**
	 * getMaquinasOperativas
	 * @return un entero de maquinas operativas
	 */
	
	public int getMaquinasOperativas() {
		return Operativas();
	}
	
	/**
	 * getCodigoProvincia
	 * @return Un entero que representa a una provincia
	 */
	
	public int getCodigoProvincia() {
		return this.codigoprovincia;
	}
	/**
	 * getProvincia
	 * @return String que corresponde a una de las provincias de España 
	 */
	public String getProvincia() {
		return this.provincia;
	}
	
	/**
	 * setMaquinasTotales
	 * @param maquinasTotales arraylist maquinas
	 */
	public void setMaquinasTotales(ArrayList<VendingMachine> maquinasTotales) {
		this.maquinasTotales = maquinasTotales;
	}

	private int Operativas() {
		int oper=0;
		for(int i=0;i<this.maquinasTotales.size();i++) {
			if(this.maquinasTotales.get(i).getEstado()==true) {
				oper++;
			}
			
		}
		return oper;
	}
	
	
	private ArrayList<VendingMachine> lineaVacia(){
		ArrayList<VendingMachine> vacia = new ArrayList();
		
		for(int i =0; i<this.maquinasTotales.size();i++) {
			Linea[][]linea= this.maquinasTotales.get(i).getMaquina();
			for(int j = 0; j<linea.length;j++) {//veo si tienen o no lineas vacias
				for(int k = 0; k<linea.length;k++) {
					if(linea[j][k]==null) {
						vacia.add(this.maquinasTotales.get(i));
					}
				}
			}
		}
		return vacia;
	}
	
	/**
	 * Añade la maquina que recibe como parametro a la lista de maquinas Totales 
	 * 
	 * @param maquina  la VendingMachine que se quiere añadir a la lista
	 * 
	 * @throws NullPointerException Si la vendingMachine que se desea pasar es null
	 */
	public void addMaquina(VendingMachine maquina){
		if(maquina==null) {
			throw new NullPointerException("La VendingMachine no debe ser null");
		}
		this.maquinasTotales.add(maquina);
	}
	
	/**
	 * Elimino una maquina de la lista de maquinas totales
	 * 
	 * @param identif identificador
	 */
	public void eliminar(String identif){
		if(identif==null ||identif.isEmpty()) {
			throw new IllegalArgumentException("El identificador no debe ser null o estar vacio");
		}
		if(this.maquinasTotales==null||this.maquinasTotales.isEmpty()) {
			throw new IllegalArgumentException("La lista no debe ser null o estar vacia");
		}
		for(int i =0; i<this.maquinasTotales.size();i++) {
			if(this.maquinasTotales.get(i).getIdentificador().equals(identif)){
				this.maquinasTotales.remove(i);
			}
		}
	}
}