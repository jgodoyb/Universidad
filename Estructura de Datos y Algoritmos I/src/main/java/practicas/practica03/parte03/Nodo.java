package practicas.practica03.parte03;

import java.util.ArrayList;

public class Nodo<T extends Comparable<T>> implements Comparable<Nodo<T>> {

	private ArrayList<T> componentes;

	@SafeVarargs
	public Nodo(T... componentes) {
		this.componentes = new ArrayList<>();
		for (T comp : componentes) {
			if (!(this.componentes.contains(comp))) {
				this.componentes.add(comp);
			}
		}
		this.componentes.sort(null);
	}

	public Nodo(Nodo<T> otro) {
		this.componentes = new ArrayList<>(otro.componentes);
	}

	@Override
	public int hashCode() {
		return componentes.hashCode();
	}

	@Override
	public boolean equals(Object otro) {
		if (otro == null)
			return false;
		if (this == otro)
			return true;
		if (!(otro instanceof Nodo<?>))
			return false;
		return this.componentes.equals(((Nodo<?>) otro).componentes);
	}

	@Override
	public int compareTo(Nodo<T> otro) {
		for (int i = 0; i < Math.min(this.componentes.size(), otro.componentes.size()); i++) {
			int comp = this.componentes.get(i).compareTo(otro.componentes.get(i));
			if (comp != 0)
				return comp;
		}
		return Integer.compare(this.componentes.size(), otro.componentes.size());
	}

	@Override
	public String toString() {
		return this.componentes.isEmpty() ? "[empty]" : this.componentes.toString();
	}

	public void clear() {
		this.componentes.clear();
	}
}