package org.mp.sesion02;

public class Octogono extends ObjetoGeometrico implements Comparable<Octogono>, Cloneable, DeColor {

	protected double lado;

	public Octogono(String color, boolean relleno, double lado) {
		super(color, relleno);
		this.lado = lado;
	}

	public Octogono() {
		super();
		this.lado = 0;
	}

	public String getColor() {
		return color;
	}

	public double getLado() {
		return this.lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

	public double getPerimetro() {
		return 8 * lado;
	}

	public double getArea() {
		return (2 + 4 / Math.sqrt(2)) * lado * lado;
	}

	public int compareTo(Octogono o) {
		return Double.compare(this.lado, o.lado);

	}

	public Object clone(){
		try {
			
			Octogono otro = (Octogono) super.clone();
			return otro;
		}catch (CloneNotSupportedException ex) {
			return null;
		}
	}

	@Override
	public String comoColorear() {
		
		return "Colorear los 8 lados de "+this.color;
	}

}
