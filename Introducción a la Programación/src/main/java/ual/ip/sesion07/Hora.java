package org.ip.sesion07;

public class Hora {
	
	protected int hora;
	protected int minuto;
	
	public Hora(int hora, int minuto) {
		if(hora>=0 && hora<24) {
			this.hora=hora;
		}else {
			this.hora=0;
		}
		if (minuto>=0 && minuto<60) {
			this.minuto=minuto;
		}else {
			this.minuto=0;
		}
	}
	
	public void incrementar() {
		minuto++;
		if(minuto>=60) {
			minuto=0;
			hora++;
			if(hora>=24) {
				hora=0;
			}
		}
	}
	
	public void setHora(int hora) {
		if(0<=hora && hora>=23) {
			this.hora=hora;
		}	
	}
	
	public int getHora() {
		return hora;	
	}
	
	public void setMinuto(int minuto) {
		if(0<=minuto && minuto>=59) {
			this.minuto=minuto;
		}
	}
	
	public int getMinuto() {
		return minuto;
	}
	
	public String toString() {
		String reloj=("Hora del reloj: "+hora+":"+minuto);
		
		return reloj;
		
		
	}

}
