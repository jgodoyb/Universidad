package org.ip.sesion07;

public class Hora12 extends Hora {
	
	public enum Meridiano { AM, PM }
	protected Meridiano mer;

	
	public Hora12(int hora, int minuto, Meridiano mer) {
		super (hora,minuto);
		if(1>hora || hora>12) {
			this.hora=1;	
		}
		this.mer=mer;
	}
	public void setHora(int hora) {
		if(1>=hora && hora<=12) {
			this.hora=hora;
		}
		
	}
	public void incrementar() {
		minuto++;
		if(minuto==60) {
			minuto=0;
			hora++;
			if(hora==13) {
				hora=1;
				if(mer==Meridiano.AM) {
					mer=Meridiano.PM;
				}else {
					mer=Meridiano.AM;	
				}
			}
		}
		
		
	}
	public String toString() {
		String reloj2=("Hora del reloj12: "+hora+":"+minuto+" "+mer);
		return reloj2;
		
		
	}
}
