package org.mp.sesion01;

/**
 * Clase que permite utilizar fracciones e implementa la interface Comparable. 
 * @author jgodoy.
 *@version 1.0
 */
public class Fraccion {
	
	private int numerador;
	private int denominador;
	private static int numFracciones=0;
	
	/**
	 * Constructor por defecto.
	 * 
	 */
	public Fraccion() {
		numerador=0;
		denominador=1;
		numFracciones++;
	}
	/**
	 * Cosntructror que empleara dos valores de entrada, un denominador y un numerador.
	 * @param numerador numerador de la fraccion.
	 * @param denominador denominador de la fraccion.
	 */
	public Fraccion(int numerador,int denominador) {
		this.numerador=numerador;
		this.denominador=denominador;
		numFracciones++;
	}
	
	/**
	 * Constructor copia 
	 * @param fraccion objecto que sera copiado
	 */
	public Fraccion(Fraccion fraccion) {
		this.numerador=fraccion.numerador;
		this.denominador=fraccion.denominador;
		numFracciones++;
	}

	
	/**
	 * Metodo que empleamos para saber si dos objetos son iguales o no.
	 *@return retorna un valor boolean, si los objetos son iguales retornara un "true" y un "false" si son falsos.
	 *@param obj objeto el cual queremos comparar
	 */
	public boolean equals (Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if ( ! (obj instanceof Fraccion))
			return false;
		
		Fraccion otro = (Fraccion)obj;
		
		if (this.numerador == otro.numerador && this.denominador == otro.denominador)
			return true;
		else 
			return false;
		
	}
	/**
	 * Metodo que emplearemos para obtener el numerador de la fraccion.
	 * @return retorna el valor del numerador de la fraccion.
	 */
	public int getNumerador() {
		return numerador;
	}
	/**
	 * Metodo que meplearemos para obtener el denominador de la fraccion.
	 * @return retorna el valor del denominador de la fraccion.
	 */
	public int getDenominador() {
		return denominador;
	}
	
	/**
	 * Metodo estatico que nos inidicara el numero de fracciones que han sido generadas
	 * @return numero de fracciones con las que hemos trabajado
	 */
	public static int getNumFracciones() {
		return numFracciones;
		
	}
	
	/**
	 * Metodo que empleamos para escribir por pantalla la fraccion
	 * @return la nomenclatura de la fraccion
	 */
	public String toString () {
		String fraccion;
		if(denominador !=1) {
			fraccion=numerador+"/"+denominador;
		}
		else 
			fraccion=numerador+"";
		
		return fraccion;
	}
		
	/**
	 * Metodo que sumara el parametro b con el objeto asociado al metodo.
	 * @param b parametro que se suma al objecto.
	 * @return devuelve una nueva fraccion la suma del objecto y el parametro b.
	 */
	public Fraccion sumar(Fraccion b) {
		int num=this.numerador*b.denominador+this.denominador*b.numerador;
		int den=this.denominador*b.denominador;
		Fraccion suma=new Fraccion(num,den);
		return suma;
		
	}
	
	/**
	 * Metodo estatico que suma las fracciones a y b
	 *
	 * @param a primera fraccion a sumar.
	 * @param b segunda fraccion a sumar.
	 * @return una fraccion creada tras la suma de a y b.
	 */
	public static Fraccion suma(Fraccion a,Fraccion b) {
		int num=a.numerador*b.denominador+a.denominador*b.numerador;
		int den=a.denominador*b.denominador;
		Fraccion suma=new Fraccion(num,den);
		return suma;	
	}
	
	/**
	 * Metodo que empleamos para restar fracciones
	 *
	 * @param b fraccion qeu restara a la otra fraccion
	 * @return resultado de restar una fraccion y otra.
	 */
	public Fraccion restar(Fraccion b) {
		int num=this.numerador*b.denominador-this.denominador*b.numerador;
		int den=this.denominador*b.denominador;
		Fraccion resta=new Fraccion(num,den);
		return resta;
		
	}
	
	/**
	 * Metodo que empleamos para multiplicar fracciones
	 *
	 * @param b fraccion que multiplicaremos
	 * @return resultado de multiplicar una fraccion con otra
	 */
	public Fraccion multiplicar(Fraccion b) {
		int num=this.numerador*b.numerador;
		int den=this.denominador*b.denominador;
		Fraccion multiplicar=new Fraccion(num,den);
		return multiplicar;
		
	}
	
	/**
	 * Metodo que se emplea para dividir dos fracciones
	 *
	 * @param b Fraccion que emplearemos de divisor
	 * @return El resultado de la division entre dos fracciones
	 */
	public Fraccion dividir(Fraccion b) {
		int num=this.numerador*b.denominador;
		int den=this.denominador*b.numerador;
		Fraccion dividir=new Fraccion(num,den);
		return dividir;
		
	}
	
	/**
	 * Metodo empleado para hacer maximo comun divisor entre dos numeros.
	 *
	 * @param u primer numero que utilizaremos apra hacer mcd.
	 * @param v segundo numero que utilizaremos apra hacer mcd. 
	 * @return retorna el número más grande por el que se pueden dividir dichos números.
	 */
	private static int mcd (int u, int v) {
		if (u % v == 0)
			return v;
		else 
			return mcd (v, u%v);
	}
	
	/**
	 * Metodo que se emplea para simplificar una fraccion.
	 *
	 * @return la fraccion simplicada al maximo.
	 */
	public Fraccion simplificar() {
		int a=mcd(Math.abs(numerador),Math.abs(denominador));
		int num=numerador/a;
		int den=denominador/a;
		Fraccion nueva=new Fraccion(num,den);
		return nueva;
	
	}
	
	
	

}


