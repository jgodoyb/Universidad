package org.ip.sesion07;

public class Multimedia {
	
	public enum Formato { wav, mp3, midi, avi, mov, mpg, cdAudio , dvd }
	
	private String titulo;
	private String autor;
	private Formato formato;
	private double duracion;
	
	public Multimedia(String titulo, String autor, Formato formato, double duracion) {
		this.titulo=titulo;
		this.autor=autor;
		this.formato=formato;
		this.duracion=duracion;
	}
	
	public Multimedia(Multimedia obj) {
		this.titulo=obj.titulo;
		this.autor=obj.autor;
		this.formato=obj.formato;
		this.duracion=obj.duracion;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo=titulo;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public void setAutor(String autor) {
		this.autor=autor;
	}
	
	public Formato getFormato() {
		return this.formato;
	}
	
	public void setFormato(Formato formato) {
		this.formato=formato;
	}
	
	public double getDuracion() {
		return duracion;
	}
	
	public void setDuracion(double duracion) {
		this.duracion=duracion;
	}
	
	public String toString() {
		String objecto=("Objeto Multimedia [titulo: "+titulo+", de: "+autor+", con formato: "+formato+", duracion: "+duracion+" min.seg] ");
		return objecto;
	}
	
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof Multimedia))
			return false;

		Multimedia otro = (Multimedia) obj;

		if (this.autor == otro.autor && this.titulo == otro.titulo && this.formato == otro.formato && this.duracion==otro.duracion)
			return true;
		else
			return false;
	
	}
	
	

}
