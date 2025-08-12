package org.mp.sesion02;

public class Estudiante extends Persona{
	
	private String nivel;
	
	public Estudiante(String nombre,String direccion, String telefono, String email, int nivel) {
		super(nombre,direccion,telefono,email);
		switch (nivel) {
		case 1: this.nivel = "Grado"; break;
		case 2: this.nivel = "Máster"; break;
		case 3: this.nivel = "Doctorado"; break;
		} 
		
	}
	
	public String toString() {
		return "Estudiante de "+this.nivel+"\n"+super.toString();
	}

}
