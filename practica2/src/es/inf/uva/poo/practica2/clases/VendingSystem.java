package es.inf.uva.poo.practica2.clases;

import java.util.ArrayList;
import java.util.HashMap;
public class VendingSystem {

	//ver si esta ordenado de mayor a menor las sedes para ve las provincias
	
	private ArrayList<VendingCity> sedesTotales;
	
	
	
	/**
	 * constructor de un VendingSystem
	 * @param sedesTotales arraylist sedestotales
	 * @throws IllegalArgumentException ArrayList no puede ser null
	 */
	public VendingSystem(ArrayList<VendingCity> sedesTotales) {
		if(sedesTotales==null) {
			throw new IllegalArgumentException("ArrayList no puede ser null");
		}
		
		this.sedesTotales=sedesTotales;

	}
	
//gets
	/**
	 * getSedesTotales
	 * @return un ArrayList de todas las sedes
	 */
	public ArrayList<VendingCity> getSedesTotales() {
		ArrayList<VendingCity> city = this.sedesTotales;
		return city;
	}
	
	/**
	 * getNumSedes
	 * @return numero total de sedes
	 */
	public int getNumSedes() {
		return sedesTotales.size();
	}
	/**
	 * getNumProvincias
	 * @return numero total de provincias
	 */
	public int getNumProvincias() {
		return getProvinciasTotales().size();
	}
	
//sets
	/**
	 * setSedesTotales
	 * @param sedesTotales arraylist sedes totales
	 */
	public void setSedesTotales (ArrayList<VendingCity> sedesTotales) {
		this.sedesTotales = sedesTotales;
	}
	
	
//metodos
	
	/**
	 * Aniado una sede
	 * @param sede una sede
	 * @throws IllegalArgumentException sede no puede ser null
	 */
	public void addSede(VendingCity sede) {
		if(sede==null) {
			throw new IllegalArgumentException("sede no puede ser null");
		}
		if (!sedesTotales.contains(sede)) {
			sedesTotales.add(sede);
		}
	}
	/**
	 * Elimino una sede
	 * @param identificador identificador
	 * @throws IllegalArgumentException Identificador no puede ser menor a 0 o mayor de 53
	 */
	public void removeSede(int identificador) {
		if(identificador<0||identificador>53) {
			throw new IllegalArgumentException("Identificador no puede ser menor a 0 o mayor de 53");
		}
		for(int i =0;i<sedesTotales.size();i++) {
			if(sedesTotales.get(i).getCodigoProvincia()==identificador) {
				sedesTotales.remove(i);
			}
		}
	}
	
	/**
	 * obtengo el numero de maquinas de una sede en concreto
	 * @param codigoProvincia codigo provincia
	 * @return numero de maquinas de una sede
	 * @throws IllegalArgumentException codigoProvincia no puede ser menor a 0 o mayor de 53
	 */
	public int getNumMaquinasSede (int codigoProvincia) {
		if(codigoProvincia<0||codigoProvincia>53) {
			throw new IllegalArgumentException("Identificador no puede ser menor a 0 o mayor de 53");
		}
		String nomProvincia=" ";
		int codigo;
		
		for(String keyProvincia : getProvinciasTotales().keySet()) {
			codigo=getProvinciasTotales().get(keyProvincia);
			if(codigo==codigoProvincia) {
				nomProvincia = keyProvincia;
				break;
			}
		}
		return getMaquinasProvincia().get(nomProvincia);
	}
	/**
	 * obtengo las maquinas de una sede en concreto
	 * @param codigoProvincia codigo provincia
	 * @throws IllegalArgumentException codigoProvincia no puede ser menor a 0 o mayor de 53
	 * @return sedesTotales.get(codigo).getMaquinasTotales()
	 */
	public ArrayList<VendingMachine> getMaquinasSede(int codigoProvincia){
		if(codigoProvincia<0||codigoProvincia>53) {
			throw new IllegalArgumentException("Identificador no puede ser menor a 0 o mayor de 53");
		}
		
		int codigo=0;
		
		for(String keyProvincia : getProvinciasTotales().keySet()) {
			codigo=getProvinciasTotales().get(keyProvincia);
			if(codigo == codigoProvincia) {
				break;
			}
		}
		return sedesTotales.get(codigo).getMaquinasTotales();
	}
	
	
	
	/**
	 * Obtengo las maquinas de cada provincia
	 * @param maquinas hashmap
	 * @return maquinasProvincias
	 */
	public HashMap<String, Integer> getMaquinasProvincia(){
		int maquinas;
		String provincia;
		HashMap<String, Integer> maquinasProvincias = new HashMap<>();
		
		for(int i = 0;i<this.sedesTotales.size();i++) {
			maquinas= this.sedesTotales.get(i).getMaquinasTotales().size();
			provincia = this.sedesTotales.get(i).getProvincia();
			maquinasProvincias.put(provincia,maquinas);
		}
			
		return maquinasProvincias;
	}
	
	/**
	 * Obtengo las provincias totales
	 * @return provincias
	 */
	public HashMap<String, Integer> getProvinciasTotales() {
		
		String provin,provincia;
		int codigo,codigoProvincia;
		
		HashMap<String, Integer> provincias = new HashMap<>();
		for(int i = 0; i<this.sedesTotales.size();i++) {
			provincia= this.sedesTotales.get(i).getProvincia();
			codigoProvincia=this.sedesTotales.get(i).getCodigoProvincia();
			for(String key: provincias.keySet()) {	
				provin = key;
				codigo = provincias.get(provin);
				if(!provin.equals(provincia) && codigoProvincia != codigo) {
					provincias.put(provincia, codigoProvincia);
				}
			}
		}
		
		return provincias;
	}
}