package org.ip.sesion08;

public class AsignaturaNota implements Comparable<Object> {

	private String asignatura;
	private double nota;
	
	public AsignaturaNota () {
		asignatura = "";
		nota = 0;
	}
	
	public AsignaturaNota (String asignatura, double nota) {
		this.asignatura = asignatura;
		this.nota = nota;
	}
	
	public AsignaturaNota (String asignatura) {
		this.asignatura = asignatura;
		this.nota = 0;
	}
	
	public AsignaturaNota (AsignaturaNota asignaturaNota) {
		this.asignatura = asignaturaNota.asignatura;
		this.nota = asignaturaNota.nota;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	

	public String toString () {
		return "(" + asignatura + ", " + nota + ")";
	}
	
	public boolean equals (Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if ( ! (obj instanceof AsignaturaNota))
			return false;
		AsignaturaNota an = (AsignaturaNota) obj;
		if (this.asignatura.equals(an.asignatura) && this.nota == an.nota)
			return true;
		return false;
	}
	
	public int compareTo (Object obj) {
		AsignaturaNota an = (AsignaturaNota) obj;
		if (this.nota < an.nota)
			return -1;
		if (this.nota > an.nota)
			return +1;
		return this.asignatura.compareTo(an.asignatura);
	}
}
