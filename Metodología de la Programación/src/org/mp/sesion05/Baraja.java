package org.mp.sesion05;

import java.util.Random;

/**
 * Clase que permite crear objetos de tipo Baraja.
 * @author Jorge Godoy Beltrán
 *
 */
public class Baraja {
	
	private String nombreBaraja;
	private Carta[] cartas;

	/**
	 * Constructor que crea la baraja 
	 * @param nombreBaraja variable de tipo String que almacena el nombre de las cartas.
	 * @param cartas variable de tipo carta que almacena las cartas.
	 */
	public Baraja(String nombreBaraja, Carta[] cartas) {
		// TODO Auto-generated constructor stub
		this.nombreBaraja = new String (nombreBaraja);
		this.cartas = new Carta[cartas.length];
		for(int i = 0; i < cartas.length; i++) {
			this.cartas[i] =new Carta(cartas[i].getPalo(), cartas[i].getNumero());
		}
	}

	/**
	 * Getter que devuelve las cartas.
	 * @return devuelve un string con las cartas.
	 */
	public Carta[] getCartas() {
		// TODO Auto-generated method stub
		return cartas;
	}

	/**
	 * Metodo de tipo void que permite una insercion
	 * @param cartas variable de tipo carta que almacena las cartas.
	 */
	public void insercion(Carta[] cartas) {
		// TODO Auto-generated method stub
		for(int i = 0; i < cartas.length; i++) {
			Carta otro = cartas[i];
			int j;
			for(j= i - 1; j >= 0 && otro.compareTo(cartas[j]) < 0; j--) {
				cartas[j + 1]= cartas[j];
			}
			cartas [j + 1] = otro;
		}
	}

}
