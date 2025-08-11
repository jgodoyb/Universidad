package org.ip.sesion06;

public class EcuacionCuadratica {
	
	private double a;
	private double b;
	private double c;
	private static int numEcuacionesCuadraticas=0;
	
	public EcuacionCuadratica(double a,double b,double c) {
		this.a=a;
		this.b=b;
		this.c=c;
		numEcuacionesCuadraticas++;
	}
	
	public EcuacionCuadratica(EcuacionCuadratica ecuacion) {
		this.a=ecuacion.a;
		this.b=ecuacion.b;
		this.c=ecuacion.c;
		numEcuacionesCuadraticas++;
	}
	
	public double getA() {
		return a;
	}
	
	public void setA(double a) {
		this.a=a;
	}
	
	public double getB() {
		return b;
	}
	
	public void setB(double b) {
		this.b=b;
	}
	
	public double getC() {
		return c;
	}
	
	public void setC(double c) {
		this.c=c;
	}
	
	public static int getNumEcuacionesCuadraticas() {
		return numEcuacionesCuadraticas;
	}
	
	public String toString() {
		String x=("Ecuacion Cuadratica: (a="+a+", b="+b+", c="+c+")");
		return x;
	}
	
	public double getDiscriminante() {
		return (Math.pow(b, 2)-4*a*c);
	}
	
	public double getRaiz1() {
		double d, x;
		
		d = getDiscriminante();
		x = (-b + Math.sqrt(d)) / (2 * a);
		return x;
	}
	
	public double getRaiz2() {
		double d, x;
		
		d = getDiscriminante();
		x = (-b - Math.sqrt(d)) / (2 * a);
		return x;
		
	}
	
	
	
	
	
	

}
