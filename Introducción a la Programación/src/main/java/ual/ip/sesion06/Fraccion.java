package org.ip.sesion06;

public class Fraccion {
	
	private int numerador;
	private int denominador;
	private static int numFracciones=0;
	
	public Fraccion() {
		numerador=0;
		denominador=1;
		numFracciones++;
	}
	
	public Fraccion(int numerador,int denominador) {
		this.numerador=numerador;
		this.denominador=denominador;
		numFracciones++;
	}
	
	public Fraccion(Fraccion fraccion) {
		this.numerador=fraccion.numerador;
		this.denominador=fraccion.denominador;
		numFracciones++;
	}

	
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
	public int getNumerador() {
		return numerador;
	}
	public int getDenominador() {
		return denominador;
	}
	public static int getNumFracciones() {
		return numFracciones;
		
	}
	public String toString () {
		String fraccion;
		if(denominador !=1) {
			fraccion=numerador+"/"+denominador;
		}
		else 
			fraccion=numerador+"";
		
		return fraccion;
	}
	
	public Fraccion sumar(Fraccion b) {
		int num=this.numerador*b.denominador+this.denominador*b.numerador;
		int den=this.denominador*b.denominador;
		Fraccion suma=new Fraccion(num,den);
		return suma;
		
	}
	public static Fraccion suma(Fraccion a,Fraccion b) {
		int num=a.numerador*b.denominador+a.denominador*b.numerador;
		int den=a.denominador*b.denominador;
		Fraccion suma=new Fraccion(num,den);
		return suma;	
	}
	
	public Fraccion restar(Fraccion b) {
		int num=this.numerador*b.denominador-this.denominador*b.numerador;
		int den=this.denominador*b.denominador;
		Fraccion resta=new Fraccion(num,den);
		return resta;
		
	}
	public Fraccion multiplicar(Fraccion b) {
		int num=this.numerador*b.numerador;
		int den=this.denominador*b.denominador;
		Fraccion multiplicar=new Fraccion(num,den);
		return multiplicar;
		
	}
	public Fraccion dividir(Fraccion b) {
		int num=this.numerador*b.denominador;
		int den=this.denominador*b.numerador;
		Fraccion dividir=new Fraccion(num,den);
		return dividir;
		
	}
	private static int mcd (int u, int v) {
		if (u % v == 0)
			return v;
		else 
			return mcd (v, u%v);
	}
	
	public Fraccion simplificar() {
		int a=mcd(Math.abs(numerador),Math.abs(denominador));
		int num=numerador/a;
		int den=denominador/a;
		Fraccion nueva=new Fraccion(num,den);
		return nueva;
	
	}
	
}



