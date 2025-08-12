package org.mp.sesion02;

import java.util.GregorianCalendar;

public class Profesor extends Empleado {
	
	private String tutorias;
	private String categoria;
	
	public  Profesor(String nombre , String direccion, String telefono, String email, String despacho, int salario,
			GregorianCalendar fechaContratacion, String tutorias, int categoria) {
		super(nombre, direccion, telefono,email,despacho,salario,fechaContratacion);
		this.tutorias=new String (tutorias);
		switch(categoria) {
		case 1: this.categoria = "Ayudante"; break;
		case 2: this.categoria = "Titular de Universidad";break;
		case 3: this.categoria = "Catedrático de Universidad";break;
	
		
		}
	}
		
		public String toString() {
			return "Profesor "+this.categoria+"\n"+super.toString()+"\nHorario = "+this.tutorias;
		}
		
		
		
	}


