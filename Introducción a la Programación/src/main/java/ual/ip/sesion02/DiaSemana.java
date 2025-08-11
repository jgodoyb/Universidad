package org.ip.sesion02;

public class DiaSemana {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int m,d,y,y0,x,m0,d0;
		
		d=13;
		m=10;
		y=2002;
		
		y0=y-((14-m)/12);
		x=y0+(y0/4)-(y0/100)+(y0/400);
		m0=m+12*((14-m)/12)-2;
		d0=(d+x+(31*m0)/12)%7;
		
		System.out.println("El dia de la semana correspondiente al "+d+"/"+m+"/"+y+"\n");
		
		switch(d0) {
		case 0:
			System.out.println("DOMINGO");
			break;
			
		case 1:
			System.out.println("LUNES");
			break;
		case 2:
			System.out.println("MARTES");
			break;
		case 3:
			System.out.println("MIERCOLES");
			break;
		case 4:
			System.out.println("JUEVES");
			break;
		case 5:
			System.out.println("VIERNES");
			break;
		case 6:
			System.out.println("SABADO");
			break;
		
		}
		
	
	}

}
