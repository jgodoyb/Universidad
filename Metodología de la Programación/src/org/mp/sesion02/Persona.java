package org.mp.sesion02;

public class Persona {
	
	private String nombre,direccion,telefono,email;
	
	
	public Persona(String nombre, String direccion, String telefono, String email) {
		this.nombre = new String(nombre);
		this.direccion = new String(direccion);
		this.telefono = new String(telefono);
		this.email = new String(email);
		
	}
	
	public String toString() {
		return "Nombre = "+this.nombre+", Dirección = "+this.direccion+", Teléfono = "+this.telefono+", email = "+this.email;
	}

}
