package practicas.practica01;

import java.util.Iterator;
import java.util.LinkedList;

public class Jugador implements Iterable<Carta> {
	private String id;
	private LinkedList<Carta> mano = new LinkedList<>();
	private boolean ocupado;
	
	public Jugador(String id) {
		//Recuerda el uso del método trim()
		//2 líneas
		//...
		this.id = id.trim();	//Quita espacios en principio y final
		this.ocupado = false;
	} 
	
	public boolean getOcupado() {
		return this.ocupado;
	}  
	
	public void setOcupado(boolean jugando) {
		this.ocupado = jugando;
	}
	
	public String getId() {
		return this.id;
	}
	
	public int size() {
		return this.mano.size();
	}
	
	public void clear() {
		this.mano.clear();
	}
	
	public boolean cogerCarta(Carta carta) {
		if (carta.getRepartida() || this.mano.contains(carta)) return false;
		carta.setRepartida(true);
		return this.mano.add(carta);
	}
	
	public boolean devolverCarta(Carta carta) {
		if (!carta.getRepartida() || !this.mano.contains(carta)) return false;
		carta.setRepartida(false);
		return this.mano.remove(carta);
	}
	
	@Override
	public String toString() {
		return id + " -> " + this.mano;
	}

	@Override
	public Iterator<Carta> iterator() {
		return this.mano.iterator();
	}
}