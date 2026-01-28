package practicas.practica03.parte03;

import java.util.*;
import java.util.Map.Entry;

import practicas.auxiliar.Par;

public class ColeccionNodos<T extends Comparable<T>> implements Iterable<Par<Nodo<T>, Nodo<T>>> {

	protected final HashMap<Nodo<T>, HashSet<Nodo<T>>> data;

	public ColeccionNodos() {
		this.data = new HashMap<>();
	}

	public void add(Nodo<T> nodoOrigen, Nodo<T> nodoDestino) {
		HashSet<Nodo<T>> aux = data.get(nodoOrigen);
		if (aux == null) {
			data.put(new Nodo<T>(nodoOrigen), aux = new HashSet<>());
		}
		aux.add(new Nodo<T>(nodoDestino));
	}

	public int size() {
		return this.data.size();
	}

	public void clear() {
		this.data.clear();
	}

	private TreeMap<Nodo<T>, TreeSet<Nodo<T>>> toOrderedCollection() {
		TreeMap<Nodo<T>, TreeSet<Nodo<T>>> result = new TreeMap<>();
		for (Entry<Nodo<T>, HashSet<Nodo<T>>> par : data.entrySet()) {
			result.put(par.getKey(), new TreeSet<>(par.getValue()));
		}
		return result;
	}

	@Override
	public String toString() {
		String result = "";
		for (Entry<Nodo<T>, TreeSet<Nodo<T>>> aux : toOrderedCollection().entrySet()) {
			result += aux.getKey() + "\n";
			for (Nodo<T> nodoAux : aux.getValue()) {
				result += "\t" + nodoAux + "\n";
			}
		}
		return result;
	}

	@Override
	public Iterator<Par<Nodo<T>, Nodo<T>>> iterator() {
		ArrayList<Par<Nodo<T>, Nodo<T>>> lista = new ArrayList<>();
		for (Entry<Nodo<T>, TreeSet<Nodo<T>>> aux : toOrderedCollection().entrySet()) {
			for (Nodo<T> nodoAux : aux.getValue()) {
				lista.add(new Par<>(aux.getKey(), nodoAux));
			}
		}
		return lista.iterator();

	}

}