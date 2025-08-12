package org.mp.sesion02;

import java.util.GregorianCalendar;

public abstract class ObjetoGeometrico {
	
	protected String color;
	protected boolean relleno;
	protected GregorianCalendar fechaCreado;
	
	
	public  ObjetoGeometrico() {
		this("blanco", false);
	}
	
	public ObjetoGeometrico(String color, boolean relleno) {
		this.fechaCreado=new GregorianCalendar();
		this.color=new String (color);
		this.relleno=relleno;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color)	{
		this.color=new String(color);
	}
	
	public boolean esRelleno() {
		return this.relleno;
	}
	
	public void setRelleno(boolean relleno) {
		this.relleno=relleno;
	}
	
	public GregorianCalendar getFechaCreado() {
		return this.fechaCreado;
	}
	
	public String toString() {
		return "Creado el " +fechaCreado + "\ncolor: "+this.color+" y relleno: "+this.relleno;
	}
	
	public abstract double getPerimetro();
		
	public abstract double getArea();
		
	
	


}