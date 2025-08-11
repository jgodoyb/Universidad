package org.ip.sesion06;

public class Circulo {
	
	private double xCentro;
	private double yCentro;
	private double radio;
	private static int numCirculos=0;
	
	public Circulo() {
		xCentro=0.0;
		yCentro=0.0;
		radio=0.0;
		numCirculos++;
		
	}
	 public Circulo(double xCentro, double yCentro,double radio) {
		 this.xCentro=xCentro;
		 this.yCentro=yCentro;
		 this.radio=radio;
		 numCirculos++;
	 }
	 
	 public Circulo(double xCentro, double yCentro) {
		 this.xCentro=xCentro;
		 this.yCentro=yCentro;
		 radio=0;
		 numCirculos++;
	 }
	 public Circulo(double radio) {
		 xCentro=0;
		 yCentro=0;
		 this.radio=radio;
		 numCirculos++;
		 
	 }
	 public Circulo(Circulo c) {
		 this.xCentro=c.xCentro;
		 this.yCentro=c.xCentro;
		 this.radio=c.radio;
		 numCirculos++;
	 }
	 
	 public double getXCentro() {
		 return xCentro;	
	 }
	 
	 public void setXCentro(double xCentro) {
		this.xCentro=xCentro; 
	 }
	 
	 public double getYCentro() {
		 return yCentro;
	 }
	 
	 public void setYCentro(double yCentro) {
		 this.yCentro=yCentro;
	 }
	 
	 public double getRadio() {
		 return radio;
	 }
	
	 public void setRadio(double radio) {
		 this.radio=radio;
	 }
	 
	 public static int getNumCirculos() {
		 return numCirculos;
	 }
	 
	 public String toString() {
		 String texto=("Circulo={(xCentro="+xCentro+", yCentro="+yCentro+"), radio="+radio+"}");
		 return texto;
	 }
	 
	 public boolean equals(Object obj) {
		 if (obj == null)
				return false;
			if (obj == this)
				return true;
			if ( ! (obj instanceof Circulo))
				return false;
			
			Circulo otro = (Circulo)obj;
			
			if (this.xCentro == otro.xCentro && this.yCentro == otro.yCentro && this.radio==otro.radio)
				return true;
			else 
				return false; 
	 }
	 
	 public int compareTo (Object obj) {
			Circulo c = (Circulo) obj;
			double a1 = this.calcularArea();
			double a2 = c.calcularArea();
			if (a1 < a2)
				return -1;
			else {
				if (a1 > a2)
					return +1;
				else 
					return 0;
			}
	 }
	 
	 public double calcularArea() {
		 return (Math.PI*(Math.pow(radio,2)));
	 }
	 
	 public double calcularLongitud() {
		 return(2*Math.PI*radio);
	 }
	 public double calcularDiametro() {
		 return (2*radio);
	 }
	 
}
