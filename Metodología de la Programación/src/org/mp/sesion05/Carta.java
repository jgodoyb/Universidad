package org.mp.sesion05;

/**
 * Clase que permite crear objetos de tipo Carta e implemena la interface Comparable.
 * @author Jorge Godoy Beltrán
 *
 */
public class Carta implements Comparable <Object> {
	
	private String palo;
	private int numero;
	private int valor;
	
	/**
	 * Metodo de tipo Carta 
	 * @param palo variable de tipo String que almacena el palo de la baraja.
	 * @param numero variable de tipo entero que almacena el numero de la carta.
	 */
	public Carta(String palo, int numero) {
		this.palo = new String(palo);
		this.numero = numero;
		switch (palo) {
		case "O":
			this.valor = numero;
			break;
		case "C":
			this.valor= numero + 12;
			break;
		case "E":
			this.valor= numero +24;
			break;
		case "B":
			this.valor= numero +36;
			break;
		}
		
	}

/**
 * Getter que devuelve el valor de las cartas
 * @return devuelve el valor de las cartas.
 */
	public int getValor() {
		// TODO Auto-generated method stub
		return valor;
	}

	/**
	 * Getter que devuelve el palo de las cartas.
	 * @return devuelve el palo.
	 */
	public String getPalo() {
		// TODO Auto-generated method stub
		return palo;
	}

	/**
	 * Getter que devuelve el numero de las cartas.
	 * @return devuelve el numero.
	 */
	public int getNumero() {
		// TODO Auto-generated method stub
		return numero;
	}

	/**
	 * Metodo boolean que iguala los objetos.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		if (numero != other.numero)
			return false;
		if (palo == null) {
			if (other.palo != null)
				return false;
		} else if (!palo.equals(other.palo))
			return false;
		if (valor != other.valor)
			return false;
		return true;
	}
	
	/**
	 * Metodo compareTo que compara los objetos de la clase.
	 */
	@Override
	public int compareTo(Object obj) {
		Carta otro= (Carta)obj;
		if(this.valor> otro.valor)
			return 1;
		else if (this.valor < otro.valor)
			return -1;
		else return 0;
		
	}
}
