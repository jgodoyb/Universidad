package org.mp.sesion02;

/**
 * Clase empleada para poder crear matrices con objetos de tipo fracción
 * @author jgodoy
 *
 */
public class MatrizFraccion extends MatrizGenerica<Fraccion> {
	/**
	 *Metodo que nos permite sumar fracciones, el metodo ya lo hemos declarado en la clase "MatrizGenerica".
	 *@param o1 primero fracion a sumar.
	 *@param o2 segunda fraccion a sumar.
	 *@return llamando al metodo generico declarado en otra clase, se retorna la suma.
	 */
	protected Fraccion sumar(Fraccion o1, Fraccion o2) {
		return o1.sumar(o2);
	}
	/**
	 *Metodo que nos permite multiplicar fracciones, el metodo ya lo hemos declarado en la clase "MatrizGenerica"
	 *@param o1 primero fracion a multiplicar.
	 *@param o2 segunda fraccion a multiplicar.
	 *@return llamando al metodo generico declarado en otra clase, se retorna la multiplicacion.
	 */
	protected Fraccion multiplicar(Fraccion o1, Fraccion o2) {
		return o1.multiplicar(o2);
	}
	/**
	 *Metodo que nos permite detectar cuando la fraccion es nula.
	 *@return el constructor basico de la clase fraccion.
	 */
	protected Fraccion cero() {
		return new Fraccion();
	}
	
	

}
