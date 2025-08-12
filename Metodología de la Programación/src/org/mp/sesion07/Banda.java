package org.mp.sesion07;

/**
 * Clase que permite crear las bandas de una imagen 
 * @author mec162
 *
 * @param <T> matriz de un generico
 */
public class Banda<T extends Number> {

	private String nombreBanda;
	private T[][] datos;

	/**
	 * Constructor
	 * @param nombre variable de tipo String con el nombre de la banda
	 * @param x variable de tipo entero que pasamos a parametro
	 * @param y variable de tipo entero que pasamos a parametro
	 */
	public Banda(String nombre, int x, int y) {
		this.nombreBanda = nombre;
		this.datos = (T[][]) new Number[y][x];

	}

	/**
	 * Constructor 
	 * @param nombre variable de tipo String con el nombre de la banda
	 * @param datos matriz con los datos de la banda
	 */
	public Banda(String nombre, T[][] datos) {
		this.nombreBanda = nombre;

		this.datos = datos;
	}

	/**
	 * Getter
	 * @return devuelve el nombre de la banda
	 */
	public String getNombreBanda() {
		return this.nombreBanda;
	}

	/**
	 * Setter
	 * @param nombreBanda variable de tipo String con el nombre de la banda
	 */
	public void setNombreBanda(String nombreBanda) {

		this.nombreBanda = nombreBanda;
	}

	/**
	 * Getter
	 * @return devuelve los datos de la banda
	 */
	public T[][] getDatos() {
		return datos;
	}

	/**
	 * Setter
	 * @param datos matriz con los datos que queremos asignar al atributo datos
	 */
	public void setDatos(T[][] datos) {
		this.datos = datos;
	}

	/**
	 * Getter
	 * @param x variable de tipo entero que pasamos a parametro
	 * @param y variable de tipo entero que pasamos a parametro
	 * @return devuelve el elemento que se encuentra en la posicion (x,y) de la matriz
	 */
	public T getDatoXY(int x, int y) {

		return datos[x][y];

	}

	/**
	 * Setter
	 * @param dato elemento que asignamos a la matriz en la posicion (x,y)
	 * @param x variable de tipo entero que pasamos a parametro
	 * @param y variable de tipo entero que pasamos a parametro
	 */
	public void setDatoXY(T dato, int x, int y) {

		this.datos[x][y] = dato;

	}

	public String toString() {
		String salida = nombreBanda + ": \n";

		for (int i = 0; i < datos.length; i++) {

			for (int j = 0; j < datos[0].length; j++) {

				salida += datos[i][j] + " ";
			}
			salida += "\n";
		}
		return salida;

	}

}