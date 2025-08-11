package org.ip.sesion07;

public class Disco extends Multimedia {
	
	public enum Genero { pop, rock, soul, funky, jazz, blues, tecno, hiphop, punk, ambient, classic, bso , flamenco }
	
	private Genero genero;
	private int numeroCanciones;
	
	public Disco(String titulo, String autor, Formato formato, double duracion, Genero genero, int numeroCanciones) {
		super(titulo, autor,formato,duracion);
		this.genero=genero;
		this.numeroCanciones=numeroCanciones;
	}
	
	public Disco(Disco disco) {
		super(disco);
		this.genero=disco.genero;
		this.numeroCanciones=disco.numeroCanciones;
	}
	
	public Genero getGenero() {
		return this.genero;
	}
	
	public void setGenero(Genero genero) {
		this.genero=genero;
	}
	
	public int getNumeroCanciones() {
		return this.numeroCanciones;
	}
	
	public void setNumeroCnaciones(int numeroCanciones) {
		this.numeroCanciones=numeroCanciones;
	}
	
	public String toString() {
		String palabra=("  Disco {genero: "+genero+" y numero de canciones: "+numeroCanciones+"}"); 
		return palabra;
	}
	
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		if(obj==this) {
			return true;
		}
		if (!(obj instanceof Disco))
			return false;

		Disco otro = (Disco) obj;

		if (this.genero == otro.genero && this.numeroCanciones == otro.numeroCanciones)
			return true;
		else
			return false;
	}
}
