package practicas.practica01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import practicas.practica01.Configuracion.TIPO_BARAJA;

public class Baraja implements Iterable<Carta> {
	private TIPO_BARAJA tipo;
	protected ArrayList<Carta> cartas = new ArrayList<>();

	public Baraja(String tipo) {
		try {
			this.tipo = TIPO_BARAJA.valueOf(tipo);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException("Tipo no válido");
		}

		for (String valor : this.tipo.getValores()) {
			for (String palo : this.tipo.getPalos()) {
				this.cartas.add(new Carta(tipo, valor, palo));
			}
		}
	}

	public int size() {
		return this.cartas.size();
	}

	public void clear() {
		this.cartas.clear();
	}

	public Carta getCarta(int pos) {
		return pos < 0 || pos >= this.cartas.size() ? null : this.cartas.get(pos);
	}

	@Override
	public String toString() {
		return this.cartas.toString();
	}

	public void ordenar() {
		Collections.sort(this.cartas);
	}

	public void barajar() {
		Collections.shuffle(cartas);
	}

	public boolean cortarBaraja(int puntoCorte) {
		if (puntoCorte <= 0 || puntoCorte >= this.cartas.size())
			return false;
		ArrayList<Carta> aux = new ArrayList<Carta>();
		for (int i = 0; i < cartas.size(); i++) {
			aux.add(this.cartas.get((i + puntoCorte) % size()));
		}
		this.cartas.clear(); 	
		this.cartas = aux;		
		return true;
	}

	@Override
	public Iterator<Carta> iterator() {
		
		return this.cartas.iterator();
	}
}
