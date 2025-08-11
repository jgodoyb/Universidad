package org.ip.sesion06;

public class Reloj {
	
	private int hora;
	private int minuto;
	private int segundo;
	
	public Reloj() {
		hora=0;
		minuto=0;
		segundo=0;
	}
	
	public Reloj(int hora,int minuto,int segundo) {
		this.hora=hora;
		this.minuto=minuto;
		this.segundo=segundo;
	}
	
	public Reloj(Reloj reloj) {
		this.hora=reloj.hora;
		this.minuto=reloj.minuto;
		this.segundo=reloj.segundo;
	}
	
	
	public int getHora() {
		return hora;
	}
	
	public void setHora(int hora) {
		if(hora<24 && hora>=0) {
			this.hora=hora;
		}else {
			this.hora=0;
		}
	}
	
	public int getMinuto() {
		return minuto;
	}
	
	public void setMinuto(int minuto) {
		if(minuto>=0 && minuto<60) {
			this.minuto=minuto;
		}else {
			this.minuto=0;
		}
	}
	
	public int getSegundo() {
		return segundo;
	}
	
	public void setSegundo(int segundo) {
		if(segundo>=0 && segundo<60) {
			this.segundo=segundo;
		}else {
			this.segundo=0;
		}
	}
	
	public void mostrarReloj() {
		if (hora < 10)
			System.out.print("0"+hora+":");
		else 
			System.out.print(hora+":");
		if (minuto < 10)
			System.out.print("0"+minuto+":");
		else 
			System.out.print(minuto+":");
		if (segundo < 10)
			System.out.print("0"+segundo);
		else 
			System.out.print(segundo);
		System.out.println();
	}
	public void incrementaHora() {
		hora++;
		if(hora==24) {
			hora=0;
		}
	}
	
	public void incrementaMinuto() {
		minuto++;
		if(minuto==60) {
			minuto=0;
			incrementaHora();
		}
	}
	
	public void incrementaSegundo() {
		segundo++;
		if(segundo==60) {
			segundo=0;
			incrementaMinuto();
		}
	}
	

}
