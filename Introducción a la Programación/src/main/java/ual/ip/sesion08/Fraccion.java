package org.ip.sesion08;

@SuppressWarnings("rawtypes")
public class Fraccion implements Comparable{
	
	private int numerador;
	private int denominador;
	
	public Fraccion() {
		numerador=0;
		denominador=1;
	}
	
	public Fraccion(int numerador,int denominador) {
		this.numerador=numerador;
		this.denominador=denominador;
	}
	
	public Fraccion(Fraccion frac) {
		this.numerador=frac.numerador;
		this.denominador=frac.denominador;
	}
	
	public int getNumerador() {
		return this.numerador;
	}
	
	public void setNumerador(int numerador) {
		this.numerador=numerador;
	}
	
	public int getDenominador() {
		return this.denominador;
	}
	
	public void setDenominador(int denominador) {
		this.denominador=denominador;
	}
	
	public String toString() {
		String numero=(numerador+"/"+denominador);
		return numero;
	}
	
	public boolean equals(Object obj) {
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
	@Override
	public int compareTo(Object o) {
		Fraccion f = (Fraccion) o;
		double f1 = (double) this.numerador / this.denominador;
		double f2 = (double) f.numerador / f.denominador;
		if (f1 < f2)
			return -1;
		if (f1 > f2)
			return +1;
		return 0;
	}
	
	

	
	

}
