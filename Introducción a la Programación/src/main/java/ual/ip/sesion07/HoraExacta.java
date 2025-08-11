package org.ip.sesion07;

@SuppressWarnings("rawtypes")
public class HoraExacta extends Hora implements Comparable {

	protected int segundo;

	public HoraExacta(int hora, int minuto, int segundo) {
		super(hora, minuto);
		if (segundo >= 0 && segundo <= 59) {
			this.segundo = segundo;
		} else {
			this.segundo = 0;
		}
	}

	public void setSegundo(int segundo) {
		if (segundo >= 0 && segundo <= 59) {
			this.segundo = segundo;
		}
	}

	public int getSegundo() {
		return this.segundo;
	}

	public void incrementar() {
		segundo++;
		if (segundo == 60) {
			segundo = 0;
			minuto++;
			if (minuto == 60) {
				minuto = 0;
				hora++;
				if (hora == 24) {
					hora = 0;
				}
			}
		}
	}

	public String toString() {
		String reloj3 = (hora + ":" + minuto + ":" + segundo);
		return reloj3;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof HoraExacta))
			return false;

		HoraExacta otro = (HoraExacta) obj;

		if (this.hora == otro.hora && this.minuto == otro.minuto && this.segundo == otro.segundo)
			return true;
		else
			return false;
	}
	
@Override
	public int compareTo(Object obj) {
		HoraExacta a = (HoraExacta) obj;
		if (this.hora > a.hora) {
			return +1;
		}
		if (this.hora < a.hora) {
			return -1;
		}

		if (this.minuto > a.minuto) {
			return +1;
		}
		if (this.minuto < a.minuto) {
			return -1;
		}

		if (this.segundo > a.segundo) {
			return +1;
		}
		if (this.segundo < a.segundo) {
			return -1;
		}
		
		return 0;

	}

}
