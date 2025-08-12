package org.mp.sesion02;
/**
 * En estra clase crearemos metodos genericos que emplearan otras clases para poder trabajar con direntes tipos de datos, ya sean Integer o 
 * fraccion.
 * @author jgodoy
 *
 * @param <E>
 */
public abstract class MatrizGenerica<E extends Number> {
	
	
	protected abstract E sumar(E o1, E o2);
	protected abstract E multiplicar(E o1, E o2);
	protected abstract E cero();
	
	/**
	 * Metodo generico para sumar matrices
	 * @param matriz1 primera matriz a sumar
	 * @param matriz2 segunda matriz a sumar
	 * @return suma de ambas matrices
	 */
	public E [][] sumarMatrices(E[][] matriz1, E[][]matriz2){
		if(matriz1.length !=matriz2.length || matriz1[0].length != matriz2.length) {
			throw new RuntimeException ("Las matrices no tienen el mismo tamaño");
		}
		
		E[][] aux = (E[][]) new Number[matriz1.length][matriz1[0].length];
		for(int i =0; i< aux.length;i++) {
			for(int j=0; j<aux[0].length;j++) {
				aux[i][j]= sumar(matriz1[i][j],matriz2[i][j]);
			}
		}
		
		return aux;
		
	}
	/**
	 * Metodo generico para multiplicar matrices
	 * @param matriz1 primera matriz a multiplicar
	 * @param matriz2 segunda matriz a multiplicar
	 * @return multiplicacion de ambas matrices
	 */
	public E[][] multiplicarMatrices(E[][] matriz1, E[][] matriz2){
		if(matriz1[0].length !=matriz2.length) {
			throw new RuntimeException ("No coinciden las columnas de la primera matriz con las filas de la segunda");
		}
		E[][] aux = (E[][]) new Number[matriz1.length][matriz2[0].length];
		for(int i=0; i<matriz1.length;i++) {
			for(int j=0;j< matriz2[0].length;j++) {
					aux[i][j] = cero();
					for(int k=0; k<matriz1[0].length;k++) {
						aux[i][j]=sumar(aux[i][j],multiplicar(matriz1[i][k], matriz2[k][j]));
					}
					
				
			}
		}
		
		
		
		return aux;
	}
	

}
