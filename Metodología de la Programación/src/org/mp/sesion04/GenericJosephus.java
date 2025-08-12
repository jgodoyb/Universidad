 package org.mp.sesion04;

public class GenericJosephus<E> {
	private int k;
	private int n;
	private GenericQueue<E> cola;

	public GenericJosephus(int k, int n, E[] objects) {
		this.k = k;
		this.n = n;
		cola = new GenericQueue<E>();
		if (objects != null) {
			for (int i = 0; i < objects.length; i++) {
				cola.enqueue(objects[i]);
			}
		}
	}

	public GenericQueue<E> getCola() {
		return cola;

	}

	public String toString() {

		return "Problema de Josephus: k=" + k + ", n=" + n + "\n" + cola.toString();

	}

	public String ordenEliminar(GenericQueue<E> cola) {

		if (n == 0)
			throw new RuntimeException("No hay ninguna persona");
		else if (n == 1)
			return "Solo hay una persona";
		else {
			String salida = "Orden de eliminación: \n";
			while (cola.getSize() > 0) {
				for (int i = 1; i < k; i++) {
					E aux = cola.dequeue();
					cola.enqueue(aux);
				}
				salida += "Debe morir " + cola.dequeue() + "\n";
			}
			return salida;
		}

	}
}
