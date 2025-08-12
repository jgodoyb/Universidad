package org.mp.sesion02;
/**
 * Clase empleada para poder crear matrices con objetos de tipo integer
 * @author jgodoy
 *
 */
public class MatrizInteger extends MatrizGenerica<Integer>{
	
	/**
	 *Metodo que nos permite sumar datos tipo Integer, el metodo ya lo hemos declarado en la clase "MatrizGenerica".
	 *@param o1 primero dato a sumar.
	 *@param o2 segunda dato a sumar.
	 *@return llamando al metodo generico declarado en otra clase, se retorna la suma.
	 */
	protected Integer sumar(Integer o1, Integer o2) {
		return  o1+ o2;
	}
	/**
	 *Metodo que nos permite multiplicar datos tipo Integer, el metodo ya lo hemos declarado en la clase "MatrizGenerica".
	 *@param o1 primero dato a multiplicar.
	 *@param o2 segunda dato a multiplicar.
	 *@return llamando al metodo generico declarado en otra clase, se retorna la multiplicacion.
	 */
	protected Integer multiplicar(Integer o1, Integer o2) {
		return  o1* o2;
	}
	/**
	 * Metodo que detecta cuando un dato Integer es nulo.
	 * @return como es un valor nulo retorna 0.
	 */
	protected Integer cero() {
		return  0;
	}
	
	
	

}
