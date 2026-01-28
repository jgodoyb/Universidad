package practicas.practica02.parte02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import practicas.auxiliar.AVLTree;
import practicas.auxiliar.Format;
import practicas.auxiliar.Par;


public class Sujeto implements Comparable<Sujeto>, Iterable<Par<String,String>> {

	private String sujetoID; 
	private AVLTree<Par<String, ArrayList<Double>>> pruebaPuntuaciones; 
		
	public Sujeto(String sujetoID) {
		this.sujetoID = sujetoID;
		this.pruebaPuntuaciones = new AVLTree<>();
	}
	
	public void clear() {
	
		for(Par<String, ArrayList<Double>> par : pruebaPuntuaciones) {
			par.getValue().clear();
		}
		this.pruebaPuntuaciones.clear();
	}
	
	public boolean add(String pruebaID, Double...puntuaciones) {
		Par<String, ArrayList<Double>> pruebaCurrent = this.pruebaPuntuaciones.find(new Par<>(pruebaID, null));
		if(pruebaCurrent == null) {
			this.pruebaPuntuaciones.add(new Par<>(pruebaID, new ArrayList<>(List.of(puntuaciones))));
		} else {
			pruebaCurrent.getValue().addAll(List.of(puntuaciones));
		}
		return pruebaCurrent == null;
	}

	public double getMaximaPuntuacion() {
		double max = Double.MIN_VALUE;
		for(Par<String, ArrayList<Double>> par : pruebaPuntuaciones) {
			for(Double d : par.getValue()) {
				if(d == null) continue;
				if(d > max) {
					max = d;
				}
			}
		}
		return max;
	}
	
	public double getMaximaPuntuacion(String pruebaID) {
		double max = .0;
		Par<String, ArrayList<Double>> pruebaCurr = this.pruebaPuntuaciones.find(new Par<>(pruebaID, null));
		if(pruebaCurr == null) return -1;
		for(Double d : pruebaCurr.getValue()) {
			if(d == null) continue;
			if(d > max) {
				max = d;
			}
		}
		return max;
	}
	
	public int getNumPuntuaciones() {
		int cont = 0;
		for(Par<String, ArrayList<Double>> par :pruebaPuntuaciones) {
			cont += par.getValue().size();
		}
		return cont;
	}
	
	public int getNumPuntuaciones(String pruebaID) {
		Par<String, ArrayList<Double>> pruebaCurrent = this.pruebaPuntuaciones.find(new Par<>(pruebaID, null));
		return pruebaCurrent == null ? -1 : pruebaCurrent.getValue().size();
	}
	
	@Override
	public String toString() {
		return this.sujetoID + "=<" + this.pruebaPuntuaciones.size() + " prueba" + (this.pruebaPuntuaciones.size() != 1 ? "s>" : ">");
	}
	
	@Override
	public boolean equals(Object o) {
		return this.compareTo((Sujeto)o) == 0; 
	}
	
	@Override
	public int compareTo(Sujeto o) {
		return this.sujetoID.compareTo(o.sujetoID);
	}

	@Override
	public Iterator<Par<String, String>> iterator() {
		ArrayList<Par<String, String>> result = new ArrayList<>();
		for(Par<String, ArrayList<Double>> par : pruebaPuntuaciones) {
			double suma = .0;
			for(Double d : par.getValue()) {
				suma += d;
			}
			suma = par.getValue().size() == 0 ? 0 : suma / par.getValue().size();
			result.add(new Par<>(par.getKey(), Format.formatDouble(suma, 2)));

		}
		return result.iterator();
	}
}