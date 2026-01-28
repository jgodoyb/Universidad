package practicas.practica02.parte01;

import java.util.Iterator;
import java.util.LinkedList;

public class Dispositivo implements Comparable<Dispositivo>, Iterable<PalabraFrecuencia>{
	private String modelo; //atributo clave
	protected LinkedList<PalabraFrecuencia> registroPalabras; 
		
	public Dispositivo(String modelo) {
		this.modelo = modelo == null || modelo.trim().isEmpty() ? "noName" : modelo.trim();
		this.registroPalabras = new LinkedList<>();
	}
	
	public Dispositivo(Dispositivo otro) {
		this.modelo = otro.modelo;
		this.registroPalabras = new LinkedList<>();
		for (PalabraFrecuencia pf : otro){
			this.registroPalabras.add(new PalabraFrecuencia(pf));
		}

	}
	
	public void clear() {
		this.registroPalabras.clear();
	}
	
	public void enviarMensaje(String mensaje) {
		
		for (String p : mensaje.split("[,. ]+")){
			int pos = this.registroPalabras.indexOf(new PalabraFrecuencia(p));
			if (pos == -1){
				this.registroPalabras.add(new PalabraFrecuencia(p));
			}else{
				this.registroPalabras.get(pos).incrementaFreq();
			}
		}


	}
	
	@Override
	public String toString() {
		this.registroPalabras.sort(null);
		return this.modelo+ " -> " + (this.registroPalabras.isEmpty() ? "[empty]" : this.registroPalabras); 
	}
	
	@Override
	public boolean equals(Object otro) {
		if (otro == null) return false;
		if (this == otro) return true;
		if (!(otro instanceof Dispositivo)) return false;
		return this.compareTo((Dispositivo)otro) == 0;
	}

	@Override
	public int compareTo(Dispositivo otro) {
		return this.modelo.compareTo(otro.modelo);
	}

	@Override
	public Iterator<PalabraFrecuencia> iterator() {
		return this.registroPalabras.iterator();
	}
}
