package org.ip.sesion05;

public class MatricesBinarias {

	public static void main(String[] args) {
		int[][] a = { { 1, 3, 5, 7, 19 }, { 12, 8, 37, 50, 11 }, { 2, 4, 6, 8, 10 }, { 77, 12, 21, 31, 28 },
				{ 47, 2, 84, 87, 63 } };
		int[] f;
		int[][] b, d;
		int c;
		mostrarMatriz(a);
		if (esBinaria(a) == true) {
			System.out.println("La matriz es binaria");
		} else
			System.out.println("La matriz no es binaria");
		int fila = 2;
		f = MatricesBinarias.extraerFila(a, fila);
		mostrarArray(f);
		int columna = 3;
		f = extraerColumna(a, columna);
		mostrarArray(f);
		f = sumaFilas(a);
		mostrarArray(f);
		f = sumaColumnas(a);
		mostrarArray(f);
		System.out.println("Transformando la matriz de enteros en matriz binaria...");
		b = transformaBinaria(a);
		mostrarMatriz(b);
		esBinaria(b);
		if (esBinaria(b) == true) {
			System.out.println("La matriz es binaria");
		} else
			System.out.println("La matriz no es binaria");
		c = numeroDeUnos(b);
		System.out.println("El numero de 1s es: " + c);
		if (tieneNumeroParCeros(b) == true) {
			System.out.println("La matriz binaria tiene un numero par de ceros");
		} else
			System.out.println("La matriz binaria tiene un numero impar de ceros");
		fila = 3;
		f = extraerFila(b, fila);
		mostrarArray(f);
		columna = 2;
		f = extraerColumna(b, columna);
		mostrarArray(f);
		f = sumaFilas(b);
		mostrarArray(f);
		f = sumaColumnas(b);
		mostrarArray(f);
		d = obtenerLaterales(b);
		mostrarMatriz(d);

	}

	public static boolean esBinaria(int[][] matriz) {
		boolean binario = false;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j] == 0 || matriz[i][j] == 1) {
					binario = true;
				} else {
					binario = false;
					i = matriz.length;
					j = matriz.length;
				}
			}
		}
		return binario;

	}

	public static int[][] transformaBinaria(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = matriz[i][j] % 2;

			}
		}
		return matriz;

	}

	public static int numeroDeUnos(int[][] matriz) {
		int cont = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j] == 1) {
					cont++;
				}
			}
		}
		return cont;

	}

	public static boolean tieneNumeroParCeros(int[][] matriz) {
		int cont = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j] == 0) {
					cont++;
				}
			}
		}
		if (cont % 2 == 0) {
			return true;
		} else
			return false;

	}

	public static int[] sumaFilas(int[][] matriz) {
		int suma = 0;
		int a[] = new int[matriz.length];
		System.out.print("Suma de las filas => ");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				suma += matriz[i][j];
			}
			a[i] = suma;
			suma = 0;

		}
		return a;

	}

	public static int[] sumaColumnas(int[][] matriz) {
		int suma = 0;
		int b[] = new int[matriz.length];
		System.out.print("Suma de las columnas => ");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				suma += matriz[j][i];
			}
			b[i] = suma;
			suma = 0;
		}
		return b;

	}

	public static int[] extraerFila(int[][] matriz, int numFila) {
		System.out.print("Fila " + numFila + " => ");
		int[] array = new int[matriz.length];
		for (int j = 0; j < matriz.length; j++) {
			array[j] = matriz[numFila][j];
		}
		return array;
	}

	public static int[] extraerColumna(int[][] matriz, int numColumna) {
		System.out.print("Columna " + numColumna + " => ");
		int[] array = new int[matriz.length];
		for (int i = 0; i < matriz.length; i++) {
			array[i] = matriz[i][numColumna];
		}
		return array;
	}

	public static int[][] obtenerLaterales(int[][] matriz) {
		int[][] array = new int[4][matriz.length];
		for (int i = 0; i < matriz.length; i++) {
			array[0][i] = matriz[0][i];
		}
		for (int i = 0; i < matriz.length; i++) {
			array[1][i] = matriz[i][matriz.length - 1];

		}
		for (int i = 0; i < matriz.length; i++) {
			array[2][i] = matriz[matriz.length - 1][i];
		}
		for (int i = 0; i < matriz.length; i++) {
			array[3][i] = matriz[i][0];

		}
		return array;

	}

	public static void mostrarMatriz(int[][] matriz) {
		System.out.println("Matriz: ");
		System.out.print("[");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (j == matriz[0].length - 1) {
					System.out.print(matriz[i][j]);
				} else
					System.out.print(matriz[i][j] + "\t");
			}
			if (i < matriz.length - 1) {
				System.out.println();
			} else
				System.out.println("]");
		}

	}

	public static void mostrarArray(int[] array) {
		System.out.print("Array: [");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1) {
				System.out.print("\t");
			} else
				System.out.println("]");

		}

	}

}
