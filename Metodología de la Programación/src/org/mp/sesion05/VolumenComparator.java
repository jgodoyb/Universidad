package org.mp.sesion05;

import java.util.Comparator;
public class VolumenComparator implements Comparator<Accion>{
	public int compare ( Accion a1, Accion a2) {
		if(a1==a2)
			return 0;
		if(a1.getVolumen()> a2.getVolumen())
			return 1;
		if(a1.getVolumen() < a2.getVolumen())
			return -1;
		else 
			return 0;
	}
}
