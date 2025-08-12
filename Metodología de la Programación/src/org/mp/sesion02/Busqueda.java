package org.mp.sesion02;

public class Busqueda {

	public static <E extends Comparable<E>> int busquedaBinaria(E[] a, E valor) throws ExcepcionArrayVacio {

		if (a.length == 0) {
			throw new ExcepcionArrayVacio("Array vacío");
		}

		int inicio = 0;
		int fin = a.length - 1;
		int mitad;
		while (inicio <=fin) {
			mitad = (inicio + fin) / 2;
			if (a[mitad].compareTo(valor) == 0) {
				return mitad;
			} else if (valor.compareTo(a[mitad]) < 0) {
				fin = mitad - 1;
			}else {
				inicio =mitad +1;
			}

		}
		return -1;
	}

}
