package org.mp.sesion02;

import java.util.GregorianCalendar;

public class Administrativo extends Empleado{
	
	private String unidad;
	
	public Administrativo(String nombre,String direccion , String telefono,String email,String despacho, int salario,
			GregorianCalendar fechaContratacion, String unidad) {
		
		super(nombre,direccion,telefono,email,despacho,salario,fechaContratacion);
		this.unidad= new String(unidad);
	}
	
	public String toString() {
		return "Administrativo\n"
				+ super.toString()+"\n"
				+ "Destinado en la unidad "+this.unidad;
	}
}
