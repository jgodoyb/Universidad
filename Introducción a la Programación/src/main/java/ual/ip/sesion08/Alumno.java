package org.ip.sesion08;

public class Alumno implements Comparable<Object> {

	private String idPersonal;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private AsignaturaNota []notasFinales;
	private int numAsignaturas;
	private double notaMediaFinal;
	
	public Alumno (String idPersonal, String nombre, String primerApellido, String segundoApellido,
					AsignaturaNota []notasFinales) {
		this.idPersonal = idPersonal;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		setNotasFinales(notasFinales);
	}
	
	public Alumno (String idPersonal, String nombre, String primerApellido, String segundoApellido) {
		this.idPersonal = idPersonal;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.notasFinales = null; 
		this.numAsignaturas = 0;
		this.notaMediaFinal = 0;
	}
	
	public Alumno (Alumno alumno) {
		this.idPersonal = alumno.idPersonal;
		this.nombre = alumno.nombre;
		this.primerApellido = alumno.primerApellido;
		this.segundoApellido = alumno.segundoApellido;
		setNotasFinales (alumno.notasFinales);
		this.numAsignaturas = alumno.numAsignaturas;
		this.notaMediaFinal = alumno.notaMediaFinal;
	}

	public String getIdPersonal() {
		return idPersonal;
	}

	public void setIdPersonal(String idPersonal) {
		this.idPersonal = idPersonal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public int getNumAsignaturas() {
		return numAsignaturas;
	}

	public AsignaturaNota[] getNotasFinales() {
		return notasFinales;
	}

	public void setNotasFinales(AsignaturaNota[] notasFinales) {
		this.notasFinales = new AsignaturaNota[notasFinales.length];
		for (int i=0; i<notasFinales.length; i++) {
			this.notasFinales[i] = new AsignaturaNota(notasFinales[i]);
		}
		this.numAsignaturas = notasFinales.length;
		double suma = 0;
		for (int i=0; i<notasFinales.length; i++) {
			suma = suma + notasFinales[i].getNota();
		}
		this.notaMediaFinal = suma / numAsignaturas;
	}

	public double getNotaMediaFinal() {
		return notaMediaFinal;
	}
	
	public boolean pasarDeCurso() {
		for (int i=0; i<numAsignaturas; i++) {
			if (notasFinales[i].getNota() < 4.5)
				return false;
		}
		if (notaMediaFinal >= 5)
			return true;
		return false;
	}
	
	
	public String obtenerListadoNotasAsignaturas () {
		String cadena = "Asignaturas y Notas:" + "\n";
		for (int i=0; i<notasFinales.length; i++) {
			cadena = cadena + "  " + notasFinales[i].toString(); 
			if (i < notasFinales.length - 1)
				cadena = cadena + "\n";
		}
		return cadena;
	}
	public String toString () {
		String cadena = "Alumno:\n"+
						"  idPersonal: "+idPersonal+"\n"+
						"  Nombre: "+nombre+"\n"+
						"  Primer Apellido: "+primerApellido+"\n"+
						"  Segundo Apellido: "+segundoApellido+"\n"+
						"  Numero de asignaturas: "+numAsignaturas+"\n"+
						"  Nota Media Final: "+notaMediaFinal+"\n"+
						"  [";
		for (int i=0; i<numAsignaturas; i++) {
			cadena = cadena + notasFinales[i];
			if (i < numAsignaturas - 1)
				cadena = cadena + "; ";
		}
		cadena = cadena + "]";
		return cadena;
	}
	
	public boolean equals (Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if ( ! (obj instanceof Alumno))
			return false;
		Alumno otro = (Alumno) obj;
		return this.idPersonal.equals(otro.idPersonal);
	}
	
	public int compareTo (Object obj) {
		Alumno otro = (Alumno) obj;
		if (this.notaMediaFinal < otro.notaMediaFinal)
			return -1;
		if (this.notaMediaFinal > otro.notaMediaFinal)
			return +1;
		return 0;
	}
}
	




