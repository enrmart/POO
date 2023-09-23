package es.inf.uva.poo.practica1.clases;

import java.util.ArrayList;
import org.junit.Assert.*;
import es.inf.uva.poo.practica1.clases.VendingMachine;
/**
 * 
 *@author enrmart - Enrique Martin Calvo
 *@author fersanj - Fernando San Jose Dominguez
 *
 */
public class VendingSystem {
	
	private ArrayList<VendingMachine> maquinasTotales;
	private ArrayList<VendingMachine> maquinasLineaVacia;
	private int maquinasOperativas;

	/**
	 * constructor
	 */
	public VendingSystem() {
		this.maquinasTotales = null;
		this.maquinasLineaVacia=null;
		this.maquinasOperativas=0;
	}
	/**
	 * Constructor para crear una copia de VendingSystem
	 * @param v
	 */
	public VendingSystem(VendingSystem v) {
		this.maquinasTotales = v.maquinasTotales;
		this.maquinasLineaVacia = v.maquinasLineaVacia;
		this.maquinasOperativas = v.maquinasOperativas;
	}
	
	/**
	 * getMaquinasTotales obtengo las maquinas totales
	 * @return VendingMachines
	 */
	public ArrayList<VendingMachine> getMaquinasTotales() {
		return this.maquinasTotales;
	}
	
	/**
	 * getMaquinasVacias obtengo las maquinas con lineas vacias
	 * @return maquinasLineaVacia
	 */
	public ArrayList<VendingMachine> getMaquinasLineaVacia() {
		return this.maquinasLineaVacia;
	}
	
	/**
	 * getMaquinasOperativas obtengo el numero de maquinas operativas
	 * @return un entero de maquinas operativas
	 */
	public int getMaquinasOperativas() {
		return this.maquinasOperativas;
	}
	
	
	/**
	 * setMaquinasTotales establezco las maquinas totales
	 * @param maquinasTotales
	 */
	public void setMaquinasTotales(ArrayList<VendingMachine> maquinasTotales) {
		this.maquinasTotales = maquinasTotales;
	}
	
	/**
	 * setMaquinasLineaVacia establezco las maquinas con lineas vacias
	 * @param maquinasLineaVacia
	 */
	public void setMaquinasLineaVacia(ArrayList<VendingMachine> maquinasLineaVacia) {
		assert(maquinasLineaVacia!=null);
		this.maquinasLineaVacia = maquinasLineaVacia;
	}
	
	/**
	 * setMaquinasOperativas establezco las maquinas operativas
	 * @param maquinasOperativas
	 */
	public void setMaquinasOperativas(int maquinasOperativas) {
		this.maquinasOperativas = maquinasOperativas;
	}
	
	
	
	
	/**
	 * Obtengo las maquinas totales y las que tienen lineas vacias
	 * @param vendingmachine
	 * @return vacia
	 */
	public ArrayList<VendingMachine> lineaVacia(ArrayList<VendingMachine> vendingmachine){
		assert(vendingmachine!=null);
		ArrayList<VendingMachine> vacia = new ArrayList();
		setMaquinasOperativas(0);
		
		for(int i =0; i<vendingmachine.size();i++) {
			Linea[][]linea= vendingmachine.get(i).getMaquina();
				
			if(vendingmachine.get(i).getEstado()==true) {
				setMaquinasOperativas(+1);
			}
			for(int j = 0; j<linea.length;j++) {//veo si tienen o no lineas vacias
				for(int k = 0; k<linea.length;k++) {
					if(linea[j][k]==null) {
						vacia.add(vendingmachine.get(i));
					}
				}
			}
		}
		return vacia;
	}
	
	/**
	 * Aniado una nueva maquina a la lista de maquinas totales
	 * @param vendingmachine
	 * @return vendingmachine
	 * 
	 */
	public ArrayList<VendingMachine> aniadir(ArrayList<VendingMachine> vendingmachine){
		VendingMachine maquina = new VendingMachine();
		vendingmachine.add(maquina);
		return vendingmachine;
	}
	
	/**
	 * Elimino una maquina de la lista de maquinas totales
	 * @param identif
	 * @param vendingmachine
	 * @return vendingmachine
	 */
	public ArrayList<VendingMachine> eliminar(String identif, ArrayList<VendingMachine> vendingmachine){
		assert(vendingmachine!=null);
		
		for(int i =0; i<vendingmachine.size();i++) {
			if(vendingmachine.get(i).getIdentificador().equals(identif)){
				vendingmachine.remove(i);
			}
		}
		return vendingmachine;
	}
}