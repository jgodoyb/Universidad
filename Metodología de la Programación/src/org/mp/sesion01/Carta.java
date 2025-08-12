package org.mp.sesion01;

public class Carta implements Comparable<Object> {

	private String palo;
	private int numero;
	private int valor;
	
	/**
	 * @see ola
	 * @param cartas
	 */
	public Carta(Carta cartas) {
		this.palo=new String(cartas.palo);
		this.numero=cartas.numero;
		this.valor=cartas.valor;
	}

	
	public Carta(String palo, int numero) {
		this.palo=new String(palo);
		this.numero=numero;
		this.valor=0;
		switch(palo) {
		case "B": this.valor++;
		case "E": this.valor++;
		case "C": this.valor++;
		
		}
		this.valor=12*valor+numero;
		
	}
	
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null) {
			return false;
		}
		if(getClass()!=obj.getClass()) {
			return false;
		}
		Carta a=(Carta) obj;
		return this.valor == a.valor;
	}

	public int getValor() {
		return this.valor;
	}
	
	public int getNumero() {
		return this.numero;
	}

	public String getPalo() {
		return this.palo;
	}

	@Override
	public int compareTo(Object o) {
		Carta a=(Carta)o;
		return Integer.compare(this.valor,a.valor);
		
	}
		
	}
