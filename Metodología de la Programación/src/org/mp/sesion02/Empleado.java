package org.mp.sesion02;

import java.util.GregorianCalendar;

public class Empleado extends Persona{
	
	
	private String despacho;
	private int salario;
	private GregorianCalendar fechaContratacion;
	
	
	public Empleado(String nombre, String direccion, String telefono, String email, String despacho, int salario, GregorianCalendar fechaContratacion) {
		super(nombre, direccion, telefono,email);
		this.despacho =new String(despacho);
		this.salario=salario;
		this.fechaContratacion=fechaContratacion;
		
	}
	
	public String toString() {
		return super.toString()+ "\n"+"Despacho = "+this.despacho +", salario = "+this.salario+
				", Fecha de contratación = "+this.fechaContratacion.get(GregorianCalendar.DAY_OF_MONTH)+"/"+
				(this.fechaContratacion.get(GregorianCalendar.MONTH)+1)+
				"/"+this.fechaContratacion.get(GregorianCalendar.YEAR);
	}
	
	

}
