package org.mp.sesion01;

public class Baraja {

	private String nombreBaraja;
	private Carta[] cartas;
	
	
	public Baraja(String nombreBaraja, Carta[] cartas) {
		this.setNombreBaraja(new String(nombreBaraja));
		this.cartas=cartas;
		}
	
	
	public Carta[] getCartas() {
		return this.cartas;
	}
	
	public void insercion(Carta[] cartas2) {
		
		for(int i=1;i<cartas2.length;i++) {
			Carta aux=cartas2[i];
			int j;
			for(j=i-1; j>=0 && aux.compareTo(cartas[j])<0;j--) {
				cartas2[j+1]=cartas2[j];
				
			}
			cartas2[j+1]=aux;
		}
		
		
	}


	public String getNombreBaraja() {
		return nombreBaraja;
	}


	public void setNombreBaraja(String nombreBaraja) {
		this.nombreBaraja = nombreBaraja;
	}

	
}
