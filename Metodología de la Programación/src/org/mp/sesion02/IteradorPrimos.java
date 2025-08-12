package org.mp.sesion02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteradorPrimos implements Iterator<Integer> {

	private int limite;
	private int actual;

	public IteradorPrimos(int limite) {
		this.limite = limite;
		this.actual = 2;
	}

	public int getLimite() {
		return limite;
		
	}

	public int getActual() {
		return actual;
	}

	@Override
//Nos indica si tiene siguiente
	public boolean hasNext() {

		return this.actual <= this.limite;
	}

	@Override
	public Integer next() {
		if (actual > limite)
			throw new NoSuchElementException("No se puede acceder a más números primos");
		int i = actual;
		do {
			actual++;
		} while (!esPrimo(actual));
		return new Integer(i);
	}

	public void remove() {
		throw new UnsupportedOperationException("Método no soportado");

	}

	public static boolean esPrimo(int numero) {
		if (numero == 2)
			return true;
		if (numero % 2 == 0)
			return false;
		for (int i = 3; i < numero; i += 2) {
			if (numero % i == 0)
				return false;
		}

		return true;

	}

	public String mostrarPrimos() {
		String s = "";
		int cont = 0;

		while (hasNext()) {
			s += "\t" + next();
			cont++;
			if (cont % 10 == 0) {
				s += "\n";
			}
		}
		return s;
	}

}
