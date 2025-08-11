package org.ip.sesion07;

import org.ip.sesion08.Fraccion;

public class Fraccion2 implements Comparable{
	
	
	private int numerador;
	private int denominador;
	
	public Fraccion2() {
		numerador=1;
		denominador=0;
	}
	
	public Fraccion2(int numerador, int denominador) {
		this.numerador=numerador;
		this.denominador=denominador;
	}
	
	public Fraccion2(Fraccion2 frac) {
		Fraccion2 a = new Fraccion2(frac.denominador,frac.numerador);
		
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
		return (this.numerador+ "/"+this.denominador);
	}
	
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		if(obj==this) {
			return true;
		}
		if(!(obj instanceof Fraccion2)) {
			return false;
		}
		
		Fraccion2 a=(Fraccion2)obj;
		
		if(this.numerador==a.numerador && this.denominador==a.denominador) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static Fraccion2 sumar(Fraccion a, Fraccion b) {
		int numerador=a.getNumerador()*b.getDenominador()+a.getDenominador()*b.getNumerador();
		int denominador=a.getDenominador()*b.getDenominador();
		Fraccion2 suma=  new Fraccion2(numerador,denominador);
		return suma;
	}
	
	public Fraccion2 sumar(Fraccion a) {
		int numerador=this.numerador*a.getDenominador()+this.denominador*a.getNumerador();
		int denominador=this.denominador*a.getDenominador();
		Fraccion2 suma2= new Fraccion2(numerador,denominador);
		return suma2;
	}
	
	public Fraccion2 restar(Fraccion b) {
		int numerador=this.numerador*b.getDenominador()-this.denominador*b.getNumerador();
		int denominador=this.denominador*b.getDenominador();
		Fraccion2 resta = new Fraccion2(numerador,denominador);
		return resta;
	}
	
	public int compareTo(Object obj) {
		Fraccion2 a = (Fraccion2)obj;
		if((double)a.getNumerador()/a.getDenominador()>(double)this.numerador/this.denominador) {
			return -1;
		}
		if((double)a.getNumerador()/a.getDenominador()<(double)this.numerador/this.denominador) {
			return 1;
			}
		
		return 0;
	}
	
	
				
				
			
	

}
