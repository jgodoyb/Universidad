package org.ip.sesion07;

public class Pelicula extends Multimedia{
	
	private String actorPrincipal;
	private String actrizPrincipal;
	
	public Pelicula(String titulo, String autor, Formato formato, double duracion, String actor, String actriz) {
		super(titulo, autor, formato, duracion);
		this.actorPrincipal=actor;
		this.actrizPrincipal=actriz;
	}
	
	public Pelicula(Pelicula pelicula) {
		super(pelicula);
		this.actorPrincipal=pelicula.actorPrincipal;
		this.actrizPrincipal=pelicula.actrizPrincipal;
	}
	
	public String getActorPrincipal() {
		return this.actorPrincipal;
	}
	
	public void setActorPrincipal(String actorPrincipal) {
		this.actorPrincipal=actorPrincipal;
	}
	
	public String getActrizPrincipal() {
		return this.actrizPrincipal;
	}
	
	public void setActrizPrincipal(String actizPrincipal) {
		this.actrizPrincipal=actizPrincipal;
	}
	
	public String toString() {
		String frase=("  Pelicula {protagonizada por: {"+actorPrincipal+" y "+actrizPrincipal+"}");
		return frase;
	}
	
	public boolean equals(Object obj) {
		if(obj==null) {
			return false;
		}
		if(obj==this) {
			return true;
		}
		if (!(obj instanceof Pelicula))
			return false;

		Pelicula otro = (Pelicula) obj;

		if (this.actorPrincipal == otro.actorPrincipal && this.actrizPrincipal == otro.actrizPrincipal)
			return true;
		else
			return false;
	}
	
	
	

}
